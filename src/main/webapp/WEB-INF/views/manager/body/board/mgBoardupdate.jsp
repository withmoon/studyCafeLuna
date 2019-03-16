<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#writer {
	margin-right: 20%;
}

table, th, td {
	border: 1px solid black;
	border-spacing: 0px;
	border-collapse: collapse;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
</head>
<body>
	<h2>글 수정</h2>
	<form>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<!-- 값얻어와서 로그인한 아이디로 작성 변경불가능하게 -->
				<td><input id="writer" type="text" />
				등록일<input type="date" /></td>
				<!-- 등록일date얻어와서 작성 -->
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="15" cols="60"></textarea></td>
			</tr>
		</table>
			<input type="submit" value="등록">
			<input type="reset" value="초기화">
			<input type="button" value="취소">
	</form>
</body>
</html>