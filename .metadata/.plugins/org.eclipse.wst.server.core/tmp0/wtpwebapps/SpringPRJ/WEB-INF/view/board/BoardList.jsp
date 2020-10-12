<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.BoardDto"%>
<%@page import="poly.util.CmmUtil"%>
<%
	List<BoardDto> rList = (List<BoardDto>) request.getAttribute("rList");
%>
<!DOCTYPE html>
<html>
<head>
<!-- top Start  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- top 시작 -->
	<div>
		<%@ include file="/WEB-INF/view/user/top.jsp"%>
	</div>
	<!-- top 끝 -->

	<div style="display: inline-block; magin: 0;">
		<div class="input-gruop">
			<input type="text" placeholder="이름" name="post_title" id="post_title"
				style="hieght: 40ox !important" /> <input type="button"
				onclick="JavaScript:search();" value="검색" />
		</div>
	</div>
	<div id="subject"> <input type="text" valuse="여자친구"></div>
	<div id="resContainer"></div>
	<div class="searchList">
		<table border='1' id="searchLsit">
			<tr>
				<td>글 번호</td>
				<td>제목</td>
				<td>게시일</td>
				<td>게시자</td>
			</tr>

			<%
				for (BoardDto e : rList) {
			%>
			<tr>
				<td><%=e.getPost_no()%></td>
				<td><a href="/board/boardDetail.do?no=<%=e.getPost_no()%>"><%=e.getPost_title()%></td>
				</a>
				<td><%=e.getReg_dt()%></td>
				<td><%=e.getReg_id()%></td>

			</tr>
			<%
				}
			%>
		</table>
		<div> 
		<button type=button onclick="location.href='/board/gongji.do'">공지사항 </button>
		</div>
	</div>
	<div style="width: 100%; text-align: right; magin-top: 5px;">

		<button type=button onclick="location.href='/board/newPost.do'">새글</button>
	</div>
</body>
<script>
	function search() {
		//alert("test");
		var post_title = $('#post_title').val();
		//alert("제목 : " + post_title);
		if ($('#post_title').val() == "") {
			$('#post_title').focus();
			return false;
		}

		console.log("post_title : " + post_title);

		$.ajax({
			url : '/board/searchList.do',
			type : 'post',
			data : {
				"post_title" : post_title
			},
			success : function(data) {
				console.log("test");
				console.log(data)

				var resHTML = "";
				resHTML += '<tr>';
				resHTML += '<td>글 번호</td>';
				resHTML += '<td>제목</td>';
				resHTML += '<td>게시일 </td>';
				resHTML += '<td>게시자</td>';
				resHTML += '</tr>';

				if (data.length == 0) {

					resHTML += '<tr>';
					resHTML += '<td>-</td>';
					resHTML += '<td>-</td>';
					resHTML += '<td>-</td>';
					resHTML += '<td>-</td>';
					resHTML += '</tr>';

				} else {

					for (var i = 0; i < data.length; i++) {
						resHTML += '<tr>';
						resHTML += '<td>' + data[i].post_no + '</td>';
						resHTML += '<td>' + data[i].post_title + '</td>';
						resHTML += '<td>' + data[i].reg_dt + '</td>';
						resHTML += '<td>' + data[i].reg_id + '</td>';
						resHTML += '</tr>';
					}

				}
				$("#searchLsit").html(resHTML);

			}
		})
	}
</script>
</html>