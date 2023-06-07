package com.sample.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.jsp.DBConnection;

@WebServlet("/jsp/addmission")
public class AddmissionServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(":: Student addmission start::");
		
		String studentName = req.getParameter("st_name");
		String studentfName = req.getParameter("st_father");
		String studentMName = req.getParameter("st_mother");
		String address = req.getParameter("address");
		
		try {
			Connection conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			
			int pkLatest = getLatestPK() + 1;
			String sql = "insert into student values ("+ pkLatest + ",'"+ studentName + "','" +studentfName+ "','" +studentMName+ "','"+address+ "')"; 
			System.out.println(sql);
			int count = statement.executeUpdate(sql);
			
			System.out.println(count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath());
		
	}
	
	private int getLatestPK() {
		
		int pklatest =0;
		try {
			Connection conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			
			String sql = "select max(id) as count from student"; 
			System.out.println(sql);
			ResultSet resultSet = statement.executeQuery(sql); //executeUpdate(sql);
			if(resultSet.next()) {
				pklatest = resultSet.getInt(1);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pklatest);
		return pklatest;
		
	}

}
