<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>"> --%>
</head>
<body>

<nav class="navbar navbar-default">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed"
            data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
            aria-expanded="false">
            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
               class="icon-bar"></span>
         </button>

<!-- logo -->
<div class="navbar-brand">
	<a href="<c:url value="/admin.do"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>" width="100" height="100"/></a>
</div>
         
         
      </div>
      
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<!-- 메뉴1 -->
<ul class="nav navbar-nav">
	<li><a href="admin.do">판매현황</a></li>
	<li><a href="approve.do">지점장승인</a></li>
	<li><a href="board.do">자주묻는질문</a></li>
	<li><a href="gongji.do">공지사항</a></li>
	<li><a href="inquire.do">문의게시판</a></li>
	<li><a href="event.do">이벤트</a></li>
	<li><a href="reportboard.do">보고게시판</a></li>
	<li><a href="howtouseboard.do">이용가이드</a></li>
	<li><a href="member.do">회원관리</a></li>
	<li><a href="admininfo.do">관리자정보</a></li>
</ul>

<!-- 메뉴2 -->
<ul class="nav navbar-nav navbar-right">
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">메뉴
			<span class="caret"></span></a>
		<ul class="dropdown-menu">
			<li class="active"><a href="logout.do">로그아웃</a></li>
			<li class="active"><a href="moveUserMode.do">사용자모드</a></li>
		</ul>
	</li>
</ul>
</div>
   </nav>
</body>
</html>