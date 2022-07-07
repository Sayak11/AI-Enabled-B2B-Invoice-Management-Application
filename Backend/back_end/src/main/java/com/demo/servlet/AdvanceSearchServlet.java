package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;
import com.demo.pojo.WinterInternshipPojo;
import com.google.gson.Gson;

public class AdvanceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdvanceSearchServlet() {
        super();
        
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
    	WinterInternshipDAO ob = new WinterInternshipDAO();
    	List<WinterInternshipPojo> user = null;
    	String query = request.getParameter("query");
		if(!(query == null || "".contentEquals(query))) {
			query = "where "+ query;
			System.out.println(query);
		}
		
		//Query for ADVANCED SEARCH operation
		String q1 = "SELECT * FROM winter_internship "+query+";";
    	
		try {
			
			
			user = ob.getWinterInternship1(q1);
	    	System.out.println(q1);
	    	
	    	//sending response to frontend
			response.setStatus(200); //If response if successful, it will pass 200 as status
			response.setContentType("application/json"); //Contents set into json
			response.getWriter().println(new Gson().toJson(user)); //Sending value to frontend as json
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	

		
	
}

}