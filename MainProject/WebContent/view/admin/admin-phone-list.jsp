<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" http-equiv="content-type" content="text/html;charset=utf-8" />
<title>Phone list</title>
<style >
	<%@include file="/view/admin/admin-home-navbar.css"%>
	<%@include file="/view/admin/admin-phone-list.css"%>
</style>
<%@ page import="java.util.ArrayList"%>
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
			int curPage = (int)request.getAttribute("pageId");
			int totalPage = (int)request.getAttribute("totalPage");
			int nxtPage=0, prvPage=0;
			prvPage = curPage<=1? 1: curPage-1;
			nxtPage = curPage>=totalPage? totalPage: curPage+1;
			
			String p1 = "pageId=" + prvPage;
			String p2 = "pageId=" + curPage;
			String p3 = "pageId=" + nxtPage;
	%>
		
		<jsp:include page="admin-home-navbar.html" />
		<div class="navigation-form">
			<form action="admin-phone-list" method="GET">			
				<input type="text" name="input-phone-name" class="input-key">
				<input type="submit" name="submit" value="Search" class="btn">				
			</form>		
			<input type="button" onclick="location.href='/MainWebProject/add-phone';" value = "Add phone" class="add-phone btn">
		</div>
		
		<div class="table-content">
			<table>
				<tr class="headline">
					<th>ProductId</th>
					<th>Phone's name</th>
					<th></th>
				</tr>
				<% 
					int pageId = (int) request.getAttribute("pageId");
					ArrayList<Phone> listPhone = (ArrayList<Phone>)request.getAttribute("list_phone");
					
					for(int i=8*(pageId-1); i<8*pageId && i<listPhone.size(); i++){ 
				%>
					<tr class="item" productId="<%= listPhone.get(i).getId() %>">
						<td style="text-align: center;"><%= listPhone.get(i).getId() %></td>
						<td>
							<a href="edit-phone?id=<%= listPhone.get(i).getId() %>">
								<%=listPhone.get(i).getName() %>
							</a>
						</td>
						<td>
							<a href="edit-phone?id=<%= listPhone.get(i).getId() %>">Edit</a>/
							<a href="#" class="del-btn" onclick="delBtnClicked(this)">Delete</a>
						</td>
					</tr>				
				<%	} %>
			</table>
			<div class="page-navigation">
				<a href="admin-phone-list?<%= p1 %>" class="btn-nav">Prev</a>
				<a href="admin-phone-list?<%= p2 %>" class="btn"> ${ pageId }</a>
				<a href="admin-phone-list?<%= p3 %>" class="btn-nav" style="width: 100px;">Next</a>
			</div>		
		</div>
	<%
	//http://localhost:8080/Web-Project-API/api/phone/delete?phone-id=<%=listPhone.get(i).getId() 
		}
	%>
	<script>
	
		function delBtnClicked(e){
			let id = e.parentNode.parentNode.getAttribute('productId');
			let conf = confirm("You want to delete this item?");
			if(conf){
				fetch('http://localhost:8080/Web-Project-API/api/phone/delete?phone-id='+id);	
			}			
			location.reload();
		}
	
	</script>
</body>
</html>