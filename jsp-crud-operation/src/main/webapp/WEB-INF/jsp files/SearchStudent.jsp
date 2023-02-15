<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Student</title>
</head>
<body>

	<jsp:include page="/index"></jsp:include>

	<form action="search-student" method="POST" class="form">
		<label>Student ID</label> <br>
		<input type="text" name="id" required="required"> <br> <br>
		
		<input type="submit" value="SEARCH">
	</form>

</body>
</html>