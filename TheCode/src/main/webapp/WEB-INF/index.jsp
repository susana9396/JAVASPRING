<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Code</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="content">
		<div class="formulario">
			<h2>Introduce el codigo secreto</h2>
			<form action="/login" method="post">
				<input type="text" name="codigo" placeholder="Ingrese el codigo"><br>
				<input class="btn" type="submit" value="Try Code">
			</form>
		</div>
		<h4><c:out value="${error}"/></h4>
	</div>
</body>
</html>