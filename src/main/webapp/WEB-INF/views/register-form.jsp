<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
</head>
<body>
<form method="post" action="/register-result">
		
		<fieldset>
			<legend>User Info</legend>
			<p>Username: <input type="text" name="username" /></p>
			<p> Password: <input type="text" name="password" /></p>
			<p>First Name: <input type="text" name="firstName" /></p>
			<p>Last Name: <input type="text" name="lastName" /></p>
		</fieldset>
		
		<button type="submit">Submit</button>
	</form>
</body>
</html>