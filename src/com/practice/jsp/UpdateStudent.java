package com.practice.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateStudent extends HttpServlet {

/*	public static void main(String[] args) {

		try {
			Connection conn = DBConnection.getConnection();

			String sql = "update student set name=? " + " WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "sanjau");
			// pstmt.setString(2, address);
			pstmt.setInt(2, 3);

			int count = pstmt.executeUpdate(sql);
			System.out.println("Success ----" + count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Student value = (Student) req.getAttribute("key");
		//super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(":: Student update start::");

		int id = Integer.valueOf(req.getParameter("id"));
		String studentName = req.getParameter("st_name");
		String studentfName = req.getParameter("st_father");
		String studentMName = req.getParameter("st_mother");
		String address = req.getParameter("address");

		try {
			Connection conn = DBConnection.getConnection();

			String sql = "UPDATE Student SET name = '"+studentName +"' " + "WHERE id = " + id;
			Statement stmt = conn.createStatement();
/*			
 * 

			String sql = "update student set name=? where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, studentName);
			// pstmt.setString(2, address);
			pstmt.setInt(2, id);*/

			int count = stmt.executeUpdate(sql);
			System.out.println("Success ----" + count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect(req.getContextPath());
	}
}
