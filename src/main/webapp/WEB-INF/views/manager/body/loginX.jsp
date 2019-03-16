<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<style type="text/css">
#table{
	margin: auto auto;
	margin-top: 20%;
}
tr{
	border: 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<table id="table">
		<tr>
			<th>${session}님! Manager 권한이 없습니다</th>
		</tr>
		<tr>
			<td>Manager 권한을 가진 ID로 <a href="login.do">로그인</a> 을 해주세요</td>
		</tr>
	</table>

</body>
</html>