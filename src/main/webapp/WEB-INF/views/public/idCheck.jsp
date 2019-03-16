<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower"rel="stylesheet"><!-- 외부폰트 -->
</head>
<body bgcolor="#836e5b">
<table  style="background-color:white; border:1px solid #836e5b; font-family: 'Gamja Flower', cursive; font-size:8.7vw">
<tr><td align="center" style="border:1px solid #836e5b; ">
'${member.id}' 조회 결과<br/>${message}
</td></tr>
<tr><td align="center"style="border:1px solid #836e5b;">
<button style="background-color:#836e5b; font-family: 'Gamja Flower', cursive;" onclick="javascript:self.close()">${btnMessage}</button>
</td></tr>
</table>
</body>
</html>