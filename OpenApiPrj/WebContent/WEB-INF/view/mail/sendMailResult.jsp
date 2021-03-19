<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<%
	String jspRes = CmmUtil.nvl((String)request.getAttribute("res"),"0");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<text>성공인가?</text>
<%=session.getAttribute("toMail")%>로 메일이 발송되었습니다. 
제목: <%=session.getAttribute("title")%> 
내용: <%=session.getAttribute("content")%>
</body>
</html>