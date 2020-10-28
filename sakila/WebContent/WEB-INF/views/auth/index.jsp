<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<!-- CSS 부트스트립트 사용 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- 스타일시트 참조 -->
<link rel="stylesheet" type="text/css" href="/sakila/sakilaStyle.css?ver=1"/>
<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css"/>
<!-- jquery를 이용한 자바스크립트 사용 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#logout').click(function() {
			document.loginForm.submit();
		});
	});
</script>
</head>
<div id="bg">
	<div id="outer">
		<div id="main">
			<div id="sidebar">
				<h3>
					Sakila Movie
				</h3>
				<form action="${pageContext.request.contextPath}/auth/LogoutServlet" name="loginForm">
					<table id="staff">
						<tr>
							<td rowspan="2"><a href="/sakila/StaffServlet" class='fas fa-user-circle' style='font-size:60px'></a></td>
							<td>서울 지점</td>
						</tr>
						
						<tr>
							<td>${loginStaff.email} 관리자님</td>
						</tr>
					</table>
					
					<div>
						<button type="button" id="logout">logout</button>
					</div>
				</form>
				<h3>
					Menu
				</h3>
				
				<ul class="linkedList">
					<li class="line">
						<a href="#">홈</a>
					</li>
					<li>
						<a href="#">영화 반납</a>
					</li>
					<li class="line">
						<a href="#">회원목록 관리</a>
					</li>
					<li>
						<a href="#">영화재고 관리</a>
					</li>
					<li>
						<a href="#">영화배우 관리</a>
					</li>
					<li>
						<a href="#">영화 출연배우 등록</a>
					</li>
					<li class="line">
						<a href="#">매장 통계</a>
					</li>
					<li class="last">
						<a href="#">MVP</a>
					</li>
				</ul>
			</div>
			
			<div id="content">
					<h2>index</h2>
					
					<p>◆ sakila 프로젝트</p>
					<p>목표: DVD 대여관리 프로그램</p>
					<div>
						<p>기능설명</p>
						<p>1. 매장의 DVD를 관리 및 대여</p>
						<p>2. 매장의 DVD를 관리 및 대여</p>
					</div>
					
				<br class="clear" />
			</div>
			<br class="clear" />
		</div>
		<br class="clear" />
			
		<div id="copyright">
				&copy; sakila | Made by byoungyoon
		</div>
	</div>
</div>
</body>
</html>