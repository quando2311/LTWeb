<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style >
	<%@include file="/view/admin/admin-home-navbar.css"%>
	<%@include file="/view/admin/add-phone.css"%>
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
		<div class="content">
			<div class="headline">
				<h3>ADD NEW PRODUCT</h3>
			</div>
			
			<form action="http://localhost:8080/Web-Project-API/api/phone/add" method="POST" enctype="multipart/form-data">
				<div class="tab">
					<label>Phone's name</label>
					<input type="text" name="phone_name">
				</div>
				<div class="tab">
					<label>Price</label>
					<input type="text" name="price">
				</div>					
				<div class="tab">
					<label>Brand</label>
					<input type="text" name="phone_name">
				</div>					
				<div class="tab">
					<label>Screen</label>
					<input type="text" name="screen">
				</div>
				<div class="tab">
					<label>OS</label>
					<input type="text" name="os">
				</div>
				<div class="tab">
					<label>CPU</label>
					<input type="text" name="cpu">
				</div>
				<div class="tab">
					<label>RAM</label>
					<input type="text" name="ram">
				</div>
				<div class="tab">
					<label>Camera</label>
					<input type="text" name="camera">
				</div>
				<div class="tab">
					<label>Battery</label>
					<input type="text" name="battery">
				</div>
				<div class="tab">
					<label>Image</label>
					<input type="file" name="img">
				</div>		
				<input type="submit" name="submit" value="Add phone" class="btn-add">
			</form>
			
		</div>
	<%
		}
	%>
</body>
</html>