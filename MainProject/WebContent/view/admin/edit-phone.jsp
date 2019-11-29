<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Phone" %>
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
			Phone phone = (Phone) request.getAttribute("phone");
			int index = phone.getImgURL().indexOf("Image");
			String imgURL = phone.getImgURL().substring(index);
	%>
		
		<jsp:include page="admin-home-navbar.html" />
		<div class="content">
			<div class="headline">
				<h3>ID: <%= phone.getId() %></h3>
			</div>
			
			<form action="edit-phone" method="POST" enctype="multipart/form-data">
				<input type="hidden" name="id" value="<%= phone.getId()%>">
				<div class="tab">
					<label>Phone's name</label>
					<input type="text" name="phone_name" value="<%= phone.getName() %>">
				</div>
				<div class="tab">
					<label>Price</label>
					<input type="text" name="price" value="<%= phone.getPrice() %>">
				</div>					
				<div class="tab">
					<label>Brand</label>
					<input type="text" name="brand" value="<%= phone.getBrand() %>">
				</div>					
				<div class="tab">
					<label>Screen</label>
					<input type="text" name="screen" value="<%= phone.getScreen() %>">
				</div>
				<div class="tab">
					<label>OS</label>
					<input type="text" name="os" value="<%= phone.getOS() %>">
				</div>
				<div class="tab">
					<label>CPU</label>
					<input type="text" name="cpu" value="<%= phone.getCPU() %>">
				</div>
				<div class="tab">
					<label>RAM</label>
					<input type="text" name="ram" value="<%= phone.getRAM() %>">
				</div>
				<div class="tab">
					<label>Camera</label>
					<input type="text" name="camera" value="<%= phone.getCamera() %>">
				</div>
				<div class="tab">
					<label>Battery</label>
					<input type="text" name="battery" value="<%= phone.getBattery() %>">
				</div>
				<div class="tab">
					<label>Image</label>
					<input type="file" name="img" id="inputImg">					
				</div>		
				<img src="<%= imgURL %>" alt="img-phone" width="200" height="200" style="margin-left: 200px;" id="phoneImg">
				<input type="submit" name="submit" value="Edit phone" class="btn-add" id="submitBtn" onClick="console.log('a')">
			</form>
			<p>${ message }</p>	
		</div>
		<script>
		
			function setImg(){
				let URL = window.URL || window.webkitURL;
				let imgTag = document.getElementById('phoneImg');				
				
				let img = this.files[0];
				let imgURL = URL.createObjectURL(img);
				imgTag.src=imgURL;
				
				
			}
			let imgInp = document.getElementById('inputImg');
			imgInp.addEventListener('change', setImg, false);
		</script>
	<%
		}
	%>
</body>
</html>