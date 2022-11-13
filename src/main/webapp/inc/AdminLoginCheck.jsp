<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
<% 	session= request.getSession();
	if (session.getAttribute("memberId")==null || session.getAttribute("grade")==null){
		
		%>		
	alert("관리자 전용 서비스 입니다. 관리자 아이디로 로그인을 해주십시오.");
	location.href="login.jsp";
<%	}
%>
</script>
