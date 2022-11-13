<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
</head>
<body>

<jsp:include page="inc/search.jsp"/>
	<div id="login">
		<h2 align="center" style="color:white;">로그인</h2>
		<form action="login" method="post">
		<table id="loginTable">
			<tbody>
				<tr><td><input type="text" name="memberId" id="userId" class="loginInput" placeholder="아이디"> </td></tr>
				<tr><td><input type="password" name="memberPw" id="userPw" class="loginInput"  placeholder="비밀번호"> 
				<i id="passwordVisible" class="fa fa-eye fa-lg"></i>
				</td></tr>	
				<tr><td></td></tr>	
				<tr><td><input type="submit" class="submit" value="로그인"></td></tr>
				
			</tbody>
		</table>
		<p style="font-size: 12px; color: white;  text-align: center;">--------------------------------------------<p>
		<table id="ifNotUser">
			<tbody>
				<tr><td><a href="signUp.jsp" style="font-size: 12px; color: white;">회원이 아니신가요?</a></td></tr>	
			</tbody>
		</table>
		</form>
	</div>

</body>
</html>