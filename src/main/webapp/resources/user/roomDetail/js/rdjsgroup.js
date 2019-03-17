var rnum=getParameterByName('roomnum'); //방번호 가져오기
var reservtime="";
var count=0;
var userid='';
var seldate='';
var incount=0;
$('document').ready(function($) {
	incount=1;
	showSd(rnum);
	showReview(1);
	userid = '@Request.RequestContext.HttpContext.Session["member"]';
});
//날짜에 따른 스케줄
function showSd(num){
	daumschReset();
	$("#schdule tr td").css({"text-decoration":"","color":""});
	
	seldate=$("#reservDate").val(); 
	
	$("#reservdate").val(seldate); 
	
	$.ajax({      
		type:"GET",  
		url:"getSchedule.do",    
		data:{roomnum:num, seldate:seldate},     
		success:function(data){
			var sch=data.reservstate;
			if(sch==undefined){
				schClickReset();
				if(incount>=2){
					alert("적용되었습니다.");
				}
				$("#startdat").text("");
				$("#startdat").text(seldate);
				$("#scroomname").text("");
				$("#scroomname").text(" "+$(".roomname"+num).text()+"방");
				
				$(".showSchedule").display="";
				$(".showSchedule").show();
				incount++;
				return;
			}else{
				schClickReset();
				if(incount>=2){
					alert("적용되었습니다.");
				}
				var splitsch=sch.split(",");
				var spschresult="";
			
				var time="";
				for ( var i in splitsch ) {
					var time=getSelTime(getTimeTxt(splitsch[i]));
				$(time).css({"text-decoration":"line-through double","color":"gray"});
				}
				incount++;
			}
			$("#startdat").text("");
			$("#startdat").text(seldate);
			$(".showSchedule").display="";
			$(".showSchedule").show();
			
		}
	});
}

//찜 , 안찜
var kst=0;
function changeChoiceImg(img){
	var image=$("#keep").attr('src');
	var ronum=$("#roomNum").val();

	if(image.match("notChoiceList.png")){
		kst=1;
		$("#keep").attr('src','resources/user/roomDetail/images/choice.png');
	}else{
		kst=0;
		$("#keep").attr('src','resources/user/roomDetail/images/notChoiceList.png');
	}
	$.ajax({      
		type:"GET",  
		url:"changekeeproom.do",    
		data:{roomnum:ronum,kst:kst},     
		success:function(data){
			
		}
	});
}

var sclickct=0;
var daumclick=0;
var stid=0;
var edid=0;
var dedid=0;
var endid='';
var startid='';
var reserveEndTime='';
$(function(){
$("#schdule tr td").click(function(){
	if(seldate==''){
		alert("예약하실 날짜를 먼저 선택해주세요^^");
		return;
	}
	var txt = $(this).text();
	
	var sel_time=getSelTime(getTimeTxt(txt));
		
	var backcolor = $(sel_time).css("background-color");
	var color=$(sel_time).css("color");
	
	if(color=='rgb(128, 128, 128)'){
		color='';
		alert("예약된 시간입니다. 다른시간을 이용해주세요");
		schClickReset();
		return;
	}
	//시작시간 선택
	var sttime='';
	if(sclickct==0){
		sclickct=1;
		startid=sel_time;
		stid=startid.replace(/[^0-9]/g,'');
		$(sel_time).css("background-color","pink");
		if(reservtime==undefined||reservtime==''){ reservtime=getTimeTxt(txt)+",";} 
		else{reservtime+=getTimeTxt(txt)+",";}
		count=1;
		var roomprice=$("#payPrice").val();
		var realprice=roomprice*count;
		$(".payArea").text("☆가격☆ ￦"+realprice);
		$("#payAmount").val(realprice);
		$("#reserveTime").val(reservtime);
		return;
	}
	//끝나는 시간 선택
	
	if(sclickct==1){
		sclickct=2;
		endid=sel_time;
		edid=endid.replace(/[^0-9]/g,'');
		if(edid-stid<3){
			alert("♡시작시간과 끝시간을 확인해주세요^^ 저희 달빛은 2시간 기본 예약입니다♡");
			schClickReset();
			return;
		}else{
			for(var i=(stid*1+1); i<(edid*1+1); i++){
				var color=$("#b"+i).css("color");
				if(color=='rgb(128, 128, 128)'){
					schClickReset();
					alert("예약된 시간입니다. 다른시간을 이용해주세요");
					return;
				}
				reservtime+=getTimeTxt($("#b"+i).text())+",";
				$("#b"+i).css("background-color","skyblue");
				count++;
			}
			
			$(sel_time).css("background-color","skyblue");

			var roomprice=$("#payPrice").val();
			var realprice=roomprice*count;
			$(".payArea").text("☆가격☆ ￦"+realprice);
			$("#payAmount").val(realprice);
			$("#reserveTime").val(reservtime);
		}
		return;
	}
	if(sclickct==2){
		alert("선택초기화후 재 선택 해주세요♡");
	}
});
//다음스케줄
$("#daumschdule tr td").click(function(){
	if(seldate==''){
		alert("예약하실 날짜를 먼저 선택해주세요^^");
		return;
	}
	daumclick=1;
	var txt = $(this).text();
	var sel_time=getdaumSelTime(getTimeTxt(txt));
	var backcolor = $(sel_time).css("background-color");
	var color=$(sel_time).css("color");
	
	if(color=='rgb(128, 128, 128)'){
		color='';
		alert("예약된 시간입니다. 다른시간을 이용해주세요");
		schClickReset();
		return;
	}
	if(sclickct==0){
		alert("♡전날을 선택한 경우에만 사용가능합니다. 내일 예약은 날짜 재적용후 이용해주세요♡");
	}
	if(sclickct==1){
		sclickct=2;
		end=sel_time;
		dedid=sel_time.replace(/[^0-9]/g,'');
		if(dedid-stid<3){
			alert("♡시작시간과 끝시간을 확인해주세요^^ 저희 달빛은 2시간 기본 예약입니다♡");
			schClickReset();
			return;
		}else{
			for(var i=(stid*1+1); i<(dedid*1+1); i++){
				var color=$("#b"+i).css("color");
				if(color=='rgb(128, 128, 128)'){
					schClickReset();
					alert("예약된 시간입니다. 다른시간을 이용해주세요");
					return;
				}
				if(i<=48){
					reservtime+=getTimeTxt($("#b"+i).text())+",";
				}
				if(i>48){
					reserveEndTime+=getTimeTxt($("#b"+i).text())+",";
				}
				$("#b"+i).css("background-color","skyblue");
				count++;
			}
			
			$(sel_time).css("background-color","skyblue");

			var roomprice=$("#payPrice").val();
			var realprice=roomprice*count;
			$(".payArea").text("☆가격☆ ￦"+realprice);
			$("#payAmount").val(realprice);
			$("#reserveTime").val(reservtime);
			$("#reserveEndTime").val(reserveEndTime);
			console.log(reservtime);
			console.log(reserveEndTime);
		}
		return;
	}
	if(sclickct==2){
		alert("선택초기화후 재 선택 해주세요♡");
	}
});
});

//새벽손님 스케줄 가져오기
function daumschclick(num){
	daumschReset();
	$("#daumschdule tr td").css("background-color","white");
	var daumdate=$("#reservDate").val();
	var ddate=daumdate.split("-");
	var nyan=ddate[0];
	var war=ddate[1];
	var il=ddate[2];
	var ilplus=1;
	il*=ilplus;
	daumdate = new Date(nyan, war-1, il);
	
	var month = (daumdate.getMonth() + 101).toString().substring(1);
	var day = (daumdate.getDate() + 101).toString().substring(1);
	var year = daumdate.getFullYear();
	
	daumdate=year+"-" +month+"-"+day;
	console.log(daumdate);
	$("#reservenddate").val(daumdate);
	$.ajax({      
		type:"GET",  
		url:"getSchedule.do",    
		data:{roomnum:num, seldate:daumdate},     
		success:function(data){
			var sch=data.reservstate;
			if(sch==undefined){
				$("#daumschdule").show();
				return;
			}else{
				var splitsch=sch.split(",");
				var spschresult="";
			
				var time="";
				for ( var i in splitsch ) {
					var time=getdaumSelTime(getTimeTxt(splitsch[i]));
				$(time).css({"text-decoration":"line-through double","color":"gray"});
				}
				incount++;
				$("#daumschdule").show();
			}
		}
	});
	
}
//선택초기화
function schClickReset(){
	$("#reserveTime").val("");
	$("#reserveEndTime").val("");
	sclickct=0;
	reservtime="";
	$("#schdule tr td").css("background-color","white");
	$("#daumschdule tr td").css("background-color","white");
	$(".payArea").text("☆가격☆ ￦ 원");
}
function daumschReset(){
	schClickReset();
	$("#reservenddate").val("");
	reserveEndTime='';
	dedid=0;
	$("#daumschdule tr td").css("background-color","white");
	$(".payArea").text("☆가격☆ ￦ 원");
	$("#daumschdule").hide();
}

//리뷰가져오기
function showReview(rvcurpage){
	$.ajax({      
		type:"GET",  
		url:"getRoomAllReview.do",    
		data:{curpage:rvcurpage ,roomnum:rnum},     
		success:function(data){
			$(".rbox").remove();
			var rvtDom='';
			var strDom="";
			
			if(data.rvlist.length==0){
				strDom+='<div class="rbox">';
				strDom+='여러분의 한줄후기를 기다리고 있습니다</div>';
				rvtDom+='<b style="font-size:2vw">      총점 0점</b>';
				$("#rvtitle").text("");
				$("#rvtitle").append(rvtDom);
			}else{
				rvtDom+='<b style="font-size:2vw">      총점 '+data.rvscore+' 점</b>';
				$("#rvtitle").text("");
				$("#rvtitle").append(rvtDom);
				
				for(var i=0; i<data.rvlist.length; i++){
					strDom+='<div class="rbox">';
					for(j=0; j<data.rvlist[i].starCt; j++){
						strDom+='<img src="resources/util/star.png"/>';
					}
					strDom+='<label style="color:gray;">작성날짜 : '+data.rvlist[i].writedate+'</label><br/>';
					strDom+='작성자 : '+data.rvlist[i].name+'<br/><br/>';
					if(data.member.position=='총관리자'||data.member.position=='관리자'){
						strDom+='<label id="revct">'+data.rvlist[i].reviewContent+'</label> <button onclick="delreview('+data.rvlist[i].roomNum+',&#039'+data.rvlist[i].id+'&#039)">삭제</button><br/>';
					}
					if(data.member.id==data.rvlist[i].id){
						strDom+='<label id="revct">'+data.rvlist[i].reviewContent+'</label> &emsp;<button class="upbt" onclick="upreview('+data.rvlist[i].roomNum+',&#039'+data.rvlist[i].reviewContent+'&#039)">수정하기</button> <button hidden="true" class="cupbt" onclick="cancleUpReview(&#039'+data.rvlist[i].reviewContent+'&#039)">수정 취소</button> <button onclick="delreview('+data.rvlist[i].roomNum+')">삭제</button><br/>';
					}
					if(data.member.position!='총관리자'&&data.member.position!='관리자'){
						strDom+=data.rvlist[i].reviewContent+'<br/>';
					}
					
					strDom+='</div>'
				}
			}
			$('#rboxsec').append(strDom);
			blockPage("pnum",rvcurpage,data.rvpager.BLOCK_SCALE,data.rvpager.totPage,"pli","showReview");
		}
	});
}
//리뷰 수정
function upreview(roomnum,content){
	$(".cupbt").show();
	$("#revct").text("");
	$("#revct").append("<input id='rvcontent' type='text' size='80' value='"+content+"'/>");
	$(".upbt").html("수정 완료");
	$(".upbt").removeAttr("onclick");
	$(".upbt").attr("onclick","upReviewContent("+roomnum+",'"+content+"')");
}
function upReviewContent(roomnum,content){
	$("#revct").text($("#rvcontent").val());
	rcon=$("#revct").text();
	$("#revct").children().remove();
	$(".cupbt").hide();
	$.ajax({      
		type:"GET",  
		url:"upReviewContent.do",    
		data:{roomnum:roomnum,reviewContent:rcon},     
		success:function(){
			
			alert("수정이 완료되었습니다.");
		}
	});

}
function cancleUpReview(content){
	$("#revct").text(content);
	$(".cupbt").hide();
}
function delreview(roomnum,id){
	var ans=confirm("정말로 삭제하시겠습니끼?");
	if(ans){
		console.log("삭제하께");
		$.ajax({      
			type:"GET",  
			url:"delReviewContent.do",    
			data:{roomnum:roomnum,id:id},     
			success:function(){
				showReview(1);
				alert("삭제가 완료되었습니다.");
			}
		});
		return;
	}else{
		console.log("안하게");
		return;
	}
}

//url가져온는 function
function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    return results[2];
}