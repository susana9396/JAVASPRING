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
 <form:form action="/categories/new" method="post" modelAttribute="categoryatr">
		<p>
			<form:label path="name"> Name:</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<input type="submit" value="Create" />
</form:form>
</body>
</html>