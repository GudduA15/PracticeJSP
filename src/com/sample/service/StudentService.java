package com.sample.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sample.db.DBConnection;
import com.sample.model.Student;

public class StudentService {
	
	public static List<Student> getAllStudents(){
		
		List<Student> students = new ArrayList<Student>();

		try {
			Connection conn = DBConnection.getConnection();
			Statement st= conn.createStatement();
			
			String query = "Select * from student";
			ResultSet rst = st.executeQuery(query);
			
			while (rst.next()) {
				int id = rst.getInt(1);
				String name = rst.getString(2);
				String fName = rst.getString(3);
				String mName = rst.getString(4);
				String address = rst.getString(5);
				
				Student s = new Student(id, name, fName, mName, address);
				
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return students;
	}
	
	public static Student getStudentById(int id) {
		Student s = null;

		try {
			Connection conn = DBConnection.getConnection();
			Statement st= conn.createStatement();
			
			String query = "Select * from student where id=" + id;
			ResultSet rst = st.executeQuery(query);
			
			while (rst.next()) {
				//int id = rst.getInt(1); // note reuiqred as id already received above
				String name = rst.getString(2);
				String fName = rst.getString(3);
				String mName = rst.getString(4);
				String address = rst.getString(5);
				
				s = new Student(id, name, fName, mName, address);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}

}
