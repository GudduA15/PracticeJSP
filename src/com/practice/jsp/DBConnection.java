package com.practice.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() {
		String dbDriver="com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/world";
		
		String username = "root";
		String password = "root";
		Connection cn = null;
		
		try {
			Class.forName(dbDriver);
			cn = DriverManager.getConnection(dbUrl, username, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cn;
	}

}
