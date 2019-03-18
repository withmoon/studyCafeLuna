<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link href="<c:url value="/resources/admin/approve/css/approve.css"/>" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/admin/approve/js/approve.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<title>승인페이지</title>
</head>



	<%@include file="../admin/footer.jsp" %>
	<div align="center">
      <h3>지점장 승인</h3>
   </div>
	<br></br>
	<div class="container">
		<div class="row">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th>지점명</th>
							<th>주소</th>
							<th>기타</th>
						</tr>
					</thead>
					<tbody id="approve_table"></tbody>
				</table>
				<ul id="approvePaging"></ul>
   				 <a href="gongjiwrite.do" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>




<div hidden="true" class="explur">
<form id="appform" name="appform" action="sendemail.do" method="POST" enctype="multipart/form-data">
<table>
	<thead>
		<tr>
			<th>메일 보내기</th>
		</tr>
	</thead>
	
	<tr class="emailcontents" hidden="true">
	<td>
		<input id="extitle" name="title" type="text" size="80" placeholder="제목을 입력해주세요"/>
		<input hidden="true" name="jspname" id="jspname" value=""/><input hidden="true" id="ems" name="email" value=""/>
		<input hidden="true" id="type" name="type" value=""/><input hidden="true" id="id" name="id" value=""/>
	</td>
	</tr>
	<tr class="emailcontents" hidden="true">
	<td>
		<input id="filename" name="filename" type="file"/>
	</td>
	</tr>
	<tr>
	<td>
		<textarea id="excontent" name="content" cols="80" rows="5" placeholder="사유를 입력해주세요."></textarea>
	</td>
	</tr>
	<tr align="center" style="background-color:#eeeeee;">
	<td>
		<input type="submit" id="sendToUser" value="보내기"/>&emsp;<input type="button" onclick="cancleExplur()" value="취소">
	</td>
	</tr>
</table>
</form>

</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
	

</body>
</html>