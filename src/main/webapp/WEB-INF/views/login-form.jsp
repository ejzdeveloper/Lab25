<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA"
	crossorigin="anonymous">
	<link rel="stylesheet" href="style.css" />
</head>
<body>
	<h1>Log in</h1>
	
	<c:if test="${ not empty message }">
		<p class="message">${ message }</p>
	</c:if>
	
	<form action="/login-form" method="post" autocomplete="off" >
	<p>
		<label>Username</label> <input type="text" name="username" required />
	</p>
	<p>
		<label>Password</label> <input type="password" name="password" required />
	</p>
	<p>
		<button type="submit">Log in</button>
	</p>
	</form>
	<a class="btn btn-secondary" href="/">Home</a>
</body>
</html>