<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="poly.util.CmmUtil" %>
<% 
	String res = CmmUtil.nvl((String) request.getAttribute("res"));
%>
<html>
<head>
<meta charset="UTF-8">
<title>감정 분석 결과</title>
</head>
<body>
		<h2> 감정 분석 결과 </h2>
		<hr/>
		<br/>
		
		<%=res %>
</body>
</html>