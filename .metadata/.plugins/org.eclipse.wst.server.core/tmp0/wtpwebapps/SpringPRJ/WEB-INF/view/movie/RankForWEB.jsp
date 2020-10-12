<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="poly.util.CmmUtil" %>
<%
	String res = CmmUtil.nvl((String)request.getAttribute("res"),"0");
	%>
<html>
<head>
<meta charset="UTF-8">
<title>CGV 영화수집 결과 </title>
</head>
<body>
CGV 영화홈페이지에서 <%=res %>개의 영화 순위 정보가 수집 되었습니다.
</body>
</html>