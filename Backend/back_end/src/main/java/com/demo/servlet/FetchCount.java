package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;

import com.google.gson.Gson;

public class FetchCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FetchCount() {
        super();
    }

    //For finding total number of rows
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WinterInternshipDAO user = new WinterInternshipDAO();
		try {
			int count = user.fetchCount();
				
			//sending response to frontend
			response.setStatus(200); //If response if successful, it will pass 200 as status
			response.setContentType("application/json"); //Contents set into json
			response.getWriter().println(new Gson().toJson(count)); //Sending value to frontend as json
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
