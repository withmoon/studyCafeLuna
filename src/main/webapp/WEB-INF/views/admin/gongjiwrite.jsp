<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript">
function check() {
	if(title.value==""){
		alert("제목이 입력되지않았습니다");
		$("#title").focus();
		return false;
	}else if(content.value==""){
		alert("내용이 입력되지않았습니다");
		$("#content").focus();
		return false;
	}
	return true;
}
</script>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
</head>
<%@include file="../admin/footer.jsp" %>
	<br>
	<br>
	<br>

	<div class="container">
		<form id="form1" name="form1" onsubmit="return check()" action="noticeinsert.ado">
			<table class="table table-bordered">
				<h4>글쓰기</h4>
				<tbody>
<!-- 
					<tr>
						<th>작성자:</th>
						<td><input type="text" placeholder="subject" id="writer"
							name="writer" class="form-control" /></td>
					</tr> -->


					<tr>
						<th>제목:</th>
						<td><input type="text" placeholder="subject" id="title"
							name="title" class="form-control" /></td>
					</tr>

					<tr>
						<th>내용:</th>
						<td><textarea cols="10" placeholder="content " id="content"
								name="content" class="form-control"></textarea></td>
					</tr>
					<!-- <tr>
						<th>작성일:</th>
						<td><input type="date" placeholder="date" id="regdate"
							name="regdate" class="form-control" /></td>
					</tr> -->
					<tr>
						<td colspan="2"><input type="submit" id="btnSave" value="등록"
							class="pull-right" /> <input type="button" value="글 목록"
							class="pull-right"
							onclick="javascript:location.href='gongjiboardList.ado'" /></td>
					</tr>

				</tbody>
			</table>
		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
	
</body>
</html>