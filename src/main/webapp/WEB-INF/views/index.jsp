<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Welcome to the GC Coffee Shop</h1>
		<a href="/register-form">Register!</a>
		<div class="container">
		<table class="table">
			<tbody>
				<tr>
					<c:forEach var="products" items="${listOfProducts}">
					<a href="/index?id=${products.id}">${products.name}</a>
					${products.description}
					${products.price}	
					</c:forEach>				
				</tr>
				
			</tbody>
		</table>
	</div>
</body>
</html>