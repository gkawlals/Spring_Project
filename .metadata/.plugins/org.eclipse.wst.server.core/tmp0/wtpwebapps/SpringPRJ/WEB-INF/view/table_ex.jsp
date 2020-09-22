<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%for(int i = 0; i < 3; i++){ %>
<tr>
<%for(int j = 0; j < 4; j++){ %>
<td><%=i %>열 <%=j %>행</td>
<% } %>
</tr>
<% } %>
</table>
</body>
</html>