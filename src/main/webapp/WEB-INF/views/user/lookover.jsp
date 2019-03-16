<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 달빛</title>
<%-- --%><link rel="stylesheet" href="<c:url value="/resources/user/lookover/css/LookOver.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/public/css/topmenu.css"/>"/>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/user/lookover/js/LookOver.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/public/js/getSchedule.js"/>"></script>
</head>
<body style="overflow-x:hidden;">


<!-- 상단로고 -->
<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">방 찾기</div>

<!-- 상단 기본 바 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<!-- 지점 지정 -->
<section class="searchArea">
<p>날짜 적용후 이미지에 마우스를 올리시면 자세한 스케줄 확인이 가능합니다^^</p>
<select name="sido" id="sido_select">
<c:if test="${sel_sido eq '시/도 선택'}">
<option selected="selected" disabled="disabled" hidden="true">시/도 선택</option>
</c:if>
	<c:forEach  var="sidoList" items="${sido}">
		<c:if test="${sidoList eq sel_sido}">
			<option value="${sidoList}" selected="selected">${sidoList}</option>
		</c:if>
		<c:if test="${sidoList ne sel_sido}">
			<option value="${sidoList}">${sidoList}</option>
		</c:if>
	</c:forEach>
</select>

<!-- 시/군/구 -->
<select name="gugun" id="gugun_select"></select>

<input id="reservDate" type="date">
<button class="look" onclick="findCanReservRoom()">적용</button>

<input type="hidden" id="sel_gugun" value="${sel_gugun}"/>	
</section>

<!-- 검색결과 보여주는 곳 -->
<div class="showRoom" style="overflow-y:scroll;">

<c:forEach var="roomList" items="${roomList}">
<div class="showView">
<a href="roomDetail.udo?roomnum=${roomList.roomNum}"><img src="<c:url value="/resources/rooms/${roomList.fname}"/>"/></a><br/>
<a href="#">${roomList.roomName}</a><br/>
<label>(${roomList.branchName})</label><br/>
<label>${roomList.roomEx1}</label><br/>
<label>${roomList.roomEx2}</label><br/> 
<label>${roomList.roomEx3}</label>
</div>
</c:forEach>

</div>

<!-- 스케줄 구간 -->
<div class="showSchedule">
<p style="color:white">방을 예약하시려면 이미지를 클릭해주세요^^</p>
<p>선택하신 날짜 : <b><label id="startdate">0월 0일 00</label><label id="scroomname">방</label></b>의 스케줄입니다.</p><br/>
<table>
<tr>
<th>오전</th>
<td id="b1">00:00</td>
<td id="b2">00:30</td>
<td id="b3">01:00</td>
<td id="b4">01:30</td>
<td id="b5">02:00</td>
<td id="b6">02:30</td>
<td id="b7">03:00</td>
<td id="b8">03:30</td>
<td id="b9">04:00</td>
<td id="b10">04:30</td>
<td id="b11">05:00</td>
<td id="b12">05:30</td>
<td id="b13">06:00</td>
<td id="b14">06:30</td>
<td id="b15">07:00</td>
<td id="b16">07:30</td>
<td id="b17">08:00</td>
<td id="b18">08:30</td>
<td id="b19">09:00</td>
<td id="b20">09:30</td>
<td id="b21">10:00</td>
<td id="b22">10:30</td>
<td id="b23">11:00</td>
<td id="b24">11:30</td>
</tr>
<tr>
<th>오후</th>
<td id="b25">12:00</td>
<td id="b26">12:30</td>
<td id="b27">13:00</td>
<td id="b28">13:30</td>
<td id="b29">14:00</td>
<td id="b30">14:30</td>
<td id="b31">15:00</td>
<td id="b32">15:30</td>
<td id="b33">16:00</td>
<td id="b34">16:30</td>
<td id="b35">17:00</td>
<td id="b36">17:30</td>
<td id="b37">18:00</td>
<td id="b38">18:30</td>
<td id="b39">19:00</td>
<td id="b40">19:30</td>
<td id="b41">20:00</td>
<td id="b42">20:30</td>
<td id="b43">21:00</td>
<td id="b44">21:30</td>
<td id="b45">22:00</td>
<td id="b46">22:30</td>
<td id="b47">23:00</td>
<td id="b48">23:30</td>
</tr>
</table>
</div>

<footer>
<%@ include file="../public/footer.jsp" %>
</footer>

</body>
</html>