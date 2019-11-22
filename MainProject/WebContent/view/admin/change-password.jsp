<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<style >
	<%@include file="/view/admin/admin-home-navbar.css"%>
	<%@include file="/view/admin/change-password.css"%>
</style>
</head>
<body>
		<%
		if(request.getSession().getAttribute("username") == null){
	%>
		<jsp:include page="unauthorize.html"/>

	<%	
		}
		else{
	%>
		<jsp:include page="admin-home-navbar.html" />
		<div class="login-div">
			<form action="change-password" method="POST" class="form-change-password">
				<h3>ADMIN LOG IN</h3>
				<div class="info-field">
					<div class="tab">
						<label>Username</label>  <input type="text" name="username"><br>
					</div>
					<div class="tab">
						<label>Password</label>  <input type="password" name="password"><br>
					</div>
					<div class="tab">
						<label>New password</label>  <input type="password" name="password"><br>
					</div>
				</div>									
				<input type="submit" name="submit" value="Submit">
				<p>${ message }</p>	
			</form>
		</div>

	<%
		}
	%>

	
	
	
</body>
</html>