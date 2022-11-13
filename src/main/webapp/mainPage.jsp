<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "project.model.dto.Post" %>    
<%@ page import="java.util.ArrayList" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<link type="text/css" rel="stylesheet" href="css/showPost.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body>

<div id="pre">
		<jsp:include page="inc/loginCheck.jsp"/>	
		<jsp:include page="inc/search.jsp"/>
	
		<jsp:include page="inc/userProfile.jsp"/>	
</div>

		
<%
		ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");
%>		


	<div id="content">
	<div style="text-align: center"><font style="color: white; font-size:30px; ">메인 페이지</font></div>
		<% for(Post dto: list) {%>	
			<div class="interContent"  onClick="location.href='clickedPost?&post_number=<%=dto.getPost_number() %>'">
				<table class="contentBox" >	
						
						<tr><td class="userIdInContent"><%= dto.getId()%></td></tr>
						<tr><td> <img src="imgInPost/<%=dto.getImg()%>" onerror="this.style.display='none'"></td></tr>
						<tr><td><%=dto.getContents()%></td></tr>	
						<tr><td><hr></td></tr>
				
				</table>
			</div>
				<%} %>	
		</div>

</body>
</html>