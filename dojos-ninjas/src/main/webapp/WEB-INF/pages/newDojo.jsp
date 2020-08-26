<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

<h1>New Dojo</h1>
   <form action="/dojos/new" method="post" >
		<input type="text" name="name" >
		<input type="submit" value="Create">	
	</form>	
</body>
</html>