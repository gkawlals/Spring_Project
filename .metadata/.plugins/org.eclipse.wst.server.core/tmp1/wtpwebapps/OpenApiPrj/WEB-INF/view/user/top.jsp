<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="poly.util.CmmUtil"%>
<%
    	String name = CmmUtil.nvl ((String)session.getAttribute("name"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="background-color: skyblue">
	top!!!!!!!!!!!!!!!!!!!!!
	</div>
	<ul>
		<li>
			<%if(name.isEmpty()){ %> 
			<a href="/user/userLogin.do"> 로그인 </a>
			<% } else { %> 
			<%=name %>님 환영합니다! <a href="/user/userLogout.do"> 로그아웃 </a> 
			 <%} %> 
		</li>
		<li>
			 <a href="/user/userinsert.do"> 회원가입 </a>
		</li>
	</ul>
</body>
</html>