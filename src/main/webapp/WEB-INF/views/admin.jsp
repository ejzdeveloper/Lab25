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
function warning(){
	var retVal = confirm("Are you sure you want to delete this item?");
    if( retVal == true ) {
       return true;
    } else {
       return false;
    }
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
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>						
						<%-- When Admin click delete, warning to confirm. If true, redirects to delete. if false, ignores --%>						
						<form onsubmit="return warning();" method="post" action="/product/delete?id=${ product.id }">
						  <a href="/product/updateCoffee?id=${ product.id }" class="btn btn-light btn-sm">Edit</a>
						  <input type="submit" class="btn btn-light btn-sm" value="Delete" />
						</form>											
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