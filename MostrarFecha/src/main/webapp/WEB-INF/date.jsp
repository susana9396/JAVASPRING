<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/date.js"></script>
<meta charset="ISO-8859-1">
<title>Muestra la fecha</title>
</head>
<body>
	<h1>La fecha es:</h1>
	<h1 class="fecha">
		<c:out value="${fecha1}"/>
	</h1>
</body>
</html>