<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script> 
<script type="text/javascript" src="<c:url value="/resources/manager/js/manager2.js"/>"></script>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/board.css"/>"></link>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script type="text/javascript">
	function list(page) { 
		location.href = "QuestionBoardList.do?curPage="+page+"&searchOption=${map.searchOption}"+"&keywrod=${map.keyword}";
	}

	function mail_0(seq,email,content) {
	   	var url = "mailForm.mdo?seq="+seq+"&email="+email+"&content="+content;
		window.open(url,"mailForm.mdo","width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	} 
	
	function mail_1(seq,emailtitle,emailcontent,email) {
	   	var url = "mailView.mdo?seq="+seq+"&emailtitle="+encodeURI(emailtitle)+"&emailcontent="+encodeURI(emailcontent)+"&email="+encodeURI(email);
		window.open(url,"mailForm.mdo","width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	}
	
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
				<a href="manager.do"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
			</div>
			<jsp:include page="../../form/TopMenu1.jsp"></jsp:include> 
		</div>
	</nav>

	<!-- 배경 -->
	<div id="border">
		<!-- 왼측1 사이드 -->
		<div id="left1div">
			
			<aside id="left1">
				<jsp:include page="../../form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>문의 게시판</header>
			</div>


			<div id="board">
				<form name="form1" method="post" action="QuestionBoard.do?">
					<table id="searchtable">
						<tr>
							<td id="searchtd"><!-- <a id="write" onclick=" insertboard()" href="#">글쓰기</a> -->
								<!-- 레코드의 갯수를 출력 -->
								<div id="write"><b>${map.count}</b>개의 게시물이 있습니다.</div>
								<select name="searchOption">
									<option value="TITLE"  <c:out  value="${map.searchOption == 'title' ? 'selected' : '' }" />>제목</option>
									<option value="id"  <c:out value="${map.searchOption == 'id'?'selected' : '' }"/> >작성자</option>
							</select> 
							<input name="keyword"  value="${map.keyword }"> 
							<input id="submit"	type="submit" value="검색">
							</td>
						</tr>
					</table>
				</form>
	
				<br/>
				
				<table id="boardtable">
					<tr id="th1">
						<th>번호</th>
						<th class="th">제목</th>
						<th class="th">작성자</th>
						<th class="th">작성일</th>
						<th class="th">답장여부</th>
						
					</tr>
					<!-- db에서 읽어들어와야하는 부분 -->
					<!-- 예시로 데이터 작업 -->
					<c:forEach var="list" items="${map.list }">
						<tr>
							<td>${list.rownum }</td>
							<td>${list.title}</td>
							<td>${list.id }</td>
							<td><fmt:formatDate value="${list.regdate}" pattern="yy-MM-dd"/></td>
							<c:if test="${list.mail==0 }">
								<td><button onclick="mail_0('${list.seq}','${list.email}','${list.content}')">열람 하기</button></td>
							</c:if>
							<c:if test="${list.mail==1}">
								<td><a id="mail" href="javascript:mail_1(${list.seq },'${list.emailtitle}','${list.emailcontent}','${list.email}')">답장확인</a></td>
							</c:if>
							
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
		<jsp:include page="../../form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>