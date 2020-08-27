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
		<h1> <c:out value="${category.name}"/></h1>
	    <h3>Products</h3>
    <div class="caja1">
	    <ul>
	       <c:forEach items="${category.products}"    var="product">
	       	<li><c:out value="${product.name}"/></li>
	       </c:forEach>
	    
	    </ul>
    </div>
    <div class="caja2">
	    <form action="/categories/${category.id}" method="post" >
			  <select name="product" id="product">		   
			  <c:forEach items="${products}"    var="product">
			   <option value="<c:out value="${product.id}"/>"><c:out value="${product.name}"/></option>
			  </c:forEach>
			 </select>
			  <input class="btn" type="submit" value="Add">	
		</form>
	</div>
</body>
</html>