<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/manager/js/roomupdate.js"/>"></script>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/roomupload.css"/>" />
<script type="text/javascript">

/*f unction deleteroom(roomnum) {
	location.href="deleteRoom.mdo?roomnum="+roomnum;
}  */

 $(document).ready(function () {
	$("#room").click(function() {
		alert("버튼클릭");
		location.href="mgRoom.mdo"
	});
	$("#delete").click(function() {
		alert("삭제");
		location.href="deleteRoom.mdo?roomnum="+${text.roomnum};
	});
});  
 </script>
<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav">
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<a href="manager.mdo"><img class="logo"
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
			<form name="form" id="form" method="post" 	enctype="multipart/form-data" action="updateRoom.mdo?roomnum=${text.roomnum}">
				<div id="roominsert">
					<!-- 이미지 / 방소개영역 -->
					<div id="image">
						<div>
							<img id="img"  src= "<c:url value='/resources/rooms/${file.get(0).getFname()}'/>"/><br />이미지 영역
						</div><%--"C:\myProject\mySpring\main.zip_expanded\Luna\src\main\webapp\resources\manager\file\5f92e21c-33f8-43f1-9a78-186625e8c35e.jpg"  --%>
						<div>
							<input id="input_img" type="file" name="input_img">
						</div>
					</div>
					<div id="room1">
						룸번호 : <input type="text" name="text1"  value="${text.roomnum}"><br/>
						지점명 : <input type="text" name="text2" value="${text.branchName}"><br/>
						방이름 : <input type="text" name="roomName" value="${text.roomName }"><br/>
						<%-- 등록일 : <input type="text" name="text3" value="<fmt:formatDate value='${text.day1}'/>"><br/> --%>
						가 &nbsp;&nbsp;격 :<input type="text" name="roomPrice" value="${text.roomPrice}"><br/>
				     	   주 &nbsp;&nbsp;소 : <input type="text" name="roomLocate" value="${text.roomLocate}">
					</div>


					<div id="room2">
						<p>방소개글	<p>
							소 개1 : <input type="text" name="text6" value="${text.roomEx1}"><br />
							소 개2 : <input type="text" name="text7" value="${text.roomEx2}"><br /> 
							소 개3 : <input 	type="text" name="text8" value="${text.roomEx3}"><br /> 
							소 개4 : <input 	type="text" name="text9" value="${text.roomEx4}"><br />
					</div>
				</div>

				<div id="form2">
					<div id="file">
						<ul id="fileul">
							<li>방 이미지1 : <input type="file" name="input_img" id="input_img2" ><br/>
								<div><img id="img2"   src="<c:url value='/resources/rooms/${file.get(1).getFname()}'/>"/></div>
							</li>
							<li>방 이미지2 : <input type="file" name="input_img" id="input_img3"><br/>
								<div><img id="img3" src="<c:url value='/resources/rooms/${file.get(2).getFname()}'/>"/></div>
							</li>
							<li>방 이미지3 : <input type="file" name="input_img" id="input_img4"><br/>
								<div><img id="img4" src="<c:url value='/resources/rooms/${file.get(3).getFname()}'/>"/> </div>
							</li>
							<li>방 이미지4 : <input type="file" name="input_img" id="input_img5"><br/>
								<div><img id="img5"  src="<c:url value='/resources/rooms/${file.get(4).getFname()}'/>"/></div>
							</li>
						</ul>
					</div>

					<div id="roomtext">
					<div id="tarea1">
						<p>방소개<p> 
							<textarea rows="10" cols="60" name="area1" >${text.roomExplain}</textarea>
					</div>
					<div id="tarea2">
						<p>주의 사항<p>
							<textarea rows="10" cols="60" name="area2"  >${text.roomWarn}</textarea>
					</div>
					</div>
				</div>
				<div id="buttons">
					<input type="button" value="목록" class="button" id="room">
					<input type="button" value="삭제" class="button" id="delete">
					<input type="submit" value="수정" class="button">
				</div>
			</form>


		</section>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>