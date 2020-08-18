<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<div class="content">
		<div class="formulario">		
			<h2>Introduce tus Datos</h2>
			<form action="/result" method="post" id="datafrm">
				<input type="text" name="name" placeholder="Ingresa tu nombre">
				<select name="local" id="local">
  					<option value="Brown Norte">Brown Norte</option>
  					<option value="Plaza Ñuñoa">Plaza Ñuñoa</option>
 					<option value="Online">Online</option>
				</select>
				<select name="lang" id="lang">
  					<option value="Java">Java</option>
  					<option value="Python">Python</option>
 					<option value="Javascript">Javascript</option>
				</select>
				
			</form>	
			<textarea rows="4" cols="50" name="comment" form="datafrm">Enter text here...</textarea>
			<input class="btn" type="submit" value="Enviar" form="datafrm">			
			<h4 class="alert"><c:out value="${error}"/></h4>
				
		</div> 
	</div>
	
</body>
</html>