<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<script type="text/javascript">
function list(page) { 
	location.href = "mRoom.do?curPage="+page+"&searchOption=${map.searchOption}"+"&keywrod=${map.keyword}";
}
</script>	

<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/mgSalesreserve.css"/>"></link>

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
			<div>
			
			<form id="form1" method="post"  action="mRoom.do?">
				<div id="ex">
					<ul>
						<li>
							검색창 : <select name="searchOption">
								<option value="all"  <c:out value="${list.searchOption=='all' ? 'selected' : '' }" />>전체</option>
								<option value="roomName"  <c:out value="${list.searchOption=='roomName' ? 'selected' : '' }" />>방/지점 이름</option>
								<option value="roomnum"  <c:out value="${list.searchOption=='roomnum' ? 'selected' : '' }" />>방 번호</option>
							</select>
						</li>
						<li>검색 : <input type="text" name="keyword">
						</li>
						<li id="exb"><input id="submit" type="button" value="방생성" 	onclick="location.href='mRoomUpload.do'"></li>
						<li id="exb"><input id="submit" type="submit" value="검색"></li>
					</ul>
				</div>
			</form>

				<!-- db데이터 -->
				<table id="t">
					<tr id="ttr1">
						<th>ROOM.NO</th>
						<th>지점명</th>
						<th>방이름</th>
						<th>주소</th>
						<th>가격</th>
					</tr>
					<c:forEach items="${map.list}" var="list">
						<tr>
							<td>${list.roomnum}</td>
							<td><a href="mRoomView.do?roomnum=${list.roomnum}">${list.branchName}</a></td>
							<td>${list.roomName }  </td>
							<td>${list.roomLocate}</td>
							<td>${list.roomPrice}</td>
						</tr>
					</c:forEach>
					<tr>
					 <td colspan="5">
              		  <!-- 처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력-->
             		   <c:if test="${map.boardPager.curBlock > 1}">
               		     <a href="javascript:list('1')">[처음]</a>
                </c:if>
                
			                <!-- 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
			                <c:if test="${map.boardPager.curBlock > 1}">
			                    <a href="javascript:list('${map.boardPager.prevPage}')">[이전]</a>
			                </c:if>
			                
			                <!-- **하나의 블럭 시작페이지부터 끝페이지까지 반복문 실행 -->
			                <c:forEach var="num" begin="${map.boardPager.blockBegin}" end="${map.boardPager.blockEnd}">
			                    <!-- 현재페이지이면 하이퍼링크 제거 -->
			                    <c:choose>
			                        <c:when test="${num == map.boardPager.curPage}">
			                            <span style="color: red">${num}</span>&nbsp;
			                        </c:when>
			                        <c:otherwise>
			                            <a href="javascript:list('${num}')">${num}</a>&nbsp;
			                        </c:otherwise>
			                    </c:choose>
			                </c:forEach>
			                
			                <!-- 다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
			                <c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
			                    <a href="javascript:list('${map.boardPager.nextPage}')">[다음]</a>
			                </c:if>
			                
			                <!-- 끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
			                <c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
			                    <a href="javascript:list('${map.boardPager.totPage}')">[끝]</a>
			                </c:if>
			            </td>
			        </tr>
				</table>
			</div>
		</section>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>