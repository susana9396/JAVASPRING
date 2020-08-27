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

	<h1> <c:out value="${product.name}"/></h1>
    <h3>Categories</h3>
    
    <div class="caja1">
	    <ul>
	       <c:forEach items="${product.categories}"    var="category">
	       	<li><c:out value="${category.name}"/></li>
	       </c:forEach>
	    
	    </ul>
    </div>
     <div class="caja2">
	    <form action="/products/${product.id}" method="post" >
			  <select name="categories" id="categories">		   
			  <c:forEach items="${categories}"    var="category">
			   <option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
			  </c:forEach>
			 </select>
			  <input class="btn" type="submit" value="Add">	
		</form>
	</div>
</body>
</html>