<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/admin/gongjiview/css/gongjiview.css"/>"></link>
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/admin/gongjiview/js/gongjiview.js"/>"></script>
<%-- <script src="<c:url value="/resources/util/js/paging.js"/>"></script> --%>
</head>
<body>
<%@include file="../admin/footer.jsp" %><br><br><br>

<div class="container">
<h4>글상세</h4>
<div class="nview">
<table class="table table-bordered">
<tbody>
	<tr>
		<th>제목:</th>
		<td id="tt">${num.title} <input type="hidden" id="es" name="seq" value="${num.num}" /></td>
	</tr>
	<tr>
		<th>날짜</th>
		<td><fmt:formatDate value="${num.regdate }" pattern="yy-MM-dd" /></td>
	</tr>
	<tr>
		<th>내용:</th>
		<td>${num.content }</td>
	</tr>
	<tr class="button"><td colspan="2">
		<input type="button" onclick="window.open('gongji.do','_self');" value="목록"/>
		<input type="button" onclick="upbt()" value="수정"/> 
		<input type="button" value="삭제" onclick="javascript:location.href='gongjidelete.do?num=${num.num}'" />
	</td></tr>
</tbody>
</table>
<!-- 댓글 -->
<div class="reply">
	<b class="replyOnOff" onclick="replyOnOff(${num.num})">댓글 보기/닫기</b><img src="<c:url value="/resources/user/viewNotice/images/reply.png"/>">
	<div class="reply2">
	<!-- 댓글 목록 -->
	<div class="replyList"></div>
	<ul id="replyPaging"></ul>
</div>
</div>
<form name="form2" action="gongjiupdate.do" method="POST">
<div class="nupdate">
<table class="table table-bordered">
<tbody>
<tr>
	<th>제목:</th>
	<td><input type="text" name="title" placeholder="title"
		id="title" value="${num.title}" class="form-control" /> <input
		type="hidden" name="num" value="${num.num}" /></td>
</tr>
<tr>
	<th>내용:</th>
	<td><textarea cols="5" placeholder="content " id="content"
	name="content" class="form-control" rows="20">${num.content}</textarea></td>
</tr>
<tr class="button"><td colspan="2">
		<input type="button" onclick="window.open('gongji.do','_self');" value="목록"/>
		<input type="submit" id="update" value="수정"/>
		<input type="button" value="삭제"
		onclick="javascript:location.href='gongjidelete.do?num=${num.num}'" />
</td></tr>
</tbody>
</table>
</div>
</form>
</div>
</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>

</body>
</html>