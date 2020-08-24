<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="-UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
	  <tr>
	  	<th scope="col"><h3>Título</h3></th>
	  	<th scope="col"><h3>Descripción</h3></th>
	  	<th scope="col"><h3>Idioma</h3></th>
	  	<th scope="col"><h3>Páginas</h3></th>
	  	<th scope="col"><h3>Ver</h3></th>
	  	<th scope="col"><h3>Editar</h3></th>
	  	<th scope="col"><h3>Borrar</h3></th>
	  </tr>
	 </thead>
	 <tbody>
	        <c:forEach items="${books}" var="book">
	        <tr>
		        <td><p><c:out value="${book.title}"/><p></td>
			    <td><p><c:out value="${book.description}"/></p></td>
			    <td><p><c:out value="${book.language}"/></p></td>
			    <td><p><c:out value="${book.numberOfPages}"/></p></td>
			    <td><a href="/books/${book.id}">Show Book</a></td>
			    <td><a href="/books/${book.id}/edit">Edit Book</a></td>
			    <td><form action="/books/${book.id}/delete" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
			        </form></td>
		   </tr>
		</c:forEach>
	  </tbody>
</table>
	 <a href="/books/new"><h3>Nuevo libro</h3></a>
</body>
</html>