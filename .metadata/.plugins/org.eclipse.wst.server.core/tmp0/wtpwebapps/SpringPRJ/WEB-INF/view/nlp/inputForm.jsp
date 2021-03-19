<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감정분석을 위한 문장 입력 폼 </title>
</head>
<body>

<form name="form1" method="post" action="/nlp/wordAnalysis.do">

	<br />분석메세지 <br />
	<input type="text" name="text_message" style="width:400px" />
	<br />
	<br />
	<input type="submit" value="전송" />
</form>

</body>
</html>