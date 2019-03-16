<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/admin/cannotAccess/css/cannotAccess.css"/>">
</head>
<body style="background-color:white;">

<div class="login_div">
<p>"<b>로그인</b>후 이용가능합니다"<br>
해당내용은 로그인 하신 후에 확인가능합니다.<br>
더 많은 내용을 보시려면 로그인 해주세요<br><br>
<a href="<c:url value="/login.do"/>">로그인 하러가기</a></p>
<div class="login"><img src="<c:url value="/resources/admin/cannotAccess/images/login.png"/>"></div>
</div>
<!-- 관리자 권한이 없으십니다.
<a href="login.do">로그인</a>후 사용해주세요 -->
</body>
</html>