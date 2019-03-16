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
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<script src="<c:url value="/resources/admin/admininfo/js/admininfo.js"/>"></script>
</head>



<%@include file="../admin/footer.jsp" %>
 <div align="center">
      <h3>관리자 정보</h3>
   </div>
   <br></br>
<div class="container">
<b>[선택된 아이디]</b>
<div class="cendmBtn"></div><button class="sendmBtn" onclick="sendEmailToMembers()"> 메일 보내기 </button>

<div class="row">
<button onclick="showAddFom()">관리자 추가</button>
<button onclick="showMyFom()">내 계정 수정</button>
<table id="admintb" class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
<thead>
	<tr>
		<th><input type="checkbox" id="allSeq" onclick="checkAll()"></th>
		<th>아이디</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>날짜</th>
		<th>삭제</th>
	</tr>
</thead>
<tbody>
</tbody>
</table>
<ul id="memberPaging"></ul>
</div>
<div hidden="true" id="addForm" style="position:absolute; top:10%; left:37%; border:1px solid black; padding:2%; width:30%; background-color:#cccccc">
	<table>
		<tr align="center">
			<td  colspan="2"><p>[관리자 추가] <img onclick="hidenAddForm('addForm')" style="width:8%; float:right" src="<c:url value="/resources/admin/xicon.png"/>"/></p>  </td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id" name="id" /><br/><br/></td>
			<td><br/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name" name="name" /><br/><br/></td>
			<td><br/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="pw" name="pw" /><br/><br/></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" id="repw" name="repw" /><br/><br/></td>
		</tr>
		<tr>
			<td>전화 번호</td>
			<td><input type="tel" id="phone" name="phone" /><br/><br/></td>
			<td><br/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" id="email" name="email" /><br/><br/></td><!-- regdate -->
		</tr>
		<tr align="center">
			<td colspan="2"><br/><button onclick="addAdmin()">관리자 추가 완료</button></td>
		</tr>
	</table>
</div>

<div  hidden="true" id="myForm" style="position:absolute; top:10%; left:37%; border:1px solid black; padding:2%; width:30%; background-color:#cccccc">
	<table>
		<tr align="center">
			<td  colspan="2"><p>[내 계정 수정] <img onclick="hidenAddForm('myForm')" style="width:8%; float:right" src="<c:url value="/resources/admin/xicon.png"/>"/></p>  </td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="myid" name="id" /><br/><br/></td>
			<td><br/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="myname" name="name" /><br/><br/></td>
			<td><br/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="mypw" name="pw" /><br/><br/></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" id="myrepw" name="repw" /><br/><br/></td>
		</tr>
		<tr>
			<td>전화 번호</td>
			<td><input type="tel" id="myphone" name="phone" /><br/><br/></td>
			<td><br/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" id="myemail" name="email" /><br/><br/></td><!-- regdate -->
		</tr>
		<tr align="center">
			<td colspan="2"><br/><button onclick="updateMyAdmin()">수정 완료</button><button onclick="noUpdateAdmin()">취소</button></td>
		</tr>
	</table>
</div>


<div hidden="true" id="infoForm" style="position:absolute; top:10%; left:37%; border:1px solid black; padding:2%; width:30%; background-color:#cccccc">
	<table>
		<tr align="center">
			<td  colspan="2"><p>[관리자 정보 수정] <img onclick="hidenAddForm('infoForm')" style="width:8%; float:right" src="<c:url value="/resources/admin/xicon.png"/>"/></p>  </td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="adid" name="id" /><br/><br/></td>
			<td><br/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="adname" name="name" /><br/><br/></td>
			<td><br/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="adpw" name="pw" /><br/><br/></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" id="adrepw" name="repw" /><br/><br/></td>
		</tr>
		<tr>
			<td>전화 번호</td>
			<td><input type="tel" id="adphone" name="phone" /><br/><br/></td>
			<td><br/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" id="ademail" name="email" /><br/><br/></td><!-- regdate -->
		</tr>
		<tr align="center">
			<td colspan="2"><br/><button id="adsujung" onclick="updateAdmin()">수정 완료</button>
			<!-- <button onclick="noUpdateAdmin()">취소</button> --></td>
		</tr>
	</table>
</div>
<div hidden="true" class="explur">
<form name="memform" id="memform"  action="sendemail.ado" method="POST" onsubmit="sendEmail()" enctype="multipart/form-data">
<table>
<thead>
		<tr>
			<th id="sangdan">메일 보내기</th>
		</tr>
	</thead>
	<tr class="emailcontents">
	<td>
		<input id="extitle" name="title" type="text" size="80" placeholder="제목을 입력해주세요"/>
		<input hidden="true" name="id" id="ids" value=""/><input hidden="true" id="ems" name="email" value=""/>
		<input hidden="true" id="type" name="type" value=""/>
	</td>
	</tr>
	<tr class="emailcontents">
	<td>
		<input id="filename" name="filename" type="file"/>
	</td>
	</tr>
	<tr>
	<td>
		<textarea id="excontent" name="content" cols="80" rows="5" placeholder="내용을 입력해주세요."></textarea>
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
</div>

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   </body>
</html>