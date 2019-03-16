<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
</head>
<%@include file="../admin/footer.jsp" %>
	<br>
	<br>
	<br>
	<div class="container">
		<form id="form1" name="form1" action="${pageContext.request.contextPath}/inquireinsert.ado" method="post">
			<table class="table table-bordered">
				<h4>답변쓰기</h4>
				<tbody>
				<tr>
				<th>이메일:</th>
				 <td><input type="text" name="tomail" size="120" style="width:100%" placeholder="상대의 이메일" class="form-control" value="${seq.email}"/></td>
				</tr>
				<tr>
				<th>제목:</th>
				 <td><input type="text" name="title" size="120" style="width:100%" placeholder="제목" class="form-control"/></td>
				</tr>
					<tr>
					
						<th>답변:</th>
						<td><textarea cols="10" rows="4" placeholder="reply" id="reply"
								name="reply" class="form-control">${seq.reply}</textarea>
					   <input type="hidden" name="seq" value="${seq.seq}" /></td>
					 </tr>
					<tr>
						<td colspan="2"><input type="submit" id="btnSave" value="등록"
							class="btn btn-primary pull-right" /> <input type="button"
							value="글 목록" class="btn btn-primary pull-right"
							onclick="javascript:location.href='inquireList.ado'" /></td>
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