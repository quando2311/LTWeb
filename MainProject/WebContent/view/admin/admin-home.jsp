<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<style>
	<%@include file="/view/admin/admin-home-navbar.css"%>
	<%@include file="/view/admin/admin-home.css"%>
</style>

<!--  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/admin/admin-home.css">-->
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
		<div class="table-content">
			<table>
				<tr>
					<th>Contents</th>
				</tr>
				<tr>
					<td><a href="#">Order</a></td>
				</tr>
				<tr>
					<td><a href="admin-phone-list">Phones</a></td>
				</tr>
			</table>
		</div>

	<%
		}
	%>
</body>
</html>