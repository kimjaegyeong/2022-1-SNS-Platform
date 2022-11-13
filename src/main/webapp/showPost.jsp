<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "project.model.dto.Post" %>   
<%@ page import= "project.model.dto.Comment" %> 
<%@ page import="java.util.ArrayList" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showPost</title>

<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/post.css">
</head>
<body>
<jsp:include page="inc/search.jsp"/>
<jsp:include page="inc/userProfile.jsp"/>	
<%
		Post dto = (Post)request.getAttribute("dto");
%>		

<div class="post">

		<table class="postTable">
			<tbody>
			<form action="selectOnePost" method="get" enctype="multipart/form-data">
				<tr><td colspan="2" class="postTop"><a href="mainPage"style="color: white;">뒤로가기</a></td></tr>
				<tr><td class="postContent" name="memberId"><font style="color:white"><%= dto.getId() %></font></td></tr>
				
				<tr><td class="postImg"><img id="upload_img" src="imgInPost/<%=dto.getImg() %>" onerror="this.style.display='none'"></td></tr>
				<tr>
				<td class="postContent" >
					<hr>
					<div class="textArea">
						<textarea name="contents" readonly cols="85" rows="20" >
							<%= dto.getContents() %>
						</textarea>
					</div>
				</td>
				</tr> 
				<% if(session.getAttribute("memberId").equals(dto.getId())){ %>
				<tr><td class="postContent">
				
				
				<input type="hidden" name="img" value=<%= dto.getImg() %> >
				<input type="hidden" name="post_number" value=<%= dto.getPost_number() %>>
				<input type="submit"  value="수정">
				<% } %>
			</form>
				
				<form action="deletePost" method="post">
					<% if(session.getAttribute("memberId").equals(dto.getId()) || session.getAttribute("grade").equals("m")){ %>
					<input type="hidden" name="post_number" value=<%= dto.getPost_number() %>>
					<input type="submit" value="삭제">
				  </tr>
				  	<% } %>
				</form>
			
				
<%
	ArrayList<Comment> list = (ArrayList<Comment>)request.getAttribute("comDto");
%>		<tr>

		<td class="postContent" name="comment">
		 <font style="color:white;">======================댓글======================
		 <br>
		 <table id= "comment">
		 
		<% for(Comment comDto: list) {%>	
					<tr><td><font style="color:white; font-size: 12px;"><%= comDto.getMemberId() %>: <%= comDto.getComment() %></font></td>
					<td>
					
					<% if(comDto.getMemberId().equals(session.getAttribute("memberId")) || session.getAttribute("grade").equals("m")) { %>
					<a href="deleteComment?comment_number=<%= comDto.getComment_number() %>&post_number=<%=comDto.getPost_number() %>" style="text-align: right;"><font style="color:white; font-size: 12px;">삭제</font></a>
					<% } %>
					</td>
					</tr>		
		<% } %>	
		
		</table>
		</td></tr>			
		<form action=createComment method="get">
		
					<tr><td class="postContent">
					<font style="color:white; font-size: 12px;">
						<input type="hidden" name="post_number" value=<%= dto.getPost_number() %>>
						댓글쓰기: <input type="text" id="comment" name="comment" placeholder="댓글 입력"> <input type="submit"  value="달기"> 
					</font>
					</td></tr>
		</form>
			</tbody>
		</table>	
		
		</div>
</body>
</html>