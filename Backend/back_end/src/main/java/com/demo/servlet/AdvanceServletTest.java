package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;
import com.demo.pojo.WinterInternshipPojo;
import com.google.gson.Gson;


//Testing Servlet for Advanced Servlet
public class AdvanceServletTest extends HttpServlet {
		private static final long serialVersionUID = 1L;

		public AdvanceServletTest() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
					
	    	WinterInternshipDAO ob = new WinterInternshipDAO();
	    	List<WinterInternshipPojo> user = null;
	    	
	    	
	    	
	    	String s = "";
	        boolean flag = false;
	        if(request.getParameter("docId") != null){
	          if(flag){
	            s = s + " and doc_id=" + request.getParameter("docId");

	          }else{
	       s = s + "doc_id=" + request.getParameter("docId");
	            flag = true;
	         }
	      }

	        if(request.getParameter("invoiceId") != null){
	          if(flag){
	            s = s + " and invoice_id=" + request.getParameter("invoiceId");
	          }else{
	       s = s + "invoice_id=" + request.getParameter("invoiceId");
	       flag = true;
	          } 
	        }

	          if(request.getParameter("custNumber") != null){
	            if(flag){
	              s = s + " and cust_number=" + request.getParameter("custNumber");
	            }else{
	         s = s + "cust_number=" + request.getParameter("custNumber");
	         flag = true;
	            } 
	    }
	    if(request.getParameter("buisnessYear") != null){
	      if(flag){
	        s = s + " and buisness_year=" + request.getParameter("buisnessYear");

	      }else{
	        s = s + "buisness_year=" + request.getParameter("buisnessYear");
	        flag = true;
	     }
	    }
	    	
	    	
	    String q1 = "SELECT * FROM winter_internship "+s+";";
	    	
	    try {
					
			user = ob.getWinterInternship(q1);
	    	System.out.println(q1);
			//user = ob.getWinterInternship(que1);
			response.setStatus(200);
			response.setContentType("application/json");
			response.getWriter().println(new Gson().toJson(user));
		
			} 
	    catch (SQLException e) {
			e.printStackTrace();
			}
    	
			
		
	}
}