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
<script type="text/javascript">
function alert(){
alert("Are you sure you want to delete this item?");
} 
</script>
<body>
	<main class="container">
		<h1>ADMIN</h1>
		
		<table class="table">
			<thead>
			<tr>
				<th>Coffee</th><th>Description</th><th>Price</th><th>Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<%-- Access properties of the java bean using simple . notation.
					     This actually calls the getters behind the scenes. --%>
					<td>${product.name}</td><td>${product.description}</td><td>${product.price}</td>
					<td>
						<a href="/product/updateCoffee?id=${ product.id }" class="btn btn-light btn-sm">Edit</a>
						<a href="/product/delete?id=${ product.id }" class="btn btn-light btn-sm" ><button onclick="alert()">Delete</button></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<a class="btn btn-secondary" href="/addCoffee">Add</a>
		<a class="btn btn-secondary" href="/">Home</a>
	</main>
</body>
</html>