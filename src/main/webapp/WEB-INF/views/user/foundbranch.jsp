<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"  content="width=device-width, initial-scale=1.0"/>
<title>스터디카페 달빛_근처 지점 찾기</title>
<link rel="stylesheet" href="<c:url value="/resources/public/css/topmenu.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/user/found/css/FoundBranch.css"/>"/>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->

</head>
<body style="overflow-x:hidden;">

<!-- 상단 로고 -->
<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">근처 지점 찾기</div>
<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>
<section>

<!-- 검색어 입력 -->
<div class="searchArea">
<form onsubmit="searchPlaces(); return false;">
<input id="keyword" type="text" placeholder="서울" value="서울" size="30"/>
<button type="submit">찾기</button>
</form>
</div>

<!-- 지도 및 검색결과 틀 -->
<article id="mapSec">
<!-- 지도 div -->
<div id="map"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=da37e5836c002230d358ce5af57a57ca&libraries=services"></script>
<script type="text/javascript" src="<c:url value="/resources/user/found/js/founding.js"/>"></script>

<!-- 결과값 전송받을 div -->
<div id="mapResult" style="padding:5px;z-index:1;overflow-y:scroll;">
<div id="menu_wrap" class="bg_white">
<hr>
<ul id="placesList"></ul>
<div id="pagination"></div>
</div>
</div>
</article>
</section>
<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>

 
</body>
</html>