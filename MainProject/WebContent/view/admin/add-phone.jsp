<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style >
	<%@include file="/view/admin/admin-home-navbar.css"%>

</style>
<title>Add phone</title>
<%@ page import="model.Phone"%>

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
	<%
		}
	%>
</body>
</html>