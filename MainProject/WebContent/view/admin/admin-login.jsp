<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div style="margin: auto;">
		<form action="admin" method="POST">
			Username: <input type="text" name="username"><br>
			Password: <input type="password" name="password"><br>
			<input type="submit" name="submit" value="Submit">
			<p>${ message }</p>	
		</form>
	</div>
	
	
</body>
</html>