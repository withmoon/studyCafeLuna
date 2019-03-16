<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비번 찾기</title>
<link href="<c:url value="/resources/public/css/join.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower"rel="stylesheet"><!-- 외부폰트 -->
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="<c:url value="/resources/public/js/join.js"/>"></script>
</head>
<body>
	<!-- 로고 -->
	<a href="../Home/Home.jsp" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
	<div class="top">ID/PW 찾기</div>
	
	<!-- 아디/비번 버튼 -->
	<section>
		<div class="user">
			<div class="inside">
				<span>찾기</span>
				<div class="tie-wrap">
					<div class="tie"></div>
				</div>
			</div>
			<div class="button">
				<div class="front">
					<span>ID</span>
				</div>
				<div class="back"></div>
			</div>
		</div>
		<div class="manager">
			<div class="inside">
				<span>찾기</span>
				<div class="tie-wrap">
					<div class="tie"></div>
				</div>
			</div>
			<div class="button">
				<div class="front">
					<span>PW</span>
				</div>
				<div class="back"></div>
			</div>
		</div>
	
	
		<!-- 아이디/비번 폼 -->
		<div class="join">
			<img src="<c:url value="/resources/public/images/line.png"/>"/>
			<!-- 아이디찾기 -->
			<table align="center">
				<tr><td>
					<input type="text" name="name" size="50">
					<label>Name</label>
				</td></tr>
				<tr><td>
					<input type="tel" name="tel" size="50">
					<label>Tel</label>
				</td></tr>
				<tr><td>
					<input type="email" name="email" size="50">
					<label>Email</label>
				</td></tr>
			</table>
			<div align="center"><button>ID 찾기</button></div>
			<!-- 비번찾기 -->
			<!-- <table align="center">
				<tr><td>
					<input type="text" name="id" size="50">
					<label>ID</label>
				</td></tr>
				<tr><td>
					<input type="text" name="name" size="50">
					<label>Name</label>
				</td></tr>
				<tr><td>
					<input type="tel" name="tel" size="50">
					<label>Tel</label>
				</td></tr>
				<tr><td>
					<input type="email" name="email" size="50">
					<label>Email</label>
				</td></tr>
			</table>
			<div align="center"><button>PW 찾기</button></div> -->
			<!-- <table align="center">
				<tr><td>
					<input type="password" name="pw" size="50">
					<label>PassWorld</label>
				</td></tr>
				<tr><td>
					<input type="password" name="repw" size="50">
					<label>Confirm PassWorld</label>
				</td></tr>
			</table>
			<div align="center"><button>PW 변경</button></div> -->
			<img src="<c:url value="/resources/public/images/line.png"/>"/>
		</div>
	</section>
</body>
</html>