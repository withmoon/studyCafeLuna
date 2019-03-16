<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/admin/eventwrite/css/eventwrite.css"/>"></link>
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/admin/eventwrite/js/eventwrite.js"/>"></script>
<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
<%@include file="../admin/footer.jsp" %><br><br><br>


<form id="ajaxform" action="eventinsert.ado" onsubmit="return changeContent()" method="post" enctype="multipart/form-data">
<div class="container">
<table class="table table-bordered">
<caption>글쓰기</caption>
<tbody>
<tr>
	<th>제목:</th>
	<td><input type="text"  placeholder="title" name="title" /><input type="hidden" id="seq" name="seq" value="0"/></td>
</tr>
<tr>
	<th>내용:</th>
	<td><textarea cols="10" rows="16" id="ctt" placeholder="content " name="content"></textarea>
	<input type="hidden" id="content" name="content" value=""/></td>
</tr>
<tr>
	<th>이벤트시작일:</th>
	<td><input type="date"  placeholder="startdate" name="startdate"/></td>
</tr>
<tr> 
	<th>이벤트종료일:</th>
	<td><input type="date"  placeholder="enddate" name="enddate"/></td>
</tr>
<tr>
	<th>이미지업로드:</th>
    <td id="ftd"> <input type="file" name="mfname" id="image"/></td>
</tr>
<tr class="button"><td colspan="2">
	<input type="submit" id="btnSave" value="등록"/>&emsp;
	<input type="button" onclick="window.open('event.ado','_self');" value="글 목록"/>
</td></tr>
</tbody>
</table>
</div>
</form>
</body>
</html>