<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과</title>
<link type="text/css" rel="stylesheet" href="css/search.css">
</head>
<body>
	<jsp:include page="inc/search.jsp"/>
	
	<jsp:include page="inc/userProfile.jsp"/>	
	
	<div class="content">
	<p style="text-align: center; font-size: 20px; color:white;"> ... 에 대한 검색결과</p>
			<div class="interContent">
			
				<table class="contentBox">	
						<tr><td class="userIdInContent">작성자id</td></tr>
						<tr><td>내용</td></tr>
						<tr><td class="commentArea">댓글영역(최신순)</td></tr>
				
				</table>
			</div>
		</div>
	
</body>
</html>