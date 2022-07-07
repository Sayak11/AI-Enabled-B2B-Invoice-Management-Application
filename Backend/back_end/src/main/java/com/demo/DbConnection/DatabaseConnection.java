package com.demo.DbConnection;

import java.sql.*;

public class DatabaseConnection {
	public static Connection createConnect() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/grey_goose";
		String userName = "root";   //Username
		String pwd = "Sayaksrc11";  //Password
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, userName, pwd);        //Establishing DB Connection
			System.out.println("Post establishing a DB connection - "+con);
			
		}
		catch(SQLException e)
		{
			System.out.println("Error Occurred");
			e.printStackTrace();
		}
		return con;
		
	}
}

