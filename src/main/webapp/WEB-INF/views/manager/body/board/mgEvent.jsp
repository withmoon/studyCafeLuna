<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/manager/js/manager2.js"/>"></script>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="<c:url value="/resources/user/event/js/event.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/board.css"/>"></link>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/eventboard.css"/>"></link>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower"
	rel="stylesheet">
<!-- 외부폰트 -->
<script type="text/javascript">
	function list(page) {
		location.href = "mgGong.do?curPage=" + page
				+ "&searchOption=${map.searchOption}"
				+ "&keywrod=${map.keyword}";
	}
</script>

<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav">
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<a href="manager.do"><img class="logo"
					src="<c:url value="/resources/public/logo/mainlogo.png"/>" /></a>
			</div>
			<jsp:include page="../../form/TopMenu1.jsp"></jsp:include>
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
				<jsp:include page="../../form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>이벤트 게시판</header>
			</div>


			<div id="board">
				<!-- 이벤트목록 -->
				<section>
					<div class="event-container">
						<ul class="eventTap">
							<li class="eventNow">진행중인이벤트</li>
							<li class="eventFinsh">종료된이벤트</li>
						</ul>
					</div>
				</section>

				<section class="list_tab">
					<!-- 이벤트 목록 -->
					<table class="eventNow2">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>날짜</th>
							</tr>
						</thead>
						<tbody id="my-tbody"></tbody>
					</table>
					<!-- 페이지목록 -->
					<ul id="pageT"></ul>
				</section>
			</div>
		</section>
		<jsp:include page="../../form/rigfht-side.jsp"></jsp:include>
	</div>
	<footer>
		<jsp:include page="../../form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>