<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
<link rel="stylesheet" href="<c:url value="/resources/admin/sales.css"/>" />
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/admin/js/sales.js"/>"></script>

<title>승인 페이지</title>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
<%@include file="../admin/footer.jsp" %>
	<!-- 이거 나중에 admin zicode업데이트 하고 다시 js처리하면됨 -->
	<h3>달빛 총 매출현황</h3>
	<div class="searchArea">
		<input id="paid_at_start" type="date" />&emsp;-&emsp;<input
			id="paid_at_end" type="date" />&emsp;
		<button id="btn" onclick="getTermSales()">검색</button>
		&emsp;&emsp;&emsp;&emsp;기준선 :
		<form action="setBaseLine.do" method="post" class="baseline">
			<input type="text" id="baseline" />
			 <input id="btn" type="button" onclick="setBaseLine()" value="적용">
		</form>
	</div>
	<div id="chartdiv"></div>
</body>
</html>