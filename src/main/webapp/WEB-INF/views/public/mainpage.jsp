<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"  content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet"  href="<c:url value="/resources/mainpage/css/mainpage.css"/>"/>
<title>스터디카페 달빛</title>
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value='/resources/mainpage/js/Main.js'/>"></script>
</head>
<body style="overflow-x:hidden; overflow-y:hidden">
<!-- 메인에서 변경되는 이미지 -->
<section>
<img id="PartOfMain_left" class="page1" src="<c:url value='/resources/mainpage/images/Page1.png'/>"/>
<img id="PartOfMain_left" class="page2" src="<c:url value='/resources/mainpage/images/Page2.png'/>"/>
<img id="PartOfMain_left" class="page3" src="<c:url value='/resources/mainpage/images/Page3.png'/>"/>
<img id="PartOfMain_left" class="page4" src="<c:url value='/resources/mainpage/images/Page4-1.png'/>"/>
<img id="PartOfMain_left" class="page5" src="<c:url value='/resources/mainpage/images/Page5.png'/>"/>
<!-- 시 있는 곳 -->
<img id="PartOfMain_right" src="<c:url value='/resources/mainpage/images/PartOfMain_right.gif'/>"/>
</section>

<!-- 이동 경로 -->
<section id="sec">
	<ul>
		<li><a href="home.do">&nbsp;홈으로&nbsp;</a></li><!--../Home/home.jsp  -->
		<li><a href="lookover.do">&nbsp;바로 예약&nbsp;</a></li><!-- ../LookOver/LookOver.jsp -->
		<li><a href="foundbranch.do">&nbsp;주변 지점 찾기&nbsp;</a></li><!-- ../Found/FoundBranch.jsp -->
	</ul>
	</section>
<!-- 이벤트  로그인/회원가입 -->
<nav> 
<ul class="topUl">
<li><a href="<c:url value="/event.do"/>">이벤트</a></li>
<c:if test="${member.id eq null }">
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="login.do">로그인&nbsp;/&nbsp;회원가입</a></li><!-- login.do -->
</c:if>
<c:if test="${member.id ne null }">
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="<c:url value="mypage.do"/>">마이페이지</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="<c:url value='/logout.do'/>">로그아웃</a></li>
</c:if>
</ul>
</nav>

</body>
</html>