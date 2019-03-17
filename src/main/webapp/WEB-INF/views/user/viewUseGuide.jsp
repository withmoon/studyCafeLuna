<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용가이드</title>
<link href="<c:url value="/resources/user/viewUseGuide/css/viewUseGuide.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
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
<div class="top">이용가이드</div>
<section>
<div class="border">
<!-- 제목/날짜 -->
<div class="title">
<p><b>${htuctlist.get(0).getTitle()}</b><input type="hidden" id="size" value="${size}"/>
</div>
<!-- 내용 -->
<c:forEach var="htuctlist" items="${htuctlist}">
<div class="content">
	${htuctlist.content } <br><br>
	<img style="width:700px; height:auto;" src="<c:url value="/resources/howtouseImg/${htuctlist.num}/${htuctlist.cnum-1}/${htuctlist.fname}"/>">
</div>
</c:forEach>
<div class="button"><button onclick="window.open('useGuide.do','_self');">목록</button></div>
</div>
</section>
<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>