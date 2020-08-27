<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>New Product</h1>
    <form:form action="/products/new" method="post" modelAttribute="productatr">
		<p>
			<form:label path="name"> Name:</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:textarea path="description" rows="5"  cols="20"/>
			<form:errors path="description" />
		</p>
		<p>
			<form:label path="price">Price:</form:label>
			<form:input path="price" type="number" step="any"/>
			<form:errors path="price" />
		</p>
	
		<input type="submit" value="Create" />
	</form:form>

</body>
</html>