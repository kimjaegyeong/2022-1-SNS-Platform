<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<body>
	<div class= "profile">
		

		<table border="1">

				<!-- 유저 id -->
			<tr><td class="profileTd"><%= session.getAttribute("memberId") %></td></tr>
			
			<tr><td class="profileTd" onClick="location.href='post.jsp'">게시물 작성</td></tr>
			
			<tr><td class="profileTd" onClick="location.href='myPost'">내 게시물 보기</td></tr>
			
	</table>
</div>
</body>
 