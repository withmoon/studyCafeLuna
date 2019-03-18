<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link href="<c:url value="/resources/admin/member/css/member.css"/>" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/admin/member/js/member.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
</head>
<c:if test="${success eq 'success' }">
<script>
	alert("메일이 성공적으로 발송되었습니다.");
</script>
</c:if>

<%@include file="../admin/footer.jsp" %>
 <div align="center"><h3>회원관리게시판</h3></div>
    <table>
      <tr>
         <td><select id="searchOption" name="searchOption">
               <option value="all">전체</option>
               <option value="id">ID</option>
               <option value="name">이름</option>
               <option value="phone">전화번호</option>
               <option value="email">이메일</option>
         </select></td>

         <td><input name="keyword" id="keyword" value=""
            autocomplete="off"> <input type="button" id="searchButton"
            name="searchButton" class="btn btn-default" onclick="AllmemberList(1)" value="검색" /></td>
         <td width="70"></td>
      </tr>
   </table>
<div class="mail"><b>메일보내기</b>&emsp;<a href="#" onclick="AllMail()">단체메일</a>&emsp;<a href="#" onclick="AllMail('allUser')">회원전체</a>&emsp;<a href="#" onclick="AllMail('allBranch')">지점장전체</a></div><br>
   
<!-- 진행(종료) 이벤트버튼 -->
<section>
<div class="info-container">
	<ul class="infoTap">
		<li class="userinfo">일반회원정보</li>
		<li class="branchinfo">지점장정보</li>
	</ul>
</div>
</section>   

<div class="container">
<b>[선택된 아이디]</b>
<div class="cendmBtn"></div><button class="sendmBtn" onclick="sendEmailToMembers()"> 메일 보내기 </button>
<div class="row">

<!-- 정보 게시판 -->
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd"></table>

<ul id="memberPaging"></ul>
</div>
</div>
<div hidden="true" class="explur">
<form name="memform" id="memform"  action="sendemail.do" method="POST" onsubmit="sendEmail()" enctype="multipart/form-data">
<table>
	<thead>
		<tr>
			<th id="sangdan">제명 사유</th>
		</tr>
	</thead>
	
	<tr class="emailcontents" hidden="true">
	<td>
		<input id="extitle" name="title" type="text" size="80" placeholder="제목을 입력해주세요"/>
		<input hidden="true" name="id" id="ids" value=""/><input hidden="true" id="ems" name="email" value=""/>
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
	<td><input type="hidden" name="type" id="type" value="">
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