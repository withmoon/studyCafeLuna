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
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
<!-- 상단로고 -->
<a href="<c:url value="/home.do"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">자주묻는질문</div>
<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<section>
<div class="border">
<!-- 제목/날짜 -->
<div class="title">
<p><b>${qbv.subject } </b>
<span class="writer">관리자</span>
<span class="date">
	<fmt:formatDate value="${qbv.regdate }" pattern="yy-MM-dd" />
</span></p>
</div>
<!-- 내용 -->
<div class="content">
	${qbv.content }
</div>
</div>
</section>
<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>