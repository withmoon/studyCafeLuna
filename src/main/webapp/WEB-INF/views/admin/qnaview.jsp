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
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
<link rel="stylesheet" href="<c:url value="/resources/admin/qnaview/css/qnaview.css"/>"> <!-- 메뉴 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/admin/qnaview/js/qnaview.js"/>"></script>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
<%@include file="../admin/footer.jsp" %><br><br><br>

<div class="container">
<div class="qview">
<h4>글상세</h4>
<table class="table table-bordered">
<tbody>
	<tr>
		<th>제목</th>
		<td id="tt">${qbv.subject} <input type="hidden" id="es" name="num" value="${qbv.num}" /></td>
	</tr>
	<tr>
		<th>날짜</th>
		<td><fmt:formatDate value="${qbv.regdate }" pattern="yy-MM-dd" /></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${qbv.content}</td>
	</tr>
	<tr class="button"><td colspan="2">
		<input type="button" onclick="window.open('board.do','_self');" value="글 목록"/>
		<input type="button" onclick="upbt()" value="수정"/> 
		<%-- <input type="button" value="삭제" onclick="javascript:location.href='deleteevent.do?seq=${ebv.seq}'" /> --%>
		<input type="button" onclick="btdel(${qbv.num})" value="삭제"/>
	</td></tr>
</tbody>
</table>
</div> <!-- end qview -->

<form name="form2" action="qnaupdate.do" method="POST">
<div class="qupdate">
<table class="table table-bordered">
<tbody>
	<tr>
		<th>제목:</th>
		<td><input type="text" name="subject" placeholder="subject" id="subject" value="${qbv.subject}" class="form-control" /><input type="hidden" name="num" value="${qbv.num}" /></td>
	</tr>
	<tr>
		<th>날짜</th>
		<td><input type="date"  placeholder="startdate" name="startdate" value="${qbv.regdate }"/></td>
	</tr>
    <tr>
		<th>내용:</th>
		<td><textarea cols="5" placeholder="content " id="content" name="content" class="form-control" rows="20">${qbv.content}</textarea></td>
    </tr>
    <tr class="button"><td colspan="2">
		<input type="submit" id="btnSave" value="수정"/>&emsp;
		<input type="button" onclick="btdel(${qbv.num })" value="삭제"/>&emsp;
		<input type="button" onclick="window.open('board.do','_self');" value="취소"/>
	</td></tr>
</tbody>
</table>
</div>  <!-- end qupdate -->
</form>
   </div>


   
 
</body>
</html>