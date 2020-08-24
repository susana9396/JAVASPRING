<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1> Ingrese nuevo libro</h1>
	<form action="/books" method="post" >
		<input type="text" name="title" placeholder="T�tulo">
		<input type="text" name="description" placeholder="Descripci�n">
		<input type="text" name="language" placeholder="Idioma">		
		<input type="number" step="1" name="numberOfPages" placeholder="N�mero de p�ginas">
		<input class="btn" type="submit" value="Enviar">	
	</form>	

</body>
</html>