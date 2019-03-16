<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<title>Insert title here</title>
</head>
<body>

		
		
				
			
		<ul class="memberUl">
			<c:if test="${member.id eq null}">
				<li><a href="<c:url value="/login.do"/>"><img src="<c:url value="/resources/public/images/login.gif"/>"/></a></li>
			</c:if>

		
			<c:if test="${member.id ne null}">
			<c:if test="${member.position ne null}"	>
				<c:if test="${member.position eq '총관리자' || member.position eq '관리자' }">
					<li><button onclick="javascript:window.location.href='admin.do'">관리자 모드</button> </li>
					</c:if>
			</c:if>
				<li><a class="lgoutli" href="<c:url value='/logout.do'/>"><img src="<c:url value="/resources/public/images/LogOut.gif"/>"/></a></li>
				<li><a href="<c:url value="/mypage.do"/>"><img src="<c:url value="/resources/public/images/mypage.gif"/>"/></a></li>
			</c:if>
		</ul>
		
		<ul class="topUl">
			<li class="topfound" onclick="location.href='<c:url value="/useGuide.do"/>'">이용가이드</li>
			<li class="topfound" onclick="location.href='<c:url value="/foundbranch.do"/>'">근처 장소 찾기</li>
			<li class="toplookover" onclick="location.href='<c:url value="/lookover.do"/>'">공간 둘러보기</li>
			<li class="topevent" onclick="location.href='<c:url value="/event.do"/>'">이벤트</li>
			<li class="topfound" onclick="location.href='<c:url value="/inform.do"/>'">고객 센터</li>

		</ul>
</body>
</html>