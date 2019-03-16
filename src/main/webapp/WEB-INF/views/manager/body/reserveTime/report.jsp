<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script> 
<script type="text/javascript" src="<c:url value="/resources/manager/js/board.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/manager/js/reportreply.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/manager/js/manager2.js"/>"></script>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/board.css"/>"></link>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/report.css"/>"></link>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<script type="text/javascript"> 
	function list(page) {
		location.href = "mgBoard.mdo?curPage="+page+"&searchOption=${map.searchOption}"+"&keywrod=${map.keyword}";
	}

	function mail_0(num,email) {
	   	alert("클릭");
	   	var url = "mailForm.mdo?num="+num+"&email="+email;
		window.open(url,"mailForm.mdo","width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	} 
	
	function mail_1(num,emailtitle,emailcontent,email) {
	   	alert("클릭");
	   	var url = "mailView.mdo?num="+num+"&emailtitle="+emailtitle+"&emailcontent="+emailcontent+"&email="+email;
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
				<a href="manager.mdo"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
			</div>
			<jsp:include page="../../form/TopMenu1.jsp"></jsp:include>
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
				<jsp:include page="../../form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>보고 게시판</header>
			</div>


			<div id="board">
				<form name="form1" method="post" action="mgBoard.mdo?">
					<table id="searchtable">
						<tr>
							<td id="searchtd"><!-- <a id="write" onclick=" insertboard()" href="#">글쓰기</a> -->
								<!-- 레코드의 갯수를 출력 -->
								<div id="write"></div>
								<select name="searchOption" id="searchOption">
									<option value="title">제목</option>
									<option value="content">내용</option>
								</select> 
							<input name="text" id="keyword"/> 
							<input id="submit" type="button" value="검색" onclick="searchReport()">
							</td>
						</tr>
					</table>
				</form>
				<button style="margin:1%; padding:3px" onclick="writeReport()">보고 올리기</button> <button style="margin:1%; padding:3px" id="delReportBtn" onclick="deleteReport()"> 삭제 </button>
				<br/>
				
				
				<table id="boardtable">
				<thead>
					<tr id="th1">
						<th>번호</th>
						<th class="th">제목</th>
						<th class="th">작성일</th>
						<th class="th">답장여부</th>		
						<th class="th">비고</th>	
					</tr>
					</thead>
					<tbody>
					</tbody>
					<tfoot>
					<tr style="border:0">
						<td  colspan="5" align="center"><ul id="pnum"></ul></td><!-- 나중에 css에서 커서 처리 --> 
					</tr>
					</tfoot>
				</table>
				</div>
			<!-- 보고쓰기 -->
			<div class="board" hidden="true">
			<form id="ajaxform" action="insertReport.do" onsubmit="changeContent()" method="post" enctype="multipart/form-data">
				<table style="background-color:lightgray; border-collapse:collapse">
				<tr>
				<td  colspan="2"  id="reportTt">제목</td>
				<td><input id="title" name="title" type="text" size="88"/></td><td><input type="hidden" id="seqs" name="seqs"/></td>
				</tr>
				<tr>
				<td  colspan="2">첨부파일</td><!-- <a href="path_to_file" download="proposed_file_name">Download</a>  파일 첨부--> 
				<td  id="ftd"><input type="file"  name="ffname"  id="ffname"/></td>
				</tr>
				<tr>
				<td align="center" colspan="3">내용</td>
				</tr>
				<tr>
				<td  colspan="3" id="ctts"><textarea cols="97" id="ctt" rows="20"></textarea><input type="hidden" id="content" name="content" value=""/></td>
				</tr>
				<tr>
				<td  colspan="3" align="center" class="sendReportBtn"><input id="subtn" style="margin:1%; padding:3px" type="submit" value="올리기"/> <input type="button" id="delReportBtn" hidden="true" style="margin:1%; padding:3px" value="삭제"> <input id="cancleReportBtn" hidden="true" type="button" style="margin:1%; padding:3px" onclick="nosend()" value="취소"></td>
				</tr>
			</table>
			</form>
		</div>
		<button hidden="true" id="showlistBtn" style="margin:1%; padding:3px; float:right" onclick="getReportlist(1)">목록 보기</button><br/><br/>
		<!-- 댓글 -->
		<div class="reply" hidden="true">
			<table style="background-color:beige; border-collapse:collapse">
				<tr><th colspan="2">댓글 올리기</th></tr>
				<tr><td><textarea id="replytx" cols="92" rows="5" ></textarea></td><td><button id="repleBtn" style="height:80px" onclick="insertReportReply()">올리기</button></td></tr>
			</table>
			<table style="background-color:beige; border-collapse:collapse" id="replylist">
				<thead><tr><th>댓글</th></tr></thead>
					<tbody>
				</tbody>
			</table>
		</div>
		
		</section>
		</div>

	<footer>
		<jsp:include page="../../form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>