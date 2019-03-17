<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Pragma" content="no-cache"/>

<meta charset="UTF-8">
<title>MyPage</title>
<link href="<c:url value="/resources/user/mypage/css/mypage.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/resources/user/mypage/js/inputChk.js"/>"></script>
<script src="<c:url value="/resources/user/mypage/js/mypage.js"/>"></script>
<script src="<c:url value="/resources/user/mypage/js/mypajax.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<script src="<c:url value="/resources/user/mypage/js/pageajax.js"/>"></script>
</head>
<body style="overflow-x:hidden">

	
	
	<!-- 상단로고 -->
	<a href="<c:url value="/home.do"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
	<div class="top">MyPage</div>
	
	<!-- 탑-->
	<nav>
		<%@ include file="../public/topmenu.jsp" %>
	</nav>
	
		<!-- 회원정보 -->
		<div class="myinformation">
			<button onclick="userOut()">회원 탈퇴</button><br/>
			<img class="infoline1" src="<c:url value="/resources/user/mypage/images/line.png"/>">
			<img class="deer" onclick="goToQandA()" id="queAlimg" src="<c:url value="/resources/user/mypage/images/que.png"/>" onmouseenter="this.src='<c:url value="/resources/user/mypage/images/queg.gif"/>'" onmouseleave="this.src='<c:url value="/resources/user/mypage/images/que.png"/>'">
			<br/><b>${member.name}님 환영합니다.</b><br/>
			&emsp;전화번호&ensp;${member.phone} <br>
			&emsp;이메일 &ensp;${member.email}
			<button class="update" onclick="showUpdateForm()">정보수정</button>
			
			
			
			<img class="infoline2" src="<c:url value="/resources/user/mypage/images/line.png"/>">
		</div>
		
		<!-- 내가찜한방 keeplist-->
		<div class="favorites1">
		<label>❣ 내가 찜한 방 ❣</label><a href="#" id="display1" onclick="displayBoard(1)">찜리스트 보이기</a>
			<div class="favorlist">
				<div style="display:none" id="nonroom"><!-- 방 없을때만 나옴 -->
					ㅜ찜한방이 아직 없습니다ㅜ
				</div>
			<table id="fvTable"></table>
			<ul id="fvPaging"></ul>
			</div>
		</div>
		
		
		<!-- 예약 현황 보기-->
		<div class="reservation">
			<label class="reservlabel">※ 예약현황 ※</label><a href="#" id="display2" onclick="displayBoard(2)">현황 보이기</a>
			<div class="rslist">
				<!-- 방없을시 -->
				<div class="noroom" hidden="true">
					<img src="<c:url value="/resources/user/mypage/images/noroom.png"/>"><label>예약하신 룸이 없습니다.</label>
				</div>

				<!-- 최근내역중  -->	
				<div id="latelyReservList">
					<b>최근 예약 내역</b><ul id="ltPaging" class="pagcls"></ul>
					<table id="lateTable">
						<thead>
							<tr>
								<th>예약하신 날짜</th>
								<th>지점명</th>
								<th>예약하신 룸 이름</th>
								<th>지점 전화번호</th>
								<th>지점주소</th>
								<th>예약 시간</th>
								<th></th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
				
				<label class="lastSearch"><b>지난 예약 조회</b></label>
				<div class="line2">
					<input type="date" id="stdate">&emsp;~&emsp;<input type="date" id="endate">
					&emsp;<button class="update" onclick="lastSearch()">적용</button>
				</div>
				
				<div id="lastReservList">
				<table id="lastTable">
					<thead>
						<tr>
							<th>날짜</th>
							<th>시간</th>
							<th>지점</th>
							<th>룸</th>
							<th>비고</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<ul id="lastPaging" class="lppagcls"></ul>
				</div>
			</div>
		</div>
		
		<!-- 문의글 -->
		<div class="ntlnon">
		<p class="notification3">✉ 문의글 ✉</p> 
		<table id="notification4" class="notification2">
		</table>
		<ul id="ntpaging" class="pagcls"></ul>
		</div>
	
	<!-- 정보수정 div -->
		<div id="upInfo" class="upInfo">
			<form id="update" name="update" action="" method="post">
			<table>
				<tr><td>
					<label>ID</label><br/>
					<input type="text" name="id" id="id" size="30" value="${member.id}" disabled="disabled">
				</td></tr>
				<tr><td>
					<label>PassWord</label><br/>
					<c:if test="${fn:substring(member.id, 0, 2) ne 'k#'}">
					<input type="password" name="pw" id="pw" size="30" value="${member.pw}">
					</c:if>
					<c:if test="${fn:substring(member.id, 0, 2) eq 'k#'}">
					<input type="password" name="pw" id="pw" size="30" disabled="disabled">
					</c:if>
				</td></tr>
				<tr><td>
					<label>Confirm PassWord</label><br/>
					<c:if test="${fn:substring(member.id, 0, 2) ne 'k#'}">
					<input type="password" name="repw" id="repw" size="30">
					</c:if>
					<c:if test="${fn:substring(member.id, 0, 2) eq 'k#'}">
					<input type="password" name="repw" id="repw" size="30" disabled="disabled">
					</c:if>		
				</td></tr>
				<tr><td>
					<label>Name</label><br/>
					<input type="text" name="name" id="name" size="30" value="${member.name}" required="required">
				</td></tr>
				<tr><td>
					<label>Tel [ / '-' 포함 입력 ]</label><br/>
					<input type="text" name="phone" id="phone" size="30" value="${member.phone}" required="required">	
				</td></tr>
				<tr><td>
					<label>birthday [ / 6자리 입력 ex)820215 ]</label><br/>
					<input type="text" name="birth" id="birth" size="30" value="${member.birth}" required="required" disabled="disabled">			
				</td></tr>
				<tr><td>
					<label>Email</label><br/>
					<input type="email" name="email" id="email" size="30" value="${member.email}" required="required">
				</td></tr>
				<tr><td align="center"><br/>
					<button onclick="inputCheck()">수정 완료</button>&emsp;&emsp;<input type="button" onclick="hideUpdateForm()" value="취소">
				</td></tr>
			</table>
		</form>
		</div>
		
		<!-- 리뷰 받는 div -->
		<div class="review">
			<img id="star1" class="star" onclick="star1Click()" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star2" class="star" onclick="star2Click()" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star3" class="star" onclick="star3Click()" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star4" class="star" onclick="star4Click()" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star5" class="star" onclick="star5Click()" src="<c:url value="/resources/util/unstar.png"/>"/><label>별점 :<b id="starcount">0</b>점</label>
			<img onclick="closeReview()" src="<c:url value="/resources/util/xicon.png"/>"/><br/><br/>
			<input type="text" id="rvwText" size="90" placeholder="최대 90자">&nbsp;<button onclick="writeReview()">후기 올리기</button>
		</div>
		
		<!-- 환불요청 div -->
		<div class="ccReserDiv">
			정말로 환불하시겠습니까?<br/><br/>
			<button onclick="goCancle()">예</button> <button onclick="noCancle()">아니요</button>
		</div>
		
		<!-- 알림 else 내용  -->
		<div id="showElse" class="showElse">
			<table>
				<tr>
					<td>제목</td>
					<td><input id="elsett" type="text" size="30" disabled="disabled"/></td>
				</tr>
				<tr align="center">
					<td colspan="2">내용</td>
				</tr>
				<tr>
				<td colspan="2"><textarea id="elsect" cols="43" rows="14" disabled="disabled"></textarea></td>
				</tr>
				<tr align="center">
					<td id="elsebtn" colspan="2"><button onclick="closeElse()">닫기</button></td>
				</tr>
			</table>
		</div>
	
	<!-- footer -->
	<footer>
		<%@ include file="../public/footer.jsp" %>
	</footer>
</body>
</html>