package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;
import com.google.gson.Gson;



public class EditAgingBucket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditAgingBucket() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean rowUpdated = false;
		String agingBucket = request.getParameter("agingBucket");
		String docId = request.getParameter("docId");
		WinterInternshipDAO ob = new WinterInternshipDAO();
		
		try {
			
			//query to set the predicted aging bucket value into the table
			String query="UPDATE winter_internship SET aging_bucket ='"+ agingBucket+"' WHERE doc_id="+docId+";";
	    	System.out.println(query);
	    	rowUpdated = ob.editAgingBucket(query);
	    	
	    	
	    	
	    	
	    	//sending response to frontend
			response.setStatus(200); //If response if successful, it will pass 200 as status
			response.setContentType("application/json"); //Contents set into json
			response.getWriter().println(new Gson().toJson(rowUpdated)); //Sending value to frontend as json
		
		
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}