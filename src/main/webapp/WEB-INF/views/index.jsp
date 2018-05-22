<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List O' Customers</title>
</head>
<body>
	<form action="addNewCust">
		Customer ID: <input type="text" name="id"> 
		Your Name: <input type="text" name="contName"> 
		Company Name: <input type="text" name="compName"> 
		Your Title: <input type="text" name="title"> 
		Company Phone: <input type="text" name="phone">
		<input type="submit" value="Add">
	</form>

	<table border="1">
		<c:forEach var="myVar" items="${test}">
			<tr>
			<!-- left out contact title -->
				<td>${myVar.customerID}</td>
				<td>${myVar.companyName}</td>
				<td>${myVar.contactName}</td>
				<td>${myVar.phone}</td>
				<td><a href="delete?id=${myVar.customerID}">Delete</a> 
				<td><a href="update?id=${myVar.customerID}">Update</a>
			</tr>

		</c:forEach>

	</table>
</body>
</html>