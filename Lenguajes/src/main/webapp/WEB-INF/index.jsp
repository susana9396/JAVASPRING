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
	
<table>
	<thead>
		<tr>
			<th><h1 scope="col">Name</h1></th>
			<th><h1 scope="col">Creator</h1></th>
			<th><h1 scope="col">Version</h1></th>
			<th><h1 scope="col">action</h1></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${lang}" var="l">
		<tr>		
			<td><a href="/languages/${l.id}"><c:out value="${l.name}"/></a></td>
			<td><p><c:out value="${l.creator}"/></p></td>
			<td><p><c:out value="${l.currenVersion}"/></p></td>
			<td><a href="/languages/delete/${l.id}" >delete </a> <a href="/languages/edit/${l.id}"> edit</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>	

 <form:form action="/languages" method="post" modelAttribute="newL">
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