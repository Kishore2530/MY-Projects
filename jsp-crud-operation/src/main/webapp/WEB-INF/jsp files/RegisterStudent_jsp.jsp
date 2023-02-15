<%@page import="com.ty.studentapp.dto.Student"%>
<%@page import="com.ty.studentapp.dao.StudentDataBaseOperation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	
	<%
		Student stu = new Student();
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		
		String sid = request.getParameter("id");
		int sId = Integer.parseInt(sid);
		String sname = request.getParameter("name");
		String marks = request.getParameter("mark");
		double smark = Double.parseDouble(marks);
		String email = request.getParameter("mail");
		String pswd = request.getParameter("pass");
		
		stu.setId(sId);
		stu.setName(sname);
		stu.setMarks(smark);
		stu.setEmailId(email);
		stu.setPassword(pswd);
		
		boolean isInserted = operation.insertStudent(stu);
	%>
	
	<% if(isInserted) { %>
	
	<jsp:include page="index"></jsp:include>
	<jsp:forward page="view-all"></jsp:forward>
	
	<% } else { %>
	
	<h1 align="center" color="red">Something went WRONG !!!</h1>
	<jsp:forward page="register"></jsp:forward>
	
	<% } %>
</body>
</html>