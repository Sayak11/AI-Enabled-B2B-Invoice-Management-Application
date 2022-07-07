package com.demo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.pojo.ChartPojo;
import com.google.gson.Gson;


public class PieData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PieData() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HashMap<Object, Object> Response = new HashMap<Object, Object>();
			ArrayList<ChartPojo> BusinessData = new ArrayList<ChartPojo>();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose", "root","Sayaksrc11");
			String query ="SELECT ROW_NUMBER() OVER (ORDER BY w.invoice_currency) AS id,invoice_currency,COUNT(*) AS count_currency FROM winter_internship w WHERE ";
			
			if(request.getParameter("clear_date1") != null && !request.getParameter("clear_date1").equals("null") && request.getParameter("clear_date2") != null && !request.getParameter("clear_date2").equals("null")) {
				query += " (w.clear_date >'"+request.getParameter("clear_date1")+"' AND "+"w.clear_date<'"+request.getParameter("clear_date2")+"') AND";
			}
			if(request.getParameter("due_in_date1") != null && !request.getParameter("due_in_date1").equals("null") && request.getParameter("due_in_date2") != null && !request.getParameter("due_in_date2").equals("null")) {
				query += " (w.due_in_date >'"+request.getParameter("due_in_date1")+"' AND "+"w.due_in_date<'"+request.getParameter("due_in_date2")+"') AND";
			}
			if(request.getParameter("baseline_create_date1") != null && !request.getParameter("baseline_create_date1").equals("null") && request.getParameter("baseline_create_date2") != null && !request.getParameter("baseline_create_date1").equals("null")) {
				query += " (w.baseline_create_date >'"+request.getParameter("baseline_create_date1")+"' AND "+"w.baseline_create_date<'"+request.getParameter("baseline_create_date2")+"') AND";
			}
			if(request.getParameter("invoice_currency") != null && !request.getParameter("invoice_currency").equals("null")) {
				query += " (invoice_currency='"+request.getParameter("invoice_currency")+"') AND";
			}
			
			int len = query.length();
			String query1 = query.substring(0, len - 4);
			query1 += " GROUP BY invoice_currency"; // Query used for plotting pie chart
			PreparedStatement ps = con.prepareStatement(query1);
			ResultSet rs = ps.executeQuery(); //query executed
			
			while (rs.next()) {
				int id = rs.getInt("id");
            	String invoice_currency=rs.getString("invoice_currency");
    	        int count_currency=rs.getInt("count_currency");
    	        System.out.println(query1);

    	        BusinessData.add(new ChartPojo (id,invoice_currency,count_currency));
            }
			Response.put("users", BusinessData);
			
			
			//sending response to frontend
			response.setStatus(200); //If response if successful, it will pass 200 as status
			response.setContentType("application/json"); //Contents set into json
			response.getWriter().println(new Gson().toJson(Response)); //Sending value to frontend as json
			
			

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}