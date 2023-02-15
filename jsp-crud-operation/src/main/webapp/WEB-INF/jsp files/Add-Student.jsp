<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet" href="Styles/style.css">
</head>
<body>
	
	<jsp:include page="/index"></jsp:include>
	
	<br> <br>
	<form action="register" method="POST" class="form">
		<label>Student ID</label> <br>
		<input type="text" name="id" required="required"> <br><br>
		<label>Student Name</label> <br>
		<input type="text" name="name" required="required"> <br><br>
		<label>Marks</label> <br>
		<input type="text" name="mark" required="required"> <br><br>
		<label>Email ID</label> <br>
		<input type="text" name="mail" required="required"> <br><br>
		<label>Password</label> <br>
		<input type="password" name="pass" required="required"> <br><br>
		
		<input type="submit" value="REGISTER">
	</form>
	
</body>
</html>