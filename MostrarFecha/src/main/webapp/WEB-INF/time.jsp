<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
 <script type="text/javascript" src="js/time.js"></script>
<meta charset="ISO-8859-1">
<title>Muestra la hora</title>
</head>
<body>
	<h1>La hora es:</h1>
	<h1 class="hora">
		<c:out value="${hora1}"/>
	</h1>
</body>
</html>