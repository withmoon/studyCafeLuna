<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<style type="text/css">
#writer {
	margin-right: 20%;
}

table, th, td {
	border: 1px solid black;
	border-spacing: 0px;
	border-collapse: collapse;
}

#cssdiv {
	margin-left: 5%;
	margin-top: 5%;
}

#tablecss {
	width: 90%;
}

#tablecss tr {
	height: 35px;
}

#areacss {
	resize: none;
	width: 100%;
	height: 100%;
	margin-bottom: 0%;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnList").click(function() {
			location.href = "mgBoard.do"
			//curPage=${curPage}&searchOption=${searchOption}&{keyword}=${keyword}
		});
	});
	//URLEncoder. encodeURIComponent
	
	function list(page) {
		location.href = "mgBoard.do?curPage="+page+"&searchOption=${map.searchOption}"+"&keywrod=${map.keyword}";
	}

	function mail_0(seq,email) {
	   	alert("클릭");
	   	var url = "mailForm.do?seq="+seq+"&email="+email;
		window.open(url,"mailForm.do","width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	} 
	
	function mail_1(seq,emailtitle,emailcontent,email) {
	   	alert("클릭");
	   	var url = "mailView.do?seq="+seq+"&emailtitle="+emailtitle+"&emailcontent="+emailcontent+"&email="+email;
		window.open(url,"mailForm.do","width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	}
</script>
<title>지점장 관리화면</title>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
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
				<header>문의 게시판</header>
			</div>
			<div id="cssdiv">
				<h2>글 상세보기</h2>
				<form name="form1" method="post">
					<table id="tablecss">
						<tr>
							<td>제목</td>
							<td><input type="text" value="${view.title}" /></td>
						</tr>
						<tr>
							<!-- 값얻어와서 로그인한 아이디로 작성 변경불가능하게 -->
							<td>작성자</td>
							<td><input id="writer" type="text" value="${view.id}" />
								<!-- 등록일date얻어와서 작성 --> <%-- 등록일<input type="text"   value="${view.regdate}"/> --%>
								등록일<input type="text"
								value="<fmt:formatDate value='${view.regdate}' pattern='yyyy.MM.dd'/>" /></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea id="areacss" rows="15" cols="60">${view.content}</textarea></td>
						</tr>
					</table>
					<input type="hidden" name="seq" value="${view.seq }">
					<%-- 본인이 쓴거에 한정시키는 조건문 
				<c:if test=" ${sessionScope.userId==dto.writer}">
				<button type="button" id="btnUpdate">수정</button>
				<button type="button" id="btnDelete">삭제</button>
			</c:if> --%>
					<button type="button" id="btnList">목록</button>
					<c:if test="${view.mail==0 }">
						<td><button onclick="mail_0('${view.seq}','${view.email}');">답장하기</button></td>
					</c:if>
					<c:if test="${view.mail==1}">
						<td><a href="#" onclick="mail_1('${view.seq }','${view.emailtitle }','${view.emailcontent }','${view.email }')">답장확인</a></td>
					</c:if>
				</form>
			</div>
		</section>
		<jsp:include page="../../form/rigfht-side.jsp"></jsp:include>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>