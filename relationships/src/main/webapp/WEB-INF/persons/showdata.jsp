<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
   <h1><c:out value="${persons.fullName}" /></h1>
   
   
	<p>Licencia: <c:out value="${persons.license.number}" /></p>
	<p>Estado: <c:out value="${persons.license.state}" /></p>
	<p>Fecha de Vencimiento: <c:out value="${persons.license.expirationDate}" />	</p>	
</body>
</html>