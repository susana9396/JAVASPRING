<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>New License</h1>
	
	<form:form action="/licenses" method="post" modelAttribute="license">
		<p>
			<form:select path="person">
   			<form:options items="${persons}" itemValue="id" itemLabel="fullName"/>
			</form:select>
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:input path="state" />
			<form:errors path="state" />
		</p>
		<p>
			<form:label path="expirationDate">Expiration Date</form:label>
			<form:input path="expirationDate" type="date"/>
			<form:errors path="expirationDate"/>
		</p>
		<input type="submit" value="Create" />
	</form:form>
	
</body>
</html>