<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.GongDto"%>
<%@page import="poly.util.CmmUtil"%>
<%
	List<GongDto> rList = (List<GongDto>) request.getAttribute("rList");
%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- top 시작 -->
	<div>
		<%@ include file="/WEB-INF/view/user/top.jsp"%>
	</div>
	<!-- top 끝 -->
<div class="gongjiList">
<table border="1" id="gongjiList">
	<tr>
		<td>공지번호</td>
		<td>공지 글</td>
		<td>작성자 </td>
	</tr>
			<%
				for (GongDto e : rList) {
			%>
			<tr>
				<td><%=e.getGong_nm()%></td>
				<td><a href="/board/gonghjiDetail.do?no=<%=e.getGong_nm()%>"><%=e.getGong_txt()%></a></td>
				<td><%=e.getGong_id()%></td>

			</tr>
			<%
				}
			%>
</table>
</div>
<script>
	function search() {
		alert("test");
		var gong_txt = $('#gong_txt').val();
		alert("제목 : " + gong_txt);
		if ($('#gong_txt').val() == "") {
			$('#gong_txt').focus();
			return false;
		}

		console.log("gong_txt : " + gong_txt);

		$.ajax({
			url : '/board/searchGongji.do',
			type : 'post',
			data : {
				"gong_txt" : gong_txt
			},
			success : function(data) {
				console.log("test");
				console.log(data)

				var resHTML = "";
				resHTML += '<tr>';
				resHTML += '<td>공지 번호</td>';
				resHTML += '<td>공지 글</td>';
				resHTML += '<td>게시자</td>';
				resHTML += '</tr>';

				if (data.length == 0) {

					resHTML += '<tr>';
					resHTML += '<td>-</td>';
					resHTML += '<td>-</td>';
					resHTML += '<td>-</td>';
					resHTML += '</tr>';

				} else {

					for (var i = 0; i < data.length; i++) {
						resHTML += '<tr>';
						resHTML += '<td>' + data[i].gong_nm + '</td>';
						resHTML += '<td>' + data[i].gong_txt + '</td>';
						resHTML += '<td>' + data[i].gong_id + '</td>';
						resHTML += '</tr>';
					}

				}
				$("#searchGongji").html(resHTML);

			}
		})
	}
</script>
</body>

</html>