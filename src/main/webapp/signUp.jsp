<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUp</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="inc/search.jsp"/>
<form action="signUp" method="post">
	<div id="signUp">
		<h2 align="center" style="color:white;">회원가입</h2>
		
		<table id="signUpTable">
			<tbody>
				<tr><td><input type="text" name="memberId" id="userId" class="signUpInput" placeholder="아이디"> </td></tr>
				<tr><td><input type="password" name="memberPw" id="userPw" class="signUpInput" placeholder="비밀번호"> 
				<i id="passwordVisible" class="fa fa-eye fa-lg"></i>
				<tr><td><input type="text" name="name" id="name" class="signUpInput" placeholder="이름"></td></tr>	
				<tr><td><input type="text" name="phone" id="phoneNumber" class="signUpInput" placeholder="전화번호"></td></tr>	
				<tr><td><input type="text" name= "email" id="email" class="signUpInput" placeholder="이메일"></td></tr>					
				<tr><td style="font-size: 12px; color: white;">--------------------------------------------</td></tr>
				<tr><td><input type="submit" class="submit" value="가입"></td></tr>
			</tbody>
		</table>
	</div>
</form>	
</body>
</html>

