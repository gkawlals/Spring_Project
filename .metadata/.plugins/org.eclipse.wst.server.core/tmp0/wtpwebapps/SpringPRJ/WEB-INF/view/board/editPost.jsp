<%@page import="poly.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    BoardDto rDTO = (BoardDto)request.getAttribute("rDTO");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=rDTO.getPost_title() %></title>
</head>
<body>
<form action="/board/doEdit.do" method="post">
<div>제목</div>
<div><input type="text" name="post_title" style="width:500px;" required value="<%=rDTO.getPost_title() %>"> </div>
<br>
<div> <textarea name="post_content" required style="width:500px; heigth:500px;" >
<%=rDTO.getPost_content() %>
</textarea> </div>
<input value="<%=rDTO.getPost_no() %>" name="post_no" hidden="hidden">
<div><input type="submit"></div>
</form>
</body>
</html>