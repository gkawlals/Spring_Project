<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user/newUser.do" method="post">
아이디 <input type="text" name="user_id"> 	
<!--  <a href="/user/idcheck"> <input type="button" value="중복확인"> </a>-->

<br>
이름 <input type="text" name="name">
<br>
비밀번호 <input type="password" name="password" maxlength="10">
<br>
Email<input type="email" name="email">
<br>
<% %>
<input type="submit" value="회원가입">

</form>
</body>
</html>