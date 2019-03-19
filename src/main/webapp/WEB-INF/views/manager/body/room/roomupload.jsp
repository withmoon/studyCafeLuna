<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/manager/js/roomupload.js"/>"></script>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/roomupload.css"/>" />
<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav">
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<a href="manager.do"><img class="logo"
					src="<c:url value="/resources/public/logo/mainlogo.png"/>" /></a>
			</div>
			<jsp:include page="/WEB-INF/views/manager/form/TopMenu1.jsp"></jsp:include>
		</div>
		<%-- <div id="TopMenu2">
					<jsp:include page="form/TopMenu2.jsp" />
				</div> --%>
	</nav>

	<!-- 배경 -->
	<div id="border">
		<!-- 왼측1 사이드 -->
		<div id="left1div">
			
			<aside id="left1">
				<jsp:include page="/WEB-INF/views/manager/form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>방 생성</header>
			</div>
			<form name="form" id="form" method="post" enctype="multipart/form-data" action="mRoomInsert.do">
				<div id="roominsert">
					<!-- 이미지 / 방소개영역 -->
					<div id="image">
						<div>
							<img id="img" /> <br />이미지 영역
						</div>
						<div>
							<input id="input_img" type="file" name="input_img">
						</div>
					</div>
					<div id="room1">
						룸번호 : <input type="text" name="roomnum" value="${map.roomcount }" readonly><br/>
						지점명 : <input type="text" name="branchName" value="${branchName}" readonly><br/>
						방이름 : <input type="text" name="roomName"><br/>
						<!-- 등록일 : <input type="text" name="day1"><br/> --> 
						 가 &nbsp;&nbsp;격 : <input type="text" name="Price"><br/>
				      	 주 &nbsp;&nbsp;소 : <input type="text" name="roomLocate" value="${map.roomLocate} ${branchName}" readonly>
					</div>


					<div id="room2">
						<p>방소개글	<p>
							소 개1 : <input type="text" name="roomEx1"><br />
							소 개2 : <input type="text" name="roomEx2"><br /> 
							소 개3 : <input 	type="text" name="roomEx3"><br /> 
							소 개4 : <input 	type="text" name="roomEx4"><br />
					</div>
				</div>

				<div id="form2">
					<div id="file">
						<ul id="fileul">
							<li>방 이미지1 : <input type="file" name="input_img" id="input_img2"><br/>
								<div><img id="img2" name="input_img1"></div>
							</li>
							<li>방 이미지2 : <input type="file" name="input_img" id="input_img3"><br/>
								<div><img id="img3" name="input_img2"></div>
							</li>
							<li>방 이미지3 : <input type="file" name="input_img" id="input_img4"><br/>
								<div><img id="img4" name="input_img3"></div>
							</li>
							<li>방 이미지4 : <input type="file" name="input_img" id="input_img5"><br/>
								<div><img id="img5" name="input_img4"></div>
							</li>
						</ul>
					</div>

					<div id="roomtext">
					<div id="tarea1">
						<p>방소개<p>
							<textarea rows="10" cols="60" name="roomExplain" ></textarea>
					</div>
					<div id="tarea2">
						<p>주의 사항<p>
							<textarea rows="10" cols="60" name="roomWarn" ></textarea>
					</div>
					</div>
				</div>
				<div id="buttons">
					<input type="button" value="취소" class="button">
					<input type="reset"	value="초기화" class="button"> 
					<input type="button" value="등록" class="button" onclick="check()">
					<input type="hidden" value="${comeRoute}" name="comeRoute">
				</div>
			</form>
		</section>
		<jsp:include page="../../form/rigfht-side.jsp"></jsp:include>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>