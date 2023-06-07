<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
String name=request.getParameter("name");
out.print("Welcome" + name);
%>
<br/><br/>

<a href="jsp/addStudent.jsp">Add Student</a><br/><br/>
<a href="jsp/showStudents.jsp">Show Student</a><br/><br/>
<a href="jsp/searchStudent.jsp">Update Student</a><br/><br/>
<a href="jsp/deleteStudent.jsp">Delete Student</a><br/><br/>
<a href="jsp/studentSearch.jsp">Search Student</a>

</body>
</html>