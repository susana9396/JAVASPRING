<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language</title>
</head>
<body>
	<h3><a href="/languages" >Dashboard </a> </h3>

	
			
        <p><c:out value="${lang.name}"/></p>
        <p><c:out value="${lang.creator}"/></p>
		<p><c:out value="${lang.currenVersion}"/></p>

		<p><a href="/languages/edit/${lang.id}" >Edit </a> </p>
		<p><a href="/languages/delete/${lang.id}" >Delete </a> </p>
	
	
</body>
</html>