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

public class DeleteServlet extends HttpServlet{
	
		private static final long serialVersionUID = 1L;

		public DeleteServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String slNo = request.getParameter("slNo");

			WinterInternshipDAO user = new WinterInternshipDAO();
			try {
				
				//Query declared for DELETE operation
				String que="DELETE FROM winter_internship WHERE sl_no IN("+slNo+");";
				System.out.println(que);
				boolean rowDeleted = user.deleteWinterInternship(que);
				
				//sending response to frontend
				response.setStatus(200); //If response if successful, it will pass 200 as status
				response.setContentType("application/json"); //Contents set into json
				response.getWriter().println(new Gson().toJson(rowDeleted)); //Sending value to frontend as json
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
//			String que="DELETE FROM winter_internship WHERE sl_no IN("+slNo+");";
//			System.out.println(que);
//			response.setStatus(200);
//			response.setContentType("application/json");
//			response.getWriter().println(new Gson().toJson(true));
			
			
			
			
		}
}