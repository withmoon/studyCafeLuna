<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<script type="text/javascript"> 
function list(page) {
	location.href = "management.do?curPage="+page+"&searchOption=${map.searchOption}"+"&keywrod=${map.keyword}";
}
function cancelPay(id) {
	location.href = "Refund.do?id="+id;
	alert("회원 환불 검색");
} 
/* function cancelPay(id){
$.ajax({
	   type : "POST",
	   url : "Refund.do?",
	   data : {id:id},
	   success: function(data){    
	    alert("저장되었습니다.");
	    },
	   error : function (data) {
	    alert('죄송합니다. 잠시 후 다시 시도해주세요.');
	    return false;
	   }  
	  }); 
} */
	
</script>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/mgSalesreserve.css"/>"></link>
	
<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav">
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<a href="manager.do"><img class="logo"
					src="<c:url value="/resources/public/logo/mainlogo.png"/>" /></a>
			</div>
			<jsp:include page="/WEB-INF/views/manager/form/TopMenu1.jsp"></jsp:include>
		</div>
		<%-- <div id="TopMenu2">
					<jsp:include page="form/TopMenu2.jsp" />
				</div> --%>
	</nav>

	<!-- 배경 -->
	<div id="border">
		<!-- 왼측1 사이드 -->
		<div id="left1div">
			
			<aside id="left1">
				<jsp:include page="/WEB-INF/views/manager/form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>회원 관리</header>
			</div>
			
			<div>
		<div id="ex">
		<form name="form1" method="post" action="management.do?">
					<table id="searchtable">
						<tr>
							<td id="searchtd">
								<!-- 레코드의 갯수를 출력 -->
								<select name="searchOption">
									<option value="name"  <c:out  value="${map.searchOption == 'name' ? 'selected' : '' }" />>이름</option>
									<option value="id"  <c:out value="${map.searchOption == 'id'?'selected' : '' }"/> >아이디</option>
							</select> 
							<input name="keyword"  value="${map.keyword }"> 
							<input id="submit" type="submit" value="검색">
							</td>
						</tr>
					</table>
				</form>
		</div>

		<!-- db데이터 -->
		<table id="t">
			<tr id="ttr1">
				<th>ID</th>
				<th>이름</th>
				<th>폰번호</th>
				<th>Email</th>
				<th>상태</th>
			</tr>
			<c:forEach var="sales" items="${map.list}">
				<tr>
					<%-- <th><fmt:formatDate value="${sales.date}" pattern="yyyy-MM-dd"/> </th> --%>
					<td>${sales.id}</td>
					<td>${sales.name}</td>
					<td>${sales.phone}</td>
					<td>${sales.email}</td>
					<td>
					<c:if test="${sales.brstatus==-2}"><%-- ${sales.id} --%>
						<button onclick="cancelPay('${sales.id}')" name="id">제명상태</button> <br/> 
					<%-- 	<c:if test="${list.id==1 or list.id==-2}" >
							<button onclick="">결제확인/환불승인</button>
						</c:if>
						<c:if test="${list.id!=1 or list.id!=-2}" >
							<button onclick="">미결제</button>
						</c:if> --%>
						
					</c:if>
					<c:if test="${sales.brstatus==0}">
						회원
					</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
            <td colspan="5"> 
                <!-- 처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력-->
                <c:if test="${map.boardPager.curBlock > 1}">
                    <a href="javascript:list('1')">[처음]</a>
                </c:if>
                
                <!-- 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.boardPager.curBlock > 1}">
                    <a href="javascript:list('${map.boardPager.prevPage}')">[이전]</a>
                </c:if>
                
                <!-- **하나의 블럭 시작페이지부터 끝페이지까지 반복문 실행 -->
                <c:forEach var="num" begin="${map.boardPager.blockBegin}" end="${map.boardPager.blockEnd}">
                    <!-- 현재페이지이면 하이퍼링크 제거 -->
                    <c:choose>
                        <c:when test="${num == map.boardPager.curPage}">
                            <span style="color: red">${num}</span>&nbsp;
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:list('${num}')">${num}</a>&nbsp;
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
                <!-- 다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
                    <a href="javascript:list('${map.boardPager.nextPage}')">[다음]</a>
                </c:if>
                
                <!-- 끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
                    <a href="javascript:list('${map.boardPager.totPage}')">[끝]</a>
                </c:if>
            </td>
        </tr>    
		</table>
	</div> 
		</section>
		<jsp:include page="../../form/rigfht-side.jsp"></jsp:include>
	</div> 
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>