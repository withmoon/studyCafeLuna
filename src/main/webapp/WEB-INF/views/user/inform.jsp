<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width" />
<title>달빛 스터디카페</title>
<link href="<c:url value="/resources/user/inform/css/inform.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/user/inform/js/inform.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">


<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<!-- 상단로고 -->
<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">고객센터</div>
<!-- 고/공/자 이미지 -->
<section class="menu">
<a class="informNotice">
	<img onmouseenter="this.src='<c:url value="/resources/user/inform/images/announcein.png"/>'" onmouseleave="this.src='<c:url value="/resources/user/inform/images/announce.png"/>'"  src="<c:url value='/resources/user/inform/images/announce.png'/>"/>
</a> <!-- 공지사항 -->
<a class="informQnA">
	<img onmouseenter="this.src='<c:url value="/resources/user/inform/images/questionin.png"/>'" onmouseleave="this.src='<c:url value="/resources/user/inform/images/question.png"/>'" src="<c:url value='/resources/user/inform/images/question.png'/>"/>
</a> <!-- 자주묻는질문 -->
<a class="informUser">
	<img onmouseenter="this.src='<c:url value="/resources/user/inform/images/userin.png"/>'" onmouseleave="this.src='<c:url value="/resources/user/inform/images/user.png"/>'" src="<c:url value='/resources/user/inform/images/user.png'/>"/>
</a> <!-- 고객의 소리 -->
</section>

<!-- 공지 +자주묻는 질문 -->
<section class="list_tab">
<table class="inform_list">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>날짜</th>
	</tr>
</thead>
<tbody id="inform_table"></tbody>
</table>
<ul id="informPaging"></ul>
</section>


<!-- 고객의 소리 구간-->
<section class="list_tab2">
<div class="inform_user">
<c:if test="${member.id == null }">
	<p>"<b>로그인</b>후 이용가능합니다"<br>
	해당내용은 로그인 하신 후에 확인가능합니다.<br>
	더 많은 내용을 보시려면 로그인 해주세요<br><br>
	<a href="<c:url value="/login.do"/>">로그인 하러가기</a></p>
	<div class="login"><img src="<c:url value="/resources/user/inform/images/login.png"/>"></div>
</c:if>
<c:if test="${member.id != null }">
	<div><label>문의지점</label>
		<!-- 시/도 -->
		<select name="sido" id="sido_select">
			<option selected="selected" disabled="disabled" hidden="true">시/도 선택</option>
		<c:forEach  var="sidoList" items="${sido}">
			<option value="${sidoList}">${sidoList}</option>
		</c:forEach>
		</select>&emsp;
		<!-- 시/군/구 -->
		<select name="gugun"></select>&emsp;
		<!-- 문의지점 -->
		<select id="branch" name="branch"></select>
	</div>
	<div><label>제목</label>
		<input type="text" id="title" name="title" placeholder="제목을 입력해주세요"/>
	</div>
	<div><label>내용</label>
		<textarea cols="120" id="content" rows="10" placeholder="내용을 입력해주세요"></textarea>
	</div>
	<div class="informbox2">
		<img src="<c:url value="/resources/user/inform/images/send.png"/>">&nbsp;<button onclick='userCommand()'>보내기</button>
	</div>
</c:if>
</div> 
</section>

<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>