<%@page import="poly.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	BoardDto rDTO = (BoardDto) request.getAttribute("rDTO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=rDTO.getPost_title()%></title>
</head>
<body>
	<div style="width: 800px;">
		<h4><%=rDTO.getPost_title()%></h4>

		<hr>

		<div style="text-align: right;">
			작성자 :
			<%=rDTO.getReg_id()%></div>
		<div>
			<p><%=rDTO.getPost_content()%></p>
		</div>
		<hr>
		<div style="float: left;">
			<button onclick="location.href='/board/BoardList.do'">뒤로</button>
		</div>
		<div style="float: right;">
			<button
				onclick="location.href='/board/editPost.do?no=<%=rDTO.getPost_no()%>'">편집</button>
		</div>
		<div style="float: right;">
			<button onclick="confirmDelete();">삭제</button>
		</div>
	</div>

	<script type="text/javascript">
		function confirmDelete() {
			if (confirm("삭제할래?")) {
				location.href = "/board/DeletePost.do?no=
	<%=rDTO.getPost_no()%>";
	}
	
}
</script>
</body>
</html>