<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link href="<c:url value="/resources/user/viewNotice/css/viewNoticeQnA.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/user/viewNotice/js/viewNotice.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
<header>
<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>
</header>

<!-- 상단로고 -->
<a href="<c:url value="/home.do"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">공지사항</div>

<section>
<div class="border">
<!-- 제목/날짜 -->
<div class="title">
<p><b>${nbv.title } </b>
<span class="writer">${nbv.writer }</span>
<span class="date">
	<fmt:formatDate value="${nbv.regdate }" pattern="yy-MM-dd" />
</span></p>
</div>
<!-- 내용 -->
<div class="content">
	${nbv.content }
</div>
<!-- 댓글 -->
<div class="reply">
	<b class="replyOnOff" onclick="replyOnOff(${nbv.num})">댓글 보기/닫기</b><img src="<c:url value="/resources/user/viewNotice/images/reply.png"/>">
	<div class="reply2">
	<!-- 댓글 목록 -->
	<div class="replyList"></div>
	<ul id="replyPaging"></ul>
	<!-- 댓글 올리기 -->
	<c:if test="${member.id != null }">
	<div class="replytextForm">
		<input type="hidden" id="num" value="${nbv.num }">
		<textarea id="replytext" name="replytext" rows="3" cols="65" placeholder="댓글을 작성해주세요"></textarea>
    	<button onclick='writeCommand(${nbv.num})'>올리기</button>
    </div>
    </c:if>
    <c:if test="${member.id == null }">
    <div class="replytextForm">
    	<b>로그인후 입력이 가능합니다.</b>
    </div>
    </c:if>
    </div>
</div>
<div class="button"><button onclick="window.open('inform.do','_self');">목록</button></div>
</div>
</section>
<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>