<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import= "project.model.dto.Post" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/post.css">


</head>

<body>
<div>
<jsp:include page="inc/search.jsp"/>
<jsp:include page="inc/userProfile.jsp"/>	
<jsp:include page="inc/loginCheck.jsp"/>	
</div>
<% Post dto =(Post)request.getAttribute("dto"); %>

<form action="updatePost" method="post" enctype="multipart/form-data">
	<div class="post">
	<input type="hidden" name="post_number" value=<%=dto.getPost_number() %>>
		<table class="postTable">
			<tbody>
				<tr><td colspan="2" class="postTop"><a href="mainPage.jsp"style="color: white;">뒤로가기</a></td></tr>
				
				<tr><td class="postImg"><img id="upload_img" name="img" src="<%= dto.getImg() %>" />
					<input type='file' accept="image/jpeg" id="img" name="f" multiple>
				</td>
				
				
				<td class="postContent" >
					<font style="color:white"><%= session.getAttribute("memberId")%></font>
					<hr>
					<div class="textArea">
						<textarea cols="40" rows="20" name="contents">
						 <%= dto.getContents()  %>
						</textarea>
					</div>
						
				</td>
				</tr>	
				<tr><td colspan="2"><input type="submit" id="submit" value="수정">  </td></tr>	

			</tbody>
		</table>	
		</div>
</form>
</body>
</html>