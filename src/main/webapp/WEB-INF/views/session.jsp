<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css" rel="stylesheet" integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA" crossorigin="anonymous">
</head>
<body>
	<h1>Welcome to the GC Coffee Shop</h1>
	<span>
			Hello ${ user.firstName } (stored in session)
		</span>
	<br>
	<main class="container">
		
		<table class="table">
			<thead>
			<tr>
				<th>Coffee</th><th>Description</th><th>Price</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<%-- Access properties of the java bean using simple . notation.
					     This actually calls the getters behind the scenes. --%>
					<td>${product.name}</td><td>${product.description}</td><td>${product.price}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>