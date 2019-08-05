<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA"
	crossorigin="anonymous">
	<link rel="stylesheet" href="style.css" />
</head>
<body>
	<h1>Welcome to the GC Coffee Shop</h1>
	<nav>
		<c:if test="${ empty user }">
			<a href="/login-form">Log in</a>
			<a href="/register-form">Sign up</a>
		</c:if>
		<c:if test="${ not empty user }">
			Welcome ${ user.username }
			<a href="/logout">Log out</a>
		</c:if>
	</nav>
	
	<br>
	<main class="container">

	<table class="table">
		<thead>
			<tr>
				<th>Coffee</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
		<c:if test="${ empty user }">
			<a class="btn btn-secondary" href="/register-form">Register New User</a>
		</c:if>
		<c:if test="${ not empty user and user.username.equals('Admin') }">
		<a class="btn btn-secondary" href="/admin">Admin</a>
		</c:if>
	 
	</main>
</body>
</html>