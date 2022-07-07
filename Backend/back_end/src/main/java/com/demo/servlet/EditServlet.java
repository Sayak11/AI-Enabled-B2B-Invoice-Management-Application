package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.*;
import com.demo.pojo.WinterInternshipPojo;
import com.google.gson.Gson;

public class EditServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		public EditServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }


		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			boolean rowUpdated = false;
			
			String slNo = request.getParameter("slNo");

	    	String invoiceCurrency = request.getParameter("invoiceCurrency");

	    	String custPaymentTerms = request.getParameter("custPaymentTerms");
			
					
	    	WinterInternshipDAO ob = new WinterInternshipDAO();	    	
	    	
	    	
			try {
				
				//Query declared for EDIT operation
				String que1="UPDATE winter_internship SET invoice_currency='"+ invoiceCurrency+"', cust_payment_terms ='"+ custPaymentTerms+"' WHERE sl_no="+slNo+";";
		    	System.out.println(que1);
		    	rowUpdated = ob.editWinterInternship(que1);
		    	
		    	//sending response to frontend
				response.setStatus(200);  //If response if successful, it will pass 200 as status
				response.setContentType("application/json"); //Contents set into json
				response.getWriter().println(new Gson().toJson(rowUpdated)); //Sending value to frontend as json
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//response.sendRedirect("list");
			//TODO redirect response

			
		
	}
}