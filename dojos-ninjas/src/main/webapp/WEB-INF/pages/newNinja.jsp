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

<h1>New Ninja</h1>
  <h3>DOJOS</h3>
  <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<form:select path="dojo">
	      <form:options items="${dojos}" itemValue="id" itemLabel="name"/>
	 	</form:select>
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName" />
			<form:errors path="firstName" />
		</p>
		<p>
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName" />
			<form:errors path="lastName" />
		</p>
		<p>
			<form:label path="age">Age:</form:label>
			<form:input path="age" type="number" step="1" />
			<form:errors path="age" />
		</p>
	
		<input type="submit" value="Create" />
	</form:form>


</body>
</html>