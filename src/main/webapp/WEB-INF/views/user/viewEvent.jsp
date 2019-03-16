<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세보기</title>
<link href="<c:url value="/resources/user/viewEvent/css/viewEvent.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/user/viewEvent/js/viewEvent.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">

<section>
<div class="border">
<!-- 제목/날짜 -->
<div class="title">
<p><b>${ebv.title } </b>
<span class="writer">${ebv.writer }</span>
<span class="date">
	<fmt:formatDate value="${ebv.startdate }" pattern="yy-MM-dd" /> ~ <fmt:formatDate value="${ebv.enddate }" pattern="yy-MM-dd" />
</span></p>
</div>
<!-- 내용 -->
<div class="content">
	${ebv.content } <p>
	<img src="<c:url value="/resources/eventimg/${ebv.seq }/${ebv.files}"/>">
</div>
<!-- 댓글 -->
<div class="reply">
	<b class="replyOnOff" onclick="replyOnOff(${ebv.seq})">댓글 보기/닫기</b><img src="<c:url value="/resources/user/viewNotice/images/reply.png"/>">
	<div class="reply2">
	<!-- 댓글 목록 -->
	<div class="replyList"></div>
	<ul id="replyPaging"></ul>
	<!-- 현재날짜 -->
	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />  
	<fmt:formatDate value="${ebv.enddate}" pattern="yyyy-MM-dd" var="write_dt"/>
	<!-- 댓글 올리기 -->
	<c:if test="${member.id != null }">
	<c:if test="${ write_dt > today }">
	<div class="replytextForm">
		<input type="hidden" id="seq" value="${ebv.seq }">
		<textarea id="replytext" name="replytext" rows="3" cols="65" placeholder="댓글을 작성해주세요"></textarea>
    	<button onclick='writeCommand(${ebv.seq})'>올리기</button>
    </div>
	</c:if>
  	</c:if> 
    <c:if test="${member.id == null }">
    <div class="replytextForm">
    	<b>로그인후 입력이 가능합니다.</b>
    </div>
    </c:if>
    </div>
</div>
<div class="button"><button onclick="windowClose()">닫기</button></div>
</div>
</section>
</body>
</html>