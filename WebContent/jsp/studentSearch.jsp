<%@page import="com.sample.model.Student"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sample.service.StudentService"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.controller.StudentSearch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	table, th, td {
		border: 1px solid;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action=searchStudent method="get">
	Student Name : <input type="text" name="name"> 
		           <input type="submit" value="Search">

	</form>
	
	<%
	// implicit object
	    Object result =  request.getAttribute("studentList");
		
	
		List<Student> students = (null == result) ? Collections.EMPTY_LIST : (List<Student>) result ;
	
	
	
	%>
	
	
	<br/>
	<br/>
	<br/>
	
	<table style="width: 100%">
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Father's Name</th>
			<th>Student Mother's Name</th>
			<th>Student Address</th>
		</tr>
<%
	for(Student s : students){
%>		
		<tr>
			<td><%= s.getId() %></td>
			<td><%= s.getName() %></td>
			<td><%= s.getFatherName() %></td>
			<td><%= s.getMotherName() %></td>
			<td><%= s.getAddress() %></td>
		</tr>
<%
	}
%>
	</table>
</body>
</html>