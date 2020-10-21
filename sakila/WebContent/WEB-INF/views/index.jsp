<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<!-- CSS 부트스트립트 사용 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jquery를 이용한 자바스크립트 사용 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
	<h1>인덱스 화면</h1>
	<div>
		ID: ${loginStaff.getStaffId()}
	</div>
	<div>
		유저이름 : ${loginStaff.getUserName()}
	</div>
</div>
</body>
</html>