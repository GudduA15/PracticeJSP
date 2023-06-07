package com.sample.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.db.DBConnection;
import com.sample.model.Student;

@WebServlet("/jsp/searchStudent")
public class SearchStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside search student call:::");

		String name = req.getParameter("name");

		List<Student> students = new LinkedList<Student>();
		try {
			Connection connect = DBConnection.getConnection();
			Statement stm = connect.createStatement();

			String qry = "Select * from student where name = '" + name + "'";

			ResultSet rst = stm.executeQuery(qry);
			while (rst.next()) {
				int id = rst.getInt(1);
				String sName = rst.getString(2);
				String fName = rst.getString(3);
				String mName = rst.getString(4);
				String address = rst.getString(5);

				Student st = new Student(id, sName, fName, mName, address);
				students.add(st);
			}
			
			
			req.setAttribute("studentList", students);

			RequestDispatcher rd = req.getRequestDispatcher("studentSearch.jsp");
			rd.forward(req, resp);
			
			
			System.out.println(students);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
