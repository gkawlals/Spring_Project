<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String user_no = (String)session.getAttribute("user_no");	
	
%>
<html>
<head>
<script type="text/javascript" src="/resource/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
function setThumbnail(event) { 
	
	var reader = new FileReader(); 
	
	reader.onload = function(event) { 
		
	var img = document.getElementById("img"); 
		
		img.setAttribute("src", event.target.result); 
		
		document.querySelector("div#imagePreview").appendChild(img); 
		
		}; 
		
	reader.readAsDataURL(event.target.files[0]); 
	
	var valll = $("#user_img").val();
	
	console.log(valll);
		}
</script>
<meta charset="UTF-8">
<title>프로필 사진 변경</title>
</head>
<body>
<div > 프로필 사진 변경 </div>
<form action="/user/ChUserImg.do " method="post" enctype="multipart/form-data">
<div>
	<input type="file" accept="image/*" name="file_path" id="user_img" onchange="setThumbnail(event);" /> <!-- accept = 이미지 파일만 받아옴  -->
	<input type="text" value="<%=user_no %>" />
</div>
	<div>
		<h3> 사진 미리보기</h3>
		<div id="imagePreview"  >
		<img id="img" class="img" name="img" style="width:300px; height:500px; boder:2px; object-fit : cover "/>
		</div>
		<br>
		<input type="submit" value="사진바꾸기"/>
		
	</div>
</form>
</body>
</html>