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
<a href="/languages/delete/${lang.id}" >Delete</a> <a href="/languages" >Dashboard</a>
 <form:form action="/languages/edit/${lang.id}" method="put" modelAttribute="lang">
			<p>
				<form:label path="name">Name</form:label>

				<form:input path="name" required="required"/>
				<form:errors path="name" />
			</p>
			<p>
				<form:label path="creator">Creator</form:label>

				<form:input path="creator" required="required"/>
				<form:errors path="creator" />
			</p>
			<p>
				<form:label path="currenVersion">Version</form:label>

				<form:input path="currenVersion" required="required" type="number"/>
				<form:errors path="currenVersion" />
			</p>		
			<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>