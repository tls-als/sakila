<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login.jsp</title>
<!-- CSS 부트스트립트 사용 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jquery를 이용한 자바스크립트 사용 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#btn").click(function(){
			console.log("버튼 클릭");
			if($("#id").val() == ""){
				alert("아이디를 입력하세요");
				return;
			}
			else if($("#pw").val() == ""){
				alert("비밀번호를 입력하세요");
				return;
			}
			$("#loginForm").submit();
		});
	});
</script>
</head>
<body>
<div class="container">
	<h1 align="center">로그인 폼</h1>
	<div align="right">
	<!-- 오늘 접속자 수 : {map["stats"].cnt} / 전체 접속자 수 : {map["totalCount"]}  -->
		<h5>오늘 접속자 수 : ${stats.cnt} / 전체 접속자 수 : ${totalCount}</h5>
	</div>
	<form method="post" action="<%=request.getContextPath()%>/LoginServlet" id="loginForm"> 
		<div align="center">
			<img src="./images/login.png" class="rounded-circle" width="250" height="250">
		</div><br>
		<div align="center">
			<div class="form-group col-lg-4">
				 <!-- name은 파라미터로 넘길 때, id는 웹페이지 내에서 참조 -->
				<input type="text" class="form-control input-lg" width="300px" name="id" id="id" placeholder="ID">
			</div>
			<div class="form-group col-lg-4">
				<input type="password" class="form-control input-lg" name="pw" id="pw" placeholder="PW">
			</div>
		</div><br>
		<div align="center">
			<button class="btn btn-primary" type="button" id="btn">Login</button>
		</div>
	</form>
</div>
</body>
</html>