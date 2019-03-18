<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세보기</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/admin/eventview/css/eventview.css"/>"></link>
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/admin/eventview/js/eventview.js"/>"></script>
<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
<%@include file="../admin/footer.jsp" %><br><br><br>

<div class="container">
<div class="eview">
<table class="table table-bordered">
<tbody>
	<tr>
		<th>제목:</th>
		<td id="tt">${ebv.title } <input type="hidden" id="es" name="seq" value="${ebv.seq}" /></td>
	</tr>
	<tr>
		<th>날짜</th>
		<td><fmt:formatDate value="${ebv.startdate }" pattern="yy-MM-dd" /> ~ <fmt:formatDate value="${ebv.enddate }" pattern="yy-MM-dd" /></td>
	</tr>
	<tr>
		<th>내용:</th>
		<td>
			${ebv.content } <p>
			<img src="<c:url value="/resources/eventimg/${ebv.seq }/${ebv.files}"/>">
		</td>
	</tr>
	<tr class="button"><td colspan="2">
		<input type="button" onclick="window.open('event.do','_self');" value="글 목록"/>
		<input type="button" onclick="upbt()" value="수정"/> 
		<%-- <input type="button" value="삭제" onclick="javascript:location.href='deleteevent.do?seq=${ebv.seq}'" /> --%>
		<input type="button" onclick="btdel(${ebv.seq})" value="삭제"/>
	</td></tr>
</tbody>
</table>
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
    </div>
</div>
</div>
<form id="ajaxform" action="updateevent.do" onsubmit="changeContent()" method="POST" enctype="multipart/form-data">
<div class="eupdate">
<table class="table table-bordered">
<tbody>
	<tr>
	<th>제목:</th>
		<td><input type="text" id="tup"  placeholder="title" name="title" value="${ebv.title }" /><input type="hidden" name="seq" value="${ebv.seq}" /></td>
	</tr>
	<%-- <tr>
		<th>날짜</th>
		<td><fmt:formatDate value="${ebv.startdate }" pattern="yy-MM-dd" /> ~ <fmt:formatDate value="${ebv.enddate }" pattern="yy-MM-dd" /></td>
	</tr> --%>
	<tr>
		<th>내용:</th>
		<td><textarea cols="10" rows="16" id="ctt" placeholder="content " name="content">${ebv.content}</textarea>
	</tr>
	<tr>
	<th>이벤트시작일:</th>
	<td><input type="date"  placeholder="startdate" name="startdate" value="${ebv.startdate }"/></td>
	</tr>
	<tr>
	<th>이벤트종료일:</th>
	<td><input type="date"  placeholder="enddate" name="enddate" value="${ebv.enddate }"/></td>
	</tr>
	<tr>
		<th>이미지업로드:</th>
    	<td id="ftd">
    		<img id="img" src="<c:url value="/resources/eventimg/${ebv.seq }/${ebv.files}"/>">
    		<input type="button" id="imgSave" value="수정"/>
    		<input type="file" name="mfname" id="image"/><br>
    		<input type="button" id="imgDel" value="수정취소"/>
    	</td>
	</tr>
	<tr class="button"><td colspan="2">
		<input type="submit" id="btnSave" value="수정"/>&emsp;
		<input type="button" onclick="deRE(${ebv.seq })" value="삭제"/>&emsp;
		<input type="button" onclick="window.open('event.do','_self');" value="취소"/>
	</td></tr>
</tbody>
</table>
</div>
</form>
</div>
</body>
</html> 