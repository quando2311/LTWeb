<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" type="text/css" href="admin-home.css">
</head>
<body>
	<%
		if(request.getSession().getAttribute("username") == null){
	%>
		<div class="admin-navbar">	
			<form action="admin-home" method="POST">
				<input type="submit" value="Log Out" name="navigation">
				<input type="submit" value="Change Password" name="navigation">
			</form>
		</div>

	<%	
		}
		else{
	%>
		<div class="admin-navbar">	
			<form action="admin-home" method="POST">
				<input type="submit" value="Log Out" name="navigation">
				<input type="submit" value="Change Password" name="navigation">
			</form>
		</div>

	<%
		}
	%>
</body>
</html>