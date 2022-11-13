<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
<% 	session= request.getSession();
	if (session.getAttribute("memberId")==null){
		
		%>		
	alert("회원 전용 서비스 입니다. 로그인을 해주십시오.");
	location.href="login.jsp";
<%	}
%>
</script>
