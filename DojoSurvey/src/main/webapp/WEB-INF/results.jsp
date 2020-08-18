<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pantalla de Datos</title>
</head>
<body>
	<h1>Los datos enviados..!</h1>	
	<h2>Name : <c:out value="${name}"/></h2>
	<h3>Dojo Location: <c:out value="${location}"/></h3>
	<h3>Favorite Language: <c:out value="${language}"/></h3>
	<h3>Comment: <c:out value="${comment}"/></h3>
	
	<form action="/">
		<input class="btn" type="submit" value="Volver">
	</form>
</body>
</html>