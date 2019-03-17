<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="<c:url value="/resources/user/home/css/home.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/user/home/js/home.js"/>"></script>
</head>
<body style="overflow-x:hidden;">
	
	<!-- 상단로고 -->
	<a href="<c:url value="/home.do"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
	<div class="top">HOME</div>
	
	<!-- 상단메뉴 -->
	<nav>
		<%@ include file="../public/topmenu.jsp" %>
	</nav>
	
	<section>
	
	<!-- 배너 -->
	<div>
		<div align="center"  class="banner">
			<img id="banner" src="<c:url value="/resources/user/home/images/studyhome.png"/>" >
		</div>
		
		<div onmouseover="view1(true)" onmouseout="view1(false)">
    		<img class="whole" alt="전체지점수" src="<c:url value="/resources/user/home/images/whole.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/whole.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/whole2.png"/>'">
		</div>
		<div id="whole2">
    		<b>☆전국 ${allBranchCount}개의 스터디카페 달빛☆</b><br> <!-- 지점명이 있고 상태가 0인 지점 갯수 넣어주기 -->
        	
        </div>
        <div onmouseover="view2(true)" onmouseout="view2(false)">
    		<img class="previous" alt="전월이용고객님" src="<c:url value="/resources/user/home/images/previous.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/previous.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/previous2.png"/>'">
		</div>
		<div id="previous2">
    		<b>${allMemberCount}명 고객님들 감사합니다~</b><br> <!-- 예약 테이블에서 작년 예약수 count(*)해서 넣기 -->
        	작년 예약수 : ${preYearReserveCount}명 올해 예약수 : ${thisYearReserveCount}명  
        </div>
        <div onmouseover="view3(true)" onmouseout="view3(false)">
    		<img class="accumulate" alt="고객님이용횟수" src="<c:url value="/resources/user/home/images/accumulate.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/accumulate.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/accumulate2.png"/>'">
		</div>
		<div id="accumulate2">
    		<b>${allMemberCount}명 고객님들이 증명합니다</b><br> <!-- 전일 : 현재날짜에서 하루 빠진 날의 예약 수 count(*)  전월 : 현재날짜에서 한달빼고 나온 월의 예약수 count-->
        	전일 예약수 : ${preDayReserveCount}명  전월예약 수 : ${preMonthReserveCount}명
        </div>
	</div>
	
	<!-- 선택창 -->
	<!-- 시/도 -->
	<div align="center" class="slctDiv">
	<label>♡시/도와 시/구/군을 선택후 찾기를 눌러주세요♡</label><br/>
	<select name="sido" id="sido_select">
	<option selected="selected" disabled="disabled" hidden="true">시/도 선택</option>
		<c:forEach  var="sidoList" items="${sido}">
			<option value="${sidoList}">${sidoList}</option>
		</c:forEach>
	</select>
	<!-- 시/군/구 -->
	<select name="gugun" id="gugun_select"></select>
	<button class="btn_find" onclick="findRoom()">찾기</button>
	</div>
	<!-- 여기까지 선택창 -->
	
	<!-- 인기순/조회수/new -->
	<div class="roomTable" align="center">
		<p class="fmroom"><img class="line" src="<c:url value="/resources/user/home/images/line.png"/>">&emsp;♡달빛 인기 공간♡&emsp;<img class="line" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table>
			<tr>
			<c:forEach var="reviewRankList" items="${reviewRankList}">
				<td onclick="goToRoomDetail(${reviewRankList.roomNum})">
				<div class="slider">
				<figure>
					<img src="<c:url value="/resources/rooms/${reviewRankList.fname1}"/>" alt="">
					<img src="<c:url value="/resources/rooms/${reviewRankList.fname2}"/>" alt="">
					<img src="<c:url value="/resources/rooms/${reviewRankList.fname3}"/>" alt="">
					<img src="<c:url value="/resources/rooms/${reviewRankList.fname4}"/>" alt="">
				</figure>
				</div>
				</td>
			</c:forEach>
			</tr>
			<tr class="exptr">
			<c:forEach var="reviewRankList" items="${reviewRankList}">
				<td onclick="goToRoomDetail(${reviewRankList.roomNum})">
				<img src="<c:url value="/resources/util/star.png"/>"> ${reviewRankList.starct} 점 <img src="<c:url value="/resources/util/star.png"/>"><br/>
				${reviewRankList.roomlocate}<br/>${reviewRankList.roomname}</td>
			</c:forEach>
			</tr>
		</table>
		<!-- 예약 수 -->
		<p class="lkroom"><img class="line" src="<c:url value="/resources/user/home/images/line.png"/>">&emsp;☆예약 많은 공간☆&emsp;<img class="line" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table>
			<tr>
			<c:forEach var="reserveRankList" items="${reserveRankList}">
				<td onclick="goToRoomDetail(${reserveRankList.roomNum})">
				<div class="slider">
				<figure>
					<img src="<c:url value="/resources/rooms/${reserveRankList.fname1}"/>" alt="">
					<img src="<c:url value="/resources/rooms/${reserveRankList.fname2}"/>" alt="">
					<img src="<c:url value="/resources/rooms/${reserveRankList.fname3}"/>" alt="">
					<img src="<c:url value="/resources/rooms/${reserveRankList.fname4}"/>" alt="">
				</figure>
				</div>
				</td>
			</c:forEach>
			</tr>
			<tr class="exptr">
			<c:forEach var="reserveRankList" items="${reserveRankList}">
				<td onclick="goToRoomDetail(${reserveRankList.roomNum})">
					<img src="<c:url value="/resources/util/clock.png"/>">총 ${reserveRankList.totaltime} 시간 <img src="<c:url value="/resources/util/clock.png"/>"><br/>
						${reserveRankList.roomlocate}<br/>${reserveRankList.roomname}
				</td>
			</c:forEach>
			</tr>
		</table>
		
		<!-- 달빛 지점 신규 -->
		<p class="fmroom"><img class="line" src="<c:url value="/resources/user/home/images/line.png"/>">&emsp;♡달빛 신규 공간♡&emsp;<img class="line" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table>
			<tr class="imghover">
			<c:forEach var="newBranchList" items="${newBranchList}">
				<td><img onclick="gotoLookOver('${newBranchList.sido}','${newBranchList.gugun}')" class="roomImage" src="<c:url value="/resources/branchImg/${ newBranchList.branchimg}"/>"></td>
			</c:forEach>
			</tr>
			<tr class="exptr">
			<c:forEach var="newBranchList" items="${newBranchList}">
				<td  onclick="gotoLookOver('${newBranchList.sido}','${newBranchList.gugun}')">${newBranchList.branchAddr1}<br/>${newBranchList.branchName}<br/>${newBranchList.branchtel}</td>
			</c:forEach>
			</tr>
		</table>
	<p><img class="rline" src="<c:url value="/resources/user/home/images/line.png"/>">&emsp;✌달빛 최근 리뷰✌&emsp;<img class="rline" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
</div>
	<div class="review">
      <table>
     	<tr>
     		<td rowspan="5" onclick="goToRoomDetail(${newReviewList.get(0).getRoomNum()})"><img class="rvwroomImg" src="<c:url value="/resources/rooms/${newReviewList.get(0).getFname1()}"/>"></td>
     		<td  class="starImg"  onclick="goToRoomDetail(${newReviewList.get(0).getRoomNum()})">
     			<c:forEach begin="1" end="${newReviewList.get(0).getStarct()}">
     				<img src="<c:url value="/resources/util/star.png"/>">
     			</c:forEach>
     		</td>
     		<td rowspan="5" onclick="goToRoomDetail(${newReviewList.get(1).getRoomNum()})"><img class="rvwroomImg" src="<c:url value="/resources/rooms/${newReviewList.get(1).getFname1()}"/>"></td>
     		<td  class="starImg"  onclick="goToRoomDetail(${newReviewList.get(1).getRoomNum()})">
				<c:forEach begin="1" end="${newReviewList.get(0).getStarct()}">
     				<img src="<c:url value="/resources/util/star.png"/>">
     			</c:forEach>
			</td>     		
     	</tr>
     	
     	<tr>
     		<td onclick="goToRoomDetail(${newReviewList.get(0).getRoomNum()})" style="color:tan">${newReviewList.get(0).getRoomlocate()}</td>
     		<td  onclick="goToRoomDetail(${newReviewList.get(1).getRoomNum()})" style="color:tan">${newReviewList.get(1).getRoomlocate()}</td>
     	</tr>
     	<tr>
     		<td  onclick="goToRoomDetail(${newReviewList.get(0).getRoomNum()})" style="color:tan">${newReviewList.get(0).getRoomname()}</td>
     		<td  onclick="goToRoomDetail(${newReviewList.get(1).getRoomNum()})" style="color:tan">${newReviewList.get(1).getRoomname()}</td>
     	</tr>
     	<tr>
     		<td  onclick="goToRoomDetail(${newReviewList.get(0).getRoomNum()})">${newReviewList.get(0).getName()}님 ${newReviewList.get(0).getWritedate()}</td>
     		<td  onclick="goToRoomDetail(${newReviewList.get(1).getRoomNum()})">${newReviewList.get(1).getName()}님 ${newReviewList.get(0).getWritedate()}</td>
     	</tr>
     	<tr>
     		<td  onclick="goToRoomDetail(${newReviewList.get(0).getRoomNum()})">${newReviewList.get(0).getReviewcontent()}</td>
     		<td  onclick="goToRoomDetail(${newReviewList.get(1).getRoomNum()})">${newReviewList.get(1).getReviewcontent()}</td>
     	</tr>
     	<tr>
     		<td rowspan="5"  onclick="goToRoomDetail(${newReviewList.get(2).getRoomNum()})"><img class="rvwroomImg" src="<c:url value="/resources/rooms/${newReviewList.get(2).getFname1()}"/>"></td>
     		<td  class="starImg" >
     			<c:forEach begin="1" end="${newReviewList.get(2).getStarct()}">
     				<img src="<c:url value="/resources/util/star.png"/>">
     			</c:forEach>
     		</td>
     		<td rowspan="5"  onclick="goToRoomDetail(${newReviewList.get(3).getRoomNum()})"><img class="rvwroomImg" src="<c:url value="/resources/rooms/${newReviewList.get(3).getFname1()}"/>"></td>
     		<td  class="starImg" >
				<c:forEach begin="1" end="${newReviewList.get(3).getStarct()}">
     				<img src="<c:url value="/resources/util/star.png"/>">
     			</c:forEach>
			</td>     		
     	</tr>
     	
     	<tr>
     		<td onclick="goToRoomDetail(${newReviewList.get(2).getRoomNum()})" style="color:tan">${newReviewList.get(2).getRoomlocate()}</td>
     		<td onclick="goToRoomDetail(${newReviewList.get(3).getRoomNum()})" style="color:tan">${newReviewList.get(3).getRoomlocate()}</td>
     	</tr>
     	<tr>
     		<td onclick="goToRoomDetail(${newReviewList.get(2).getRoomNum()})" style="color:tan">${newReviewList.get(2).getRoomname()}</td>
     		<td onclick="goToRoomDetail(${newReviewList.get(3).getRoomNum()})" style="color:tan">${newReviewList.get(3).getRoomname()}</td>
     	</tr>
     	<tr>
     		<td onclick="goToRoomDetail(${newReviewList.get(2).getRoomNum()})">${newReviewList.get(2).getName()}님 ${newReviewList.get(2).getWritedate()}</td>
     		<td onclick="goToRoomDetail(${newReviewList.get(3).getRoomNum()})">${newReviewList.get(3).getName()}님 ${newReviewList.get(3).getWritedate()}</td>
     	</tr>
     	<tr>
     		<td onclick="goToRoomDetail(${newReviewList.get(2).getRoomNum()})">${newReviewList.get(2).getReviewcontent()}</td>
     		<td onclick="goToRoomDetail(${newReviewList.get(3).getRoomNum()})">${newReviewList.get(3).getReviewcontent()}</td>
     	</tr>
     	<tr>
     		<td rowspan="5" onclick="goToRoomDetail(${newReviewList.get(4).getRoomNum()})"><img class="rvwroomImg" src="<c:url value="/resources/rooms/${newReviewList.get(4).getFname1()}"/>"></td>
     		<td  class="starImg" onclick="goToRoomDetail(${newReviewList.get(4).getRoomNum()})">
     			<c:forEach begin="1" end="${newReviewList.get(4).getStarct()}">
     				<img src="<c:url value="/resources/util/star.png"/>">
     			</c:forEach>
     		</td>
     		<td rowspan="5" onclick="goToRoomDetail(${newReviewList.get(5).getRoomNum()})"><img class="rvwroomImg" src="<c:url value="/resources/rooms/${newReviewList.get(5).getFname1()}"/>"></td>
     		<td  class="starImg" onclick="goToRoomDetail(${newReviewList.get(5).getRoomNum()})">
				<c:forEach begin="1" end="${newReviewList.get(5).getStarct()}">
     				<img src="<c:url value="/resources/util/star.png"/>">
     			</c:forEach>
			</td>     		
     	</tr>
     	
     	<tr>
     		<td onclick="goToRoomDetail(${newReviewList.get(4).getRoomNum()})" style="color:tan">${newReviewList.get(4).getRoomlocate()}</td>
     		<td onclick="goToRoomDetail(${newReviewList.get(5).getRoomNum()})" style="color:tan">${newReviewList.get(5).getRoomlocate()}</td>
     	</tr>
     	<tr>
     		<td onclick="goToRoomDetail(${newReviewList.get(4).getRoomNum()})" style="color:tan">${newReviewList.get(4).getRoomname()}</td>
     		<td onclick="goToRoomDetail(${newReviewList.get(5).getRoomNum()})" style="color:tan">${newReviewList.get(5).getRoomname()}</td>
     	</tr>
     	<tr>
     		<td onclick="goToRoomDetail(${newReviewList.get(4).getRoomNum()})">${newReviewList.get(4).getName()}님 ${newReviewList.get(4).getWritedate()}</td>
     		<td onclick="goToRoomDetail(${newReviewList.get(5).getRoomNum()})">${newReviewList.get(5).getName()}님 ${newReviewList.get(5).getWritedate()}</td>
     	</tr>
     	<tr>
     		<td onclick="goToRoomDetail(${newReviewList.get(4).getRoomNum()})">${newReviewList.get(4).getReviewcontent()}</td>
     		<td onclick="goToRoomDetail(${newReviewList.get(5).getRoomNum()})">${newReviewList.get(5).getReviewcontent()}</td>
     	</tr>
     	
     </table>   	
      </div>
   </section>

  	<!-- footer -->
	<footer>
		<%@ include file="../public/footer.jsp" %>
	</footer>
	
</body>
</html>