package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;
import com.demo.pojo.WinterInternshipPojo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FetchServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageNo = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("size"));

		int start = (pageNo - 1)*pageSize;
		
		WinterInternshipDAO user = new WinterInternshipDAO();
		try {
			
			//Fetch all rows
			List<WinterInternshipPojo> ob = user.listAllWinterInternship(start,pageSize);
			
			//sending response to frontend
			response.setStatus(200);//If response if successful, it will pass 200 as status
			response.setContentType("application/json");//Contents set into json
			response.getWriter().println(new Gson().toJson(ob));//Sending value to frontend as json
			
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
}