<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Customer</title>
</head>
<body>
	<form action="updateCust">
		Customer ID: ${id}
		Your Name: <input type="text" name="name"> 
		<input type="hidden" name="id" value="${id}" > 
		<input type="submit" value="Update">
	</form>


</body>
</html>