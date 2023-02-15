<%@page import="com.ty.studentapp.dto.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ty.studentapp.dao.StudentDataBaseOperation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display All Students</title>
</head>
<body>

	<%
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		ArrayList<Student> stu = operation.getAllStudents();
	%>
	
	<jsp:include page="index"></jsp:include>
	
	<table border="1" align="center">
		<tr>
			<th>Student ID</th>	
			<th> Name</th>
			<th> Mark</th>
			<th> Email ID</th>
		</tr>
		
		<%
			for(Student student : stu) {
		%>
		
		<tr>
			<td><%= student.getId() %></td>
			<td><%= student.getName() %></td>
			<td><%= student.getMarks() %></td>
			<td><%= student.getEmailId() %></td>
		</tr>
		
		<% } %>
		
	</table>

</body>
</html>