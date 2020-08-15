<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Resultado del conteo</title>
</head>
<body>
	<h1>
		you have visited 
		<a href="">http://localhost:8080/</a>
		<c:out value="${count}"/> 	times.
	</h1>
	<a href="http://localhost:8080/">Test Another visit?</a>
	
</body>
</html>