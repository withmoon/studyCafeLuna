<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<meta charset="UTF-8"> 
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<style type="text/css">
#ex {
	background-color: orange;
	height: 30px;
}

#ex ul {
	padding-top: 3px;
	list-style: circle;
}

#ex ul li {
	display: inline;
	padding-left: 20px;
}

#exb {
	float: center;
}

#t {
	height: 100%;
	border-color: gray;
}

#t {
	margin-top: 20px;
	width: 100%;
	border-bottom-color: black;
}

#t tr td {
	text-align: center;
}

#ttr1 {
	background-color: orange;
}
</style>
<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav">
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<a href="manager.mdo"><img class="logo"
					src="<c:url value="/resources/public/logo/mainlogo.png"/>" /></a>
			</div>
			<jsp:include page="/WEB-INF/views/manager/form/TopMenu1.jsp"></jsp:include>
		</div>
		<%-- <div id="TopMenu2">
					<jsp:include page="form/TopMenu2.jsp" />
				</div> --%>
	</nav>

	<!-- 배경 -->
	<div id="border">
		<!-- 왼측1 사이드 -->
		<div id="left1div">
			
			<aside id="left1">
				<jsp:include page="/WEB-INF/views/manager/form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>문의 게시판</header>
			</div>
			<div>
				<div id="ex">
					<ul>
						<li><select name="select">
								<option>선택하세요</option>
								<option value="name">매장방문</option>
								<option value="tel">사이트방문</option>
						</select></li>
						<li id="exb"><input type="button" value="조회"></li>
					</ul>
				</div>

				<!-- db데이터 -->
				<table id="t">
					<tr id="ttr1">
						<th>매장방문</th>
						<th>방문횟수</th>
						<th>ID</th>
						<th>AGE</th>
						<th>선호인원</th>
					</tr>
					<tr>
						<td>1위</td>
						<td>20</td>
						<td>GD</td>
						<td>20대</td>
						<td>3인</td>
					</tr>
					<tr>
						<td>2위</td>
						<td>19</td>
						<td>TOP</td>
						<td>20대</td>
						<td>3인</td>
					</tr>
					<tr>
						<td>3위</td>
						<td>18</td>
						<td>TAEYANG</td>
						<td>20대</td>
						<td>2인</td>
					</tr>
				</table>

				<table id="t">
					<tr id="ttr1">
						<th>사이트방문</th>
						<th>방문횟수</th>
						<th>ID</th>
						<th>AGE</th>
						<th>게시물</th>
					</tr>
					<tr>
						<td>1위</td>
						<td>70</td>
						<td>GD</td>
						<td>20대</td>
						<td>10</td>
					</tr>
					<tr>
						<td>2위</td>
						<td>60</td>
						<td>TOP</td>
						<td>20대</td>
						<td>9</td>
					</tr>
					<tr>
						<td>3위</td>
						<td>50</td>
						<td>TAEYANG</td>
						<td>20대</td>
						<td>8</td>
					</tr>
				</table>
			</div>

		</section>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>