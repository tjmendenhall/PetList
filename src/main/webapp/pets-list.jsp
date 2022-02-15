<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displaying Pets List</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
	<table class="table table-striped table-hover">
	<c:forEach items="${requestScope.allPets}" var="currentpet">
	<tr>
 		<td><input type="radio" name="id" value="${currentpet.id}"></td>
 		<td>Type: ${currentpet.type}</td>
 		<td>Name: ${currentpet.name}</td>
 		<td>Diet: ${currentpet.diet}</td>
 	</tr>
	</c:forEach>
	</table>
	<br />
	<input type = "submit" value = "edit" name="doThisToPet" class="btn btn-warning">
	<input type = "submit" value = "delete" name="doThisToPet" class="btn btn-danger">
	<input type="submit" value = "add" name = "doThisToPet" class="btn btn-success">
	</form>
</body>
</html>