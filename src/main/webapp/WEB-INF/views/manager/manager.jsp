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
<!-- Resources -->
<script src="https://www.amcharts.com/lib/4/plugins/wordCloud.js"></script>
<script type="text/javascript" 
	src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/manager/js/mjs.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/manager/js/date.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/manager/js/manager2.js"/>"></script>
<script type="text/javascript">


$(document).ready(function(){
	getTermSales();
});

function getTermSales(){
	
	paid_at_start=$("#paid_at_start").val();
	paid_at_end=$("#paid_at_end").val();
	
	$.ajax({
		  
		 type : "POST", 
		 url: "mgchart2.mdo", 
		 data:{paid_at_start:paid_at_start, paid_at_end:paid_at_end},     
		success:function(A){
	        
			// Themes begin
			am4core.useTheme(am4themes_material);
			am4core.useTheme(am4themes_animated);
			// Themes end
			var chart = am4core.create("chartdiv", am4charts.XYChart);
			
			//데이터 배열
			//데이터값?
			//데이터 삽입 시작
			var data = [];
			var value = 0;
		
			for(var i = 0; i <A.length; i++){
			  var date = new Date(A[i].reservdate);
			  value=A[i].su;
			  data.push({date:date, value: value});
			}
			
			//차트에 데이터
			chart.data = data;
			
			//축 생성
			// Create axes
			var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
			dateAxis.renderer.minGridDistance = 60;
			
			var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
			
			
			// 시리즈 만들기??
			// Create series
			var series = chart.series.push(new am4charts.LineSeries());
			series.dataFields.valueY = "value";
			series.dataFields.dateX = "date";
			series.tooltipText = "{value}"
			
			series.tooltip.pointerOrientation = "vertical";
			
			chart.cursor = new am4charts.XYCursor();
			chart.cursor.snapToSeries = series;
			chart.cursor.xAxis = dateAxis;
			
			//chart.scrollbarY = new am4core.Scrollbar();
			chart.scrollbarX = new am4core.Scrollbar();
							}
				});
	
}
		
		



</script>	

<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav">
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<a href="#" id="logo" onclick="javascript:manager();"></a><img
					class="logo"
					src="<c:url value="/resources/public/logo/mainlogo.png"/>" /><a></a>
			</div>
			<jsp:include page="form/TopMenu1.jsp"></jsp:include>
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
				<jsp:include page="form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		 
	<%-- 	<c:forEach var="vo" items="${map.test }">
			<input type="hidden" value="${vo.reservdate }" name="test1"/>
			<input type="hidden" value="${vo.gunsu }" name="test2"/> 
			  
		</c:forEach>--%>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>관리자 초기 페이지</header>

				<div id="today">
					<div id="tmember">
						<div id="day">
							TODAY
							<p id="date"></p>
						</div>
						<div id="su1">
							회원로그인<br />
							<div id="su11">${map.login}</div>
						</div>
						<div id="su2">
							예약수<br />
							<div id="su11">${map.room}</div>
						</div>
						<div id="su3">
							방문수<br />
							<div id="su11">${map.login}</div>
						</div>



						<div id="tsu">
							<ul>
								<li>회원 <label>${map.member} 명</label></li>
								<li>예약<label>${map.room} 개</label></li>
								<%-- <li>회원가입<label>${map.joincount} 명</label></li> --%>
								<li>환불신청 <label>${map.reroom} 개</label></li>
							</ul>
						</div>
					</div>
				</div>

				<h3 id="h3">예약 그래프</h3>
				<div id="statistics">
					<div id="chartdiv"></div>
				</div>

				<!-- HTML -->
				<div id="chartdiv2"></div>

			</div>
			<!-- <div id="chart_div"></div> -->
		</section>
		<aside id="right">
			<div id="rtd">
				<div class="rdiv">최신소식</div>
				<ul id="rul">
					<li>${map.list.get(0).content }</li>
					<li>${map.list.get(1).content }</li>
					<li>${map.list.get(2).content }</li>
					<li>${map.list.get(3).content }</li>
					<li>${map.list.get(4).content }</li>
				</ul>
			</div>

			<!-- <div id="re">
				<div class="rdiv">최신댓글</div>
				<ul id="rul">
					<li>asasdasd</li>
					<li>asdasda</li>
					<li>asfsaf</li>
					<li>asdsadas</li>
					<li>asdasdasd</li>
				</ul>
			</div> -->

		</aside>
	</div>
	<footer>
		<jsp:include page="form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>