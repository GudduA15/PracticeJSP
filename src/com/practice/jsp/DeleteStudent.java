package com.practice.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.valueOf(req.getParameter("ID"));
		
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "delete from student where id =" + id;
			int count = stmt.executeUpdate(sql);
			System.out.println("delete student ::" + count);
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		resp.sendRedirect(req.getContextPath());
	}
}
