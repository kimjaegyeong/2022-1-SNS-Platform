<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "project.model.dto.Post" %>    
<%@ page import="java.util.ArrayList" %>   
<!DOCTYPE html>
<html>
<head>


<link type="text/css" rel="stylesheet" href="css/showPost.css">

</head>
<body>
<jsp:include page="inc/loginCheck.jsp"/>	

<jsp:include page="inc/search.jsp"/>
<jsp:include page="inc/userProfile.jsp"/>	

<%
		ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");
%>		


	<div id="content">
	<div style="text-align: center"><font style="color: white; font-size:30px; ">내가 쓴 게시글</font></div>
	<a href="mainPage"style="color: white;">메인으로 돌아가기</a>
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
