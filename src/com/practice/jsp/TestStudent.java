package com.practice.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestStudent extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String form = "<!DOCTYPE html>\r\n" 
		+		"<html>\r\n"  
		+		"<head>\r\n" 
		+		"<meta charset=\"ISO-8859-1\">\r\n" 
		+		"<title>Student Addmission Form</title>\r\n"  
		+		"</head>\r\n"  
		+		"<body>\r\n" 
		+		"<h1>Please fill the Student Addmission Form</h1>\r\n"  
		+		"<form action=\"\" method=\"post\">"  
		+		"	ID : <input type=\"number\" name=\"ID\"><br>\r\n"  
		+		"	Student Name : <input type=\"text\" name=\"Student Name\"><br>\r\n"  
		+		"	Father's Name : <input type=\"text\" name=\"Father Name\"><br>\r\n"  
		+		"	Mother's Name : <input type=\"text\" name=\"Mother Name\"><br>\r\n"  
		+		"	Address : <input type=\"text\" name=\"Address\"><br>\r\n"  
		+		"	<input type=\"submit\" value =\"Submit\" >\r\n"  
		+		"\r\n" 
		+		"</form>\r\n"  
		+		"\r\n"  
		+		"</body>\r\n" 
		+		"</html>";
		 
		resp.setContentType("text/html"); 
		PrintWriter out = resp.getWriter();
		out.append(form);
		
		
			
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("ID");
		String name = req.getParameter("Student Name");
		String fatherName = req.getParameter("Father Name");
		String motherName = req.getParameter("Mother Name");
		String address = req.getParameter("Address");
		
	//	Student addmission = new Student(id, name, fatherName, motherName, address);
		
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
	
			String insert = "Insert into student (id, name, fatherName, motherName, address) " + "values ( '"+ id + "','"+ name + "' , '" + fatherName +
					"' , '" + motherName + "' , '" + address +"')";
			int count =st.executeUpdate(insert);
			System.out.println(count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath());
		
	}
}

