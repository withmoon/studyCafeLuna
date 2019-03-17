<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용가이드</title>
<link href="<c:url value="/resources/user/useGuide/css/useGuide.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
</head>
<body  style="overflow-x:hidden; overflow-y:auto;">
<!-- 상단 메뉴 -->
<!-- 상단로고 -->
<a href="<c:url value="/home.do"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">이용가이드</div>

<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<section>
<table class="guideT">
<tbody>
<c:if test="${fn:length(htulist) eq 0}">
	<tr><td>아직 올린글이 없습니다.</td></tr>
</c:if>
<c:if test="${fn:length(htulist) ne 0}">
<c:forEach var="htulist" items="${htulist}">
	<tr>
		<td><a href="viewUseGuide.do?num=${htulist.num}">${htulist.title}</a></td>
	</tr>
</c:forEach>
</c:if>
</tbody>
</table>
</section>
<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>