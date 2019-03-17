function showSd(num){
	$(".showSchedule table tr td").css({"text-decoration":"","color":""});
	
	var seldate=$("#reservDate").val(); 
	
	$.ajax({      
		type:"GET",  
		url:"getSchedule.do",    
		data:{roomnum:num, seldate:seldate},     
		success:function(data){
			var sch=data.reservstate;
			console.log("sch="+sch);
			if(sch==undefined){
				$("#startdate").text("");
				$("#startdate").text(seldate);
				$("#scroomname").text("");
				$("#scroomname").text(" "+$(".roomname"+num).text()+"방");
				
				$(".showSchedule").display="";
				$(".showSchedule").show();
				return;
			}else{
				var splitsch=sch.split(",");
				var spschresult="";
			
				var time="";
				for ( var i in splitsch ) {
					time=getSelTime(getTimeTxt(splitsch[i]));
				$(time).css({"text-decoration":"line-through double","color":"gray"});
				}
			}
			$("#startdate").text("");
			$("#startdate").text(seldate);
			$("#scroomname").text("");
			$("#scroomname").text(" "+$(".roomname"+num).text()+"방");
			$(".showSchedule").display="";
			$(".showSchedule").show();
			
		}
	});
}

function hideSd(){
	$(".showSchedule").hide();
}

/* 주소 select 시/군/도 */
$('document').ready(function() {
	var sido=$("option:selected",$(this));
	var area0=$("#sido_select>option").map(function() { return $(this).val(); });

	// 시/도 선택 박스 초기화
	$("select[name^=sido]").each(function() {
		$selsido = $(this);
		var sel_gugun=$("#sel_gugun").val();

			$.ajax({      
				 type:"GET",  
				 url:"getSidoGugun.do",    
				  data:sido,      
				  success:function(data){  
			    	 for(var i=0; i<data.length; i++){
			    		 if(data[i].trim()==sel_gugun.trim()){
			    			 $selsido.next().append("<option value='"+sel_gugun+"' selected='selected'>"+sel_gugun+"</option>");
			    		 }else{
			    			 $selsido.next().append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			    		 }
			    		 
			    	 }
			     }
			});   

	});

	// 시/도 선택시 구/군 설정
	$("select[name^=sido]").change(function() {
		var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의// 구군// Array													
		var $gugun = $(this).next(); // 선택영역 군구 객체
		$("option",$gugun).remove(); // 구군 초기화
		
		var sido=$("option:selected",$(this));
		
		$.ajax({      
			 type:"GET",  
			 url:"getSidoGugun.do",    
		     data:sido,      
		     success:function(data){   
		    	 for(var i=0; i<data.length; i++){
		    		 $gugun.append("<option value='"+data[i]+"'>"+data[i]+"</option>");
		    	 }
		     }
		});   
	});
	
	$("select[name^=gugun]").change(function() {
		var sido=$("#sido_select option:selected").val();
		var gugun=$("#gugun_select option:selected").val();
		
		 $.ajax({      
				type:"GET",  
				url:"getCanReservRoom.do",    
				data:{sido:sido, gugun:gugun,seldate:''},     
				success:function(data){  
					$(".showView").remove();
					var strDom='';
					for(var i=0; i<data.length; i++){
						strDom+='<div class="showView">';
						strDom+='<a href="roomDetail.do?roomnum='+data[i].roomNum+'">';
						strDom+='<img src="resources/rooms/'+data[i].fname+'"/></a><br/>';
						strDom+='<a href="roomDetail.do?roomnum='+data[i].roomNum+'" class="roomname'+data[i].roomNum+'">'+data[i].roomName+'</a><br/>';
						strDom+='<label>('+data[i].branchName+')</label><br/>';
						strDom+='<label>'+data[i].roomEx1+'</label><br/>';
						strDom+='<label>'+data[i].roomEx2+'</label><br/>';
						strDom+='<label>'+data[i].roomEx3+'</label></div>';
					}
					$('.showRoom').append(strDom);
				}
			});
	});
});

//날짜 입력후 ajax로 데이터 처리
function findCanReservRoom(){
	var sido=$("#sido_select option:selected").val();
	var gugun=$("#gugun_select option:selected").val();
	var seldate=$("#reservDate").val(); 

	var localdate=new Date();
	var month = (localdate.getMonth() + 101).toString().substring(1);
	var day = (localdate.getDate() + 100).toString().substring(1);
	var year = localdate.getFullYear();
	
	
	
	var thisdate=year+month+day;
	var selsplit=seldate.split("-");
	var selspdate="";
	
	for ( var i in selsplit ) {
        selspdate+=selsplit[i];
     }
	
	
	if(selspdate<thisdate){
		alert("날짜를 확인해주세요^^");
	}else{
		var strDom="";
		$.ajax({      
			type:"GET",  
			url:"getCanReservRoom.do",    
			data:{sido:sido, gugun:gugun, seldate:seldate},     
			success:function(data){  
				$(".showView").remove();
				for(var i=0; i<data.length; i++){
					strDom+='<div class="showView">';
					strDom+='<a href="roomDetail.do?roomnum='+data[i].roomNum+'&seldate='+seldate+'" onmouseenter="showSd('+data[i].roomNum+')" onmouseleave="hideSd()">';
					strDom+='<img src="resources/rooms/'+data[i].fname+'"/></a><br/>';
					strDom+='<a href="#" class="roomname'+data[i].roomNum+'">'+data[i].roomName+'</a><br/>';
					strDom+='<label>('+data[i].branchName+')</label><br/>';
					strDom+='<label>'+data[i].roomEx1+'</label><br/>';
					strDom+='<label>'+data[i].roomEx2+'</label><br/>';
					strDom+='<label>'+data[i].roomEx3+'</label></div>';
				}
				$('.showRoom').append(strDom);
				alert("날짜가 적용되었습니다")
			}
		});
	}
}