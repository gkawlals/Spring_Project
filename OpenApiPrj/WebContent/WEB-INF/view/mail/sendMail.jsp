<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/mail/sendMailResult.do" method="post">

<%System.out.printf("메일보내기 시작"); %>
<br>
메일 받는 사람 <input type="text" name="toMail" required>
<br>
메일 제목 <input type="text" name="title" required><br>
메일 내용 <br> <textarea style="width:500px; height:500px;" name="content" required>
</textarea>
<br>
<input type="submit" value="메일보내기" name="MailButton">

</form>
</body>
</html>