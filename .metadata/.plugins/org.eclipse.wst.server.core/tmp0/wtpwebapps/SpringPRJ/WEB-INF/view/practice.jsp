<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ex_note</title>
</head>
<body>
<from>
<input type='text' value='지민'>
</body>
<% for(int i = 0; i < 5; i++){ %>
<p><%=i %>번째 안녕?</p>

<% } %>
</html>