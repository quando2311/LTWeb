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
			String p1 = request.getAttribute("path") + "&pageId=" + ((int)request.getAttribute("pageId")-1);
			String p2 = request.getAttribute("path") + "&pageId=" + request.getAttribute("pageId");
			String p3 = request.getAttribute("path") + "&pageId=" + ((int)request.getAttribute("pageId")+1);
	%>
		
		<jsp:include page="admin-home-navbar.html" />
		<div class="navigation-form">
			<form action="admin-phone-list" method="GET">			
				<input type="text" name="input-phone-name" class="input-key">
				<input type="submit" name="submit" value="Search" class="btn">				
			</form>		
			<input type="button" onclick="location.href='/MainWebProject/add-phone';" value = "Add phone" class="add-phone">
		</div>
		
		<div class="table-content">
			<table>
				<tr class="headline">
					<th>ProductId</th>
					<th>Phone's name</th>
				</tr>
				<% 
					int pageId = (int) request.getAttribute("pageId");
					ArrayList<Phone> listPhone = (ArrayList<Phone>)request.getAttribute("list_phone");
					for(int i=8*(pageId-1); i<8*pageId && i<listPhone.size(); i++){ 
				%>
					<tr class="item">
						<td style="text-align: center;"><%= listPhone.get(i).getId() %></td>
						<td><a href="#"><%=listPhone.get(i).getName() %></a></td>
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
		}
	%>
</body>
</html>