<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import= "project.model.dto.Post" %>    
<%@ page import="java.util.ArrayList" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");
%>		

		<% for(Post dto: list) {%>	
	
<div class="interContent">
				<table class="contentBox" >	
						
						<tr><td class="userIdInContent"><%= dto.getId() %></td></tr>
						<tr><td> <img src="imgInPost/<%=dto.getImg() %>" onerror="this.style.display='none'"></td></tr>
						<tr><td><%=dto.getContents() %></td></tr>	
						
						<tr><td><hr></td></tr>
						
				</table>
			</div>
			<%} %>	
</body>
</html>