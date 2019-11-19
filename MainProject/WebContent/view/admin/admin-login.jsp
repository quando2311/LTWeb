<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/admin/admin-login.css">
</head>
<body>
	<div class="login-div">
		<form action="admin" method="POST">
			<h3>ADMIN LOG IN</h3>
			<div class="info-field">
				<div class="tab">
					<label>Username</label>  <input type="text" name="username"><br>
				</div>
				<div class="tab">
					<label>Password</label>  <input type="password" name="password"><br>
				</div>
			</div>									
			<input type="submit" name="submit" value="Submit">
			<p>${ message }</p>	
		</form>
	</div>
	
	
</body>
</html>