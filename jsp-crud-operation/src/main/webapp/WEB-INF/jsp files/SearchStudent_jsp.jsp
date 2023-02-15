<%@page import="java.util.ArrayList"%>
<%@page import="com.ty.studentapp.dao.StudentDataBaseOperation"%>
<%@page import="com.ty.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
	
	<%
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		ArrayList<Student> s = operation.getStudent(id);
	%>
	
	<%
		if(s != null) {	
	%>
	
	<jsp:include page="/index"></jsp:include>
	<table border="1" align="center">
		<tr>
			<th>Student ID</th>
			<th>Name</th>
			<th>Marks</th>
			<th>Email ID</th>
		</tr>
		
		<% 
			for(Student student : s) { 
		%>
		
		<tr>
			<td><%= student.getId() %></td>
			<td><%= student.getName() %></td>
			<td><%= student.getMarks() %></td>
			<td><%= student.getEmailId() %></td>
		</tr>
		
		<% } %>
	</table>
	
	<% } %>
	
</body>
</html>