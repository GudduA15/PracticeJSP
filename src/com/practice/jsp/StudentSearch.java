package com.practice.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentSearch extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Enter Search student :::");
		
		int id = Integer.valueOf(req.getParameter("id"));
		
		Student st = StudentService.getStudentById(id);
		
		req.setAttribute("student", st);
		
		RequestDispatcher rd= req.getRequestDispatcher("jsp/updateStudent.jsp");
		rd.forward(req, resp);
		
	}
	

}
