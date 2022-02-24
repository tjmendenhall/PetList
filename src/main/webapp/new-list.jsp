<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br /> 
		Owner Name: <input type="text" name="ownerName"><br /> Available
		Pets to add:<br /> <select name="allPetsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allPets}" var="currentpet">
				<option value="${currentpet.id}">${currentpet.type}|
					${currentpet.name} ${currentpet.diet}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create list and Add Pets">

	</form>
	<a href="index.html">Home</a>
</body>
</html>