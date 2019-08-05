<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css" rel="stylesheet" integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/register-form">
		
		<fieldset>
			<legend>User Info</legend>
			<label>Username: </label> <input type="text" name="username" value="${ user.firstName }"/>
			<p> Password: <input type="password" name="password" required/></p>
			<p>First Name: <input type="text" name="firstName" /></p>
			<p>Last Name: <input type="text" name="lastName" /></p>
		</fieldset>
		
		<button type="submit">Submit</button>
	</form>
	<br>
	<a class="btn btn-secondary" href="/">Home</a>
</body>
</html>