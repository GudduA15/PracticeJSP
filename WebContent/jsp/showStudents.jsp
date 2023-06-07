<!DOCTYPE html>
<%@page import="com.sample.service.StudentService"%>
<%@page import="com.sample.model.Student"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
<head>
<style>
table, th, td {
	border:1px solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>Student Addmission Form</title>
</head>
<body>
	<h1>Show Student</h1>
	<%
	
		List<Student> students = StudentService.getAllStudents();
		/* List<Student> students = new ArrayList<Student>();

		Connection conn = DBConnection.getConnection();
		Statement st = conn.createStatement();

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
 */
		System.out.println(students);
	%>
	<table style="width: 100%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Father Name</th>
			<th>Mother name</th>
			<th>Address</th>
		</tr>

		<%
			for (Student std : students) {
		%>
		<tr>
			<td><%=std.getId()%></td>
			<td><%=std.getName()%></td>
			<td><%=std.getFatherName()%></td>
			<td><%=std.getMotherName()%></td>
			<td><%=std.getAddress()%></td>
		</tr>

		<%
			}
		%>
	</table>
</body>
</html>