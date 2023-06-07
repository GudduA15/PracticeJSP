<!DOCTYPE html>
<%@page import="com.practice.jsp.Student"%>
<%@page import="com.practice.jsp.StudentService"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Addmission Form</title>
</head>
<body>
<h1>Update Student</h1>

<%
	int id = Integer.valueOf(request.getParameter("id"));

	Student s = StudentService.getStudentById(id);
%>

<form action="updateStudent" method="post">
	<input type="hidden" name="id" value="<%= s.getId()%>">
	Student Name : <input type="text" name="st_name" value="<%=s.getName() %>"><br/><br/>
	Father's Name : <input type="text" name="st_father" value="<%=s.getFatherName() %>"><br/><br/>
	Mother's Name : <input type="text" name="st_mother" value="<%=s.getMotherName() %>"><br/><br/>
	Address : <input type="text" name="address" value="<%=s.getAddress() %>"><br/><br/>
	<input type="submit" value ="Update" >
</form>

</body>
</html>