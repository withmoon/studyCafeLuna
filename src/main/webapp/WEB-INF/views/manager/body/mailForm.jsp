<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src='<c:url value="/jquery/jquery-1.11.3.min.js" />'></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript">
function mail() {
	alert("메일 전송 중입니다.");
	var form = document.getElementById('form1');
	form.submit();
	window.setTimeout("cle()",5000);
	 
}
function cle() {
	alert("전송완료했습니다.");
	opener.parent.location="/luna/mgBoard.mdo";
	window.close();
}

/* sangdan
$('#form1').submit();

opener.parent.location="/luna/mgBoard.mdo";
window.close(); */
</script>
<!-- document.getElementById('form1').submit(); -->
<title>메일 보내기</title>
</head>
<body>
	<div class="container">
		<h4>메일 보내기</h4>
		<form id="form1" action="${pageContext.request.contextPath}/mailSending.mdo" method="post">
			<div align="center">
				<!-- 받는 사람 이메일 -->
				<input type="text" name="tomail" size="120" style="width: 100%"
					value="${param.email}" class="form-control">
			</div>
			<br>
			<p>
			<div align="center">
				<!-- 내용 -->
				<textarea name="content1" cols="120" rows="6"
					style="width: 100%; resize: none" placeholder="내용#"
					class="form-control">문의하신 내용 : ${param.content}</textarea>
					
					<textarea name="content2" cols="120" rows="6"
					style="width: 100%; resize: none" placeholder="내용#"
					class="form-control">[답변]
</textarea>
			</div>
			<input type="hidden" value="${param.seq }" name=seq>
			<input type="hidden" value="${param.email }" name=email>
			<p>
			<div align="center">
				<input type="button" value="메일 보내기" onclick="mail()" class="btn btn-warning">
				&nbsp; &nbsp;<button onclick="self.close()">닫기</button>
			</div>
		</form>
	</div>
</body>
</html>
