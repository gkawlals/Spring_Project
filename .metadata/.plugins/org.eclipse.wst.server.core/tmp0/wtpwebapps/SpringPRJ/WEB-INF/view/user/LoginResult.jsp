<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="poly.util.CmmUtil" %>
<!DOCTYPE html>
<%
	String user_id = CmmUtil.nvl((String)session.getAttribute("user_id"));
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 완료 화면 </title>
</head>
<body>
<%
	String msg = "";
if(user_id.isEmpty()){
	msg = " 아이디, 비밀번호가 일치하지 않습니다.";
}else {
	msg = user_id + " 님이 로그인하셨습니다 ";
}
%>
<%=msg %>
</body>
</html>