/* 배너 버튼 이벤트 */
function view1(opt) {
	if(opt) {
		whole2.style.display = "block";
	}
	else {
		whole2.style.display = "none";
	}
}

function view2(opt) {
	if(opt) {
		  previous2.style.display = "block";
	}
	else {
		  previous2.style.display = "none";
	}
}

function view3(opt) {
	if(opt) {
		  accumulate2.style.display = "block";
	}
	else {
		  accumulate2.style.display = "none";
	}
}

/* 방 찾기 넘어갈때 */
function findRoom(){
	var sido=$("#sido_select option:selected").val();
	var gugun=$("#gugun_select option:selected").val();
	var url='lookover.udo?sido='+sido+'&gugun='+gugun;
	window.location=url;
}


/* 주소 select 시/군/도 */
$('document').ready(function() {
	var area0= $("#sido_select>option").map(function() { return $(this).val(); });
	
	
	// 시/도 선택 박스 초기화
	$("select[name^=sido]").each(function() {
		$selsido = $(this);
		$selsido.next().append("<option value=''>시/구/군 선택</option>");
	});

	 
	// 시/도 선택시 구/군 설정
	$("select[name^=sido]").change(function() {
		var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의
																					// 구군
																					// Array
		var $gugun = $(this).next(); // 선택영역 군구 객체
		$("option",$gugun).remove(); // 구군 초기화
		
		var sido=$("option:selected",$(this));
		
		$.ajax({      
			 type:"GET",  
			 url:"getSidoGugun.udo",    
		     data:sido,      
		     success:function(data){   
		    	 for(var i=0; i<data.length; i++){
		    		 $gugun.append("<option value='"+data[i]+"'>"+data[i]+"</option>");
		    	 }
		     }
		});   
	});
});

//룸 링크 걸기
function goToRoomDetail(roomnum){
	window.location.href="roomDetail.udo?roomnum="+roomnum;
}

//최근 브랜치 링크
function gotoLookOver(sido,gugun){
	var url='lookover.udo?sido='+sido+'&gugun='+gugun;
	window.location=url;
}