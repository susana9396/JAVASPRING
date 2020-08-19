<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Cash</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Your Gold:<c:out value="${gold}"/></h1>
	<form action="/reset" method="POST">
		<input name="reset" type="submit" value="reset">
	</form>
	<div class="content">
		<div class="lugar">
			<h1>Farm</h1>
			<h2>(earns 10 - 20 gold)</h2>
			<form action="/" method="POST">
				<input name="farm" type="submit" value="Find Gold!" /> 
			</form>
		</div>
		
		<div class="lugar">	
			<h1>Cave</h1>
			<h2>(earns 5 - 10 gold)</h2>
			<form action="/" method="POST">
				<input name="cave" type="submit" value="Find Gold!" /> 
			</form>
		</div>
		
		<div class="lugar">	
			<h1>House</h1>
			<h2>(earns 2 - 5 gold)</h2>
			<form action="/" method="POST">
				<input name="house" type="submit" value="Find Gold!" /> 
			</form>
		</div>
			
		<div class="lugar">	
			<h1>Casino!</h1>
			<h2>(earns/takes 0 - 50 gold)</h2>
			<form action="/" method="POST">
				<input name="casino" type="submit" value="Find Gold!" /> 
			</form>
		</div>
			
		<div class="lugar">	
			<h1>Spa</h1>
			<h2>(takes 5 - 20 gold)</h2>
			<form action="/" method="POST">
				<input name="spa" type="submit" value="Find Gold!" /> 
			</form>
		</div>
		
	</div>
	<h2>Activities:</h2>
	<div class="activities">
		<c:forEach var="activity" items="${activities}">
			<h3 class="${activity.color}">${activity.mensaje}</h3>
		</c:forEach>
	</div>
</body>
</html>