<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 달빛</title>
<link href="<c:url value="/resources/user/event/css/event.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="<c:url value="/resources/user/event/js/event.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>

</head>
<body style="overflow-x:hidden; overflow-y:auto;">


<!-- 상단로고 -->
<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">이벤트</div>
<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>
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
		<th class="shortTD">번호</th>
		<th class="subjectTD">제목</th>
		<th class="shortTD">작성자</th>
		<th>날짜</th>
	</tr>
</thead>
	<tbody id="my-tbody"></tbody>
</table>
<!-- 페이지목록 -->
<ul id="pageT"></ul>
</section>

<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>