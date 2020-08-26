<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Editar libro</h1>
	<form:form action="/books/${books.id}/update" method="post" modelAttribute="books" >
		<input type="hidden" name="_method" value="put">	
			<form:label path="title" >Título</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
	
			<form:label path="description" >Descripción</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
	
			<form:label path="language" >Idioma</form:label>
			<form:errors path="language"/>
			<form:input path="language"/>
	
			<form:label path="numberOfPages" >Páginas</form:label>
			<form:errors path="numberOfPages"/>
			<form:input type="number" step="1" path="numberOfPages"/><br>
	
		<input class="btn" type="submit" value="Enviar">	
	</form:form>	

</body>
</html>
