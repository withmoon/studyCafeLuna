var stdate='';
var endate='';
var hasuserreview=new Array();
var stcount=0;  //별 갯수
var rvwroomNum='';  //리뷰선택시 해당 방번호
//리뷰 열고 닫고 
function openReview(num){
	rvwroomNum=num;
	$(".review").display="";
	$(".review").show();
	$('body > *:not(.review) ').css('filter',filterVal10);
}
function closeReview(){
	$('body > *:not(.review) ').css('filter',filterVal0);
	$(".star").attr('src','resources/util/unstar.png');
	stcount=0;
	$("#starcount").text(0);
	$(".review").hide();
}
$(function(){
	getKeepList(1);
	//최근예약
	getReservList('pay',1);
	//지난예약
	getUserReview();
	getReservList('reserved',1);
	getqnalist(1);
});
//찜 리스트 가져옴
function getKeepList(kcurpage){
	$.ajax({      
		type:"GET",  
		url:"keeproomlist.do",    
		data:{curpage:kcurpage},     
		success:function(data){
			var kstrDom='';
			//방있을때
			$("#fvTable").children().remove();
			for(var i=0; i<data.klist.length; i++){
				if(i%2==0){
					kstrDom+='<tr>';
				}
				kstrDom+='<td><a href="roomDetail.do?roomnum='+data.klist[i].roomNum+'">';
				kstrDom+='<img src="resources/rooms/'+data.klist[i].fname+'"><br/>'+data.klist[i].roomName+'</a></td>';
				if(i%2==1){
					kstrDom+='<tr>';
					kstrDom+='</tr>';
				}
				if((data.klist.length-1)%2==0&&i==data.klist.length-1){
					kstrDom+='</tr>';
				}
			}
			$("#fvTable").append(kstrDom);
			//방 없을때
			if(data.klist.length==0){
				$("#nonroom").display='';
				$("#nonroom").show();
			}
			blockPage("fvPaging",kcurpage,data.kpager.BLOCK_SCALE,data.kpager.totPage,"kpli","getKeepList");
		}
	});
}

//문의글 가져옴
function getqnalist(qcurpage){
	$.ajax({      
		type:"GET",  
		url:"qnalist.do",    
		data:{curpage:qcurpage},     
		success:function(data){
			var qstrDom='';
			//방있을때
			$("#notification4").children().remove();
			for(var i=0; i<data.alist.length; i++){	
				if(data.alist[i].reply!=''&&data.alist[i].reply!=undefined){
					qstrDom+='<tr>';
					if(data.alist[i].readst==0){
						$("#queAlimg").attr("src","resources/user/mypage/images/queg.gif");
						qstrDom+='<td><b class="rerp'+data.alist[i].seq+'">'+data.alist[i].sregdate+'<b></td>';
						qstrDom+='<td><b class="rerp'+data.alist[i].seq+'">'+data.alist[i].title+'<b></td>';
						qstrDom+='<td><b class="rerp'+data.alist[i].seq+'">'+data.alist[i].branchName+'<b></td>';
					}
					if(data.alist[i].readst==1){
						qstrDom+='<td><b style="color:gray">'+data.alist[i].sregdate+'<b></td>';
						qstrDom+='<td><b style="color:gray">'+data.alist[i].title+'<b></td>';
						qstrDom+='<td><b style="color:gray">'+data.alist[i].branchName+'<b></td>';
					}
					qstrDom+='<td><button class="qnc'+data.alist[i].seq+'" onclick="showQnContent('+data.alist[i].seq+',&#039'+encodeURI(data.alist[i].reply)+'&#039,'+data.alist[i].readst+')">내용보기</button> <button class="qcbtn'+data.alist[i].seq+'" hidden="true"  onclick="deleteQnContent('+data.alist[i].seq+')"> 삭제하기 </button> </td>'; 
					qstrDom+='</tr><tr  hidden="true" id="qnc'+data.alist[i].seq+'" style="border:1px solid lightgray;"><td colspan="2" style="background-color:Wheat; color:gray">'+data.alist[i].content+'</td>';
					qstrDom+='<td colspan="2" style="border-left:1px solid darkgray;background-color:beige; color:gray">'+data.alist[i].reply+'</td>';
				}
				if(data.alist[i].reply==''||data.alist[i].reply==undefined){  //답변이 없는 경우
					qstrDom+='<tr>';
					qstrDom+='<td><b>'+data.alist[i].sregdate+'<b></td>';
					qstrDom+='<td><b>'+data.alist[i].title+'<b></td>';
					qstrDom+='<td><b>'+data.alist[i].branchName+'<b></td>';
					qstrDom+='<td><button class="qnc'+data.alist[i].seq+'" onclick="showQnContent('+data.alist[i].seq+')">내용보기</button></td>';
					qstrDom+='</tr><tr  hidden="true" id="qnc'+data.alist[i].seq+'" style="border:1px solid lightgray;">';
					qstrDom+='<td colspan="2" style="background-color:darkgray; color:gray;">';
					qstrDom+='<textarea id="qtx'+data.alist[i].seq+'" style="resize:none; font-size:1.7vw" rows="4" cols="30" disabled="disabled">'+data.alist[i].content+'</textarea><br/>';
					qstrDom+='<button  class="qubt'+data.alist[i].seq+'" onclick="resetQnContent('+data.alist[i].seq+')"> 수정 하기 </button> <button class="qcbtn'+data.alist[i].seq+'" hidden="true"  onclick="cacleResetQnContent('+data.alist[i].seq+',&#039'+data.alist[i].content+'&#039)"> 수정 취소 </button> <button  onclick="deleteQnContent('+data.alist[i].seq+')"> 삭제 </button></td>';
					qstrDom+='<td style="border-left:1px solid darkgray" colspan="2" style="color:black">아직 답변이 없습니다.</td>'; 
				}
				qstrDom+='</tr>';
			}
			//없으면
			if(data.alist.length==0){
				qstrDom+='<tr><td colspan="4">문의내역이 없습니다.</td></tr>';
			}
			$("#notification4").append(qstrDom);
			
			blockPage("ntpaging",qcurpage,data.apager.BLOCK_SCALE,data.apager.totPage,"ntli","getqnalist");
		}
	});
}
//내용보기
function showQnContent(seq,reply,readst){ 
		$(".rerp"+seq).css("color","gray");
		$("#qnc"+seq).show();
		$(".qnc"+seq).html("닫기");
		$(".qnc"+seq).removeAttr("onclick");

			$(".qnc"+seq).attr("onclick","closeQnContent("+seq+",'"+reply+"')");

		$(".qcbtn"+seq).show();
		
		if(readst==0&&reply!=undefined||readst==0&&reply!=''){ //읽음 표시 ajax
			$.ajax({      
				type:"GET",  
				url:"upUserQnaReadst.do",    
				data:{seq:seq},     
				success:function(){
					
				}
			});
		}
}
//닫기
function closeQnContent(seq){
	$("#qnc"+seq).hide();
	$(".qnc"+seq).html("내용보기");
	$(".qnc"+seq).removeAttr("onclick");
	$(".qnc"+seq).attr("onclick","showQnContent("+seq+")");
}
//수정하려고함
function resetQnContent(seq){
	$(".qubt"+seq).html("수정완료");
	$(".qubt"+seq).removeAttr("onclick");
	$(".qubt"+seq).attr("onclick","updateQnContent("+seq+")");
	$(".qcbtn"+seq).show();
	$("#qtx"+seq).attr('disabled', false);
}
//
/**/
//수정취소
function cacleResetQnContent(seq,content){
	$(".qubt"+seq).html("수정하기");
	$(".qubt"+seq).removeAttr("onclick");
	$(".qubt"+seq).attr("onclick","resetQnContent("+seq+")");
	$(".qcbtn"+seq).hide();
	$("#qtx"+seq).val(content);
	$("#qtx"+seq).attr('disabled', true);
}
//수정완료
function updateQnContent(seq){
	var content=$("#qtx"+seq).val();
	$.ajax({      
		type:"GET",  
		url:"upUserQnaContent.do",    
		data:{seq:seq,content:content},     
		success:function(){
			alert("문의가 성공적으로 수정되었습니다.");
			cacleResetQnContent(seq,content);
		}
	});
}

//삭제
function deleteQnContent(seq){
	var ans=confirm("정말로 삭제하시겠습니끼?");
	if(ans){
		console.log("삭제하께");
		$.ajax({      
			type:"GET",  
			url:"deleteUserQna.do",    
			data:{seq:seq},     
			success:function(){
				alert("문의가 성공적으로 삭제되었습니다.");
				getqnalist(1);
			}
		});
		return;
	}else{
		alert("취소되었습니다.");
		return;
	}
}

//후기 올리기 //룸넘, 리뷰내용, 별 카운트 
function writeReview(){
	stcount=$("#starcount").text();
	var rvwText=$("#rvwText").val();
	$.ajax({      
		type:"GET",  
		url:"writeReview.do",    
		data:{starCount:stcount,roomnum:rvwroomNum,content:rvwText},     
		success:function(){
			closeReview();
			alert("감사합니다. 앞으로 더 힘쓰겠습니다^^");
			getUserReview("inreview");
		}
	});
}
//사용자가 달은 리뷰의 방 번호 가져오기
function getUserReview(state){
	$.ajax({      
		type:"GET",  
		url:"getUserReview.do",         
		success:function(data){
			for(var i=0; i<data.length; i++){
				hasuserreview[i]=data[i];
			}
			if(state=='inreview'){
				if(stdate!=''){
					getReservList("search",1); //지금이라네
				}
				if(stdate==''){
					getReservList("reserved",1); //지금이라네
				}
			}
		}
	});
}
//결제내역 가져오기
function getReservList(listType,lrcurpage){
	$.ajax({      
		type:"GET",  
		url:"getReserveList.do",    
		data:{listType:listType,curpage:lrcurpage,startdate:stdate,enddate:endate},     
		success:function(data){
			if(listType=='pay'){ //최근내역
				latelyList(lrcurpage,data);
			}else{ //지난내역
				lastList(lrcurpage,data);
			}
		}
	});
}
//최근내역 불러오기
function latelyList(lrcurpage,data){
	$("#lateTable tbody").children().remove();
	var ltDom='';
	if(data.rvlist.length==0){
		$("#lateTable").css({"position":"relative","top":"0px"});
		ltDom+='<tr><td colspan="7"> 최근 예약내역이 없습니다.</td>';
	}else{
		for(var i=0; i<data.rvlist.length; i++){
			ltDom+='<tr><td>'+data.rvlist[i].reservdate+'</td>';
			ltDom+='<td>'+data.rvlist[i].branchName+'</td>';
			ltDom+='<td><a href="roomDetail.do?roomnum='+data.rvlist[i].roomNum+'">'+data.rvlist[i].roomName+'</a></td>';
			ltDom+='<td>'+data.rvlist[i].branchtel+'</td>';
			ltDom+='<td>'+data.rvlist[i].branchAddr1+'</td>';
			ltDom+='<td>'+data.rvlist[i].starttime;
			if(data.rvlist[i].reservenddatetime==undefined||data.rvlist[i].reservenddatetime==':'){
				ltDom+='~'+data.rvlist[i].endtime+'</td>';
			}
			if(data.rvlist[i].reservenddatetime!=undefined||data.rvlist[i].reservenddatetime!=':'){
				ltDom+='~ 익일 '+data.rvlist[i].reservenddatetime+'</td>';
			}
			ltDom+='<td id="'+data.rvlist[i].imp_uid+'">';
			//환불가능상태
			if(data.rvlist[i].status==1){
				ltDom+='<button class="cancle" onclick=cancleReserve(&#039'+data.rvlist[i].imp_uid+'&#039)>취소/환불</button>';
				ltDom+='<button class="showRecipe" onclick="window.open(&#039'+data.rvlist[i].receipt_url+'&#039,&#039window_name&#039,&#039width=500,height=750,location=no,status=n&#039)">영수증</button>';
			}
			//환불요청상태
			if(data.rvlist[i].status==-2){
				ltDom+='<label>환불진행중</label>';
			}
			//환불상태
			if(data.rvlist[i].status==-1){
				ltDom+='<label>환불완료</label>';
				ltDom+='</td></tr>';
			}
		}
	}
	$("#lateTable tbody").append(ltDom);
	blockPage("ltPaging",lrcurpage,data.rvpager.BLOCK_SCALE,data.rvpager.totPage,"ltli","getReservList","pay");
}
//지난내역 및 검색 불러오기
function lastList(lrcurpage,data){
	$("#lastTable tbody").children().remove();
	
	var ltDom='';
	var ltmDom='';
	if(data.rvlist.length==0&&stdate==''){
		ltDom+='<tr><td colspan="5"> 지난 6개월간의 예약정보가 없습니다.</td>';
	}else if(data.rvlist.length==0&&stdate!=''){
		ltDom+='<tr><td colspan="5"> 선택하신 날짜안의 지난 예약정보가 없습니다.</td>';
	}else{
		for(var i=0; i<data.rvlist.length; i++){
			ltDom+='<tr><td>'+data.rvlist[i].reservdate+'</td>';
			ltDom+='<td>'+data.rvlist[i].starttime;
			if(data.rvlist[i].reservenddate==undefined){
				ltDom+='~'+data.rvlist[i].endtime+'</td>';
			}
			if(data.rvlist[i].reservenddate!=undefined){
				ltDom+='~ 익일 '+data.rvlist[i].reservenddatetime+'</td>';
			}
			ltDom+='<td>'+data.rvlist[i].branchName+'</td>';
			ltDom+='<td><a href="roomDetail.do?roomnum='+data.rvlist[i].roomNum+'">'+data.rvlist[i].roomName+'</a></td>';
			if(data.rvlist[i].status==-2){
				ltDom+='<td colspan="2"><label>환불진행중</label>';
			}else if(data.rvlist[i].status==-1){
				ltDom+='<td><label>환불완료</label>';
				ltDom+='<button class="showRecipe" onclick="window.open(&#039'+data.rvlist[i].receipt_url+'&#039,&#039window_name&#039,&#039width=500,height=750,location=no,status=n&#039)">영수증</button></td>';
			}else{
				for(var j=0; j<hasuserreview.length+1; j++){
					if(data.rvlist[i].roomNum==hasuserreview[j]){
						ltmDom='<td><button class="showRecipe" onclick="window.open(&#039'+data.rvlist[i].receipt_url+'&#039,&#039window_name&#039,&#039width=500,height=750,location=no,status=n&#039)">영수증</button></td>';
						break;
					}else{
						ltmDom='<td><button class="reviewBtn'+data.rvlist[i].imp_uid+'" onclick="openReview('+data.rvlist[i].roomNum+')">리뷰쓰기</button>'+
						'<button class="showRecipe" onclick="window.open(&#039'+data.rvlist[i].receipt_url+'&#039,&#039window_name&#039,&#039width=500,height=750,location=no,status=n&#039)">영수증</button></td>';
					}
				}
				ltDom+=ltmDom;
				
			}
			
		}
	}
	
	$("#lastTable tbody").append(ltDom);
	if(stdate!=''){
		blockPage("lastPaging",lrcurpage,data.rvpager.BLOCK_SCALE,data.rvpager.totPage,"lstli","getReservList","search");
	}else{
		blockPage("lastPaging",lrcurpage,data.rvpager.BLOCK_SCALE,data.rvpager.totPage,"lstli","getReservList","reserved");
	}
}
//적용시 처리
function lastSearch(){
	stdate=$("#stdate").val();
	endate=$("#endate").val();

	var localdate=new Date();
	var month = (localdate.getMonth() + 101).toString().substring(1);
	var day = (localdate.getDate() + 100).toString().substring(1);
	var year = localdate.getFullYear();
	var thisdate=year+month+day;
	
	var selsplit=stdate.split("-");
	var selstpdate="";
	
	for ( var i in selsplit ) {
		selstpdate+=selsplit[i];
     }
	
	selsplit=endate.split("-");
	var seledpdate="";
	
	for ( var i in selsplit ) {
		seledpdate+=selsplit[i];
     }
	
	
	if(selstpdate>thisdate){
		alert("지난내역은 오늘날짜 까지만 적용됩니다.");
	}else if(seledpdate>thisdate){
		alert("지난내역은 오늘날짜 까지만 적용됩니다.");
	}else if(stdate==''){
		alert("날짜를 모두 선택해주세요~ 하루만 선택시 두날짜 모두 같은날짜로 해주시면됩니다^^");
	}else if(endate==''){
		alert("날짜를 모두 선택해주세요~ 하루만 선택시 두날짜 모두 같은날짜로 해주시면됩니다^^");
	}else{
		getReservList('search',1,stdate,endate);
	}
}


//별 갯수 환산
function star1Click(){
		var image=$("#star1").attr('src');
		if(image.match("star.png")){
			switch(stcount){
			case 1:
				$("#star1").attr('src','resources/util/unstar.png');	
				stcount=0;
				break;
			case 2:
				$("#star2").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			case 3:
				$("#star2").attr('src','resources/util/unstar.png');	
				$("#star3").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			case 4:
				$("#star2").attr('src','resources/util/unstar.png');	
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			case 5:
				$("#star2").attr('src','resources/util/unstar.png');	
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');
				$("#star5").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			default : break;
			}
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			stcount=1;
		}
		$("#starcount").text(stcount);

}
function star2Click(){
		var image=$("#star2").attr('src');
		if(image.match("star.png")){
			switch(stcount){
			case 2:
				$("#star2").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			case 3:
				$("#star3").attr('src','resources/util/unstar.png');	
				stcount=2;
				break;
			case 4:
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');	
				stcount=2;
				break;
			case 5:
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');
				$("#star5").attr('src','resources/util/unstar.png');	
				stcount=2;
				break;
			default : break;
			}
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			$("#star2").attr('src','resources/util/star.png');
			stcount=2;
		}
		$("#starcount").text(stcount);
}


function star3Click(){
		var image=$("#star3").attr('src');
		if(image.match("star.png")){
			switch(stcount){
			case 3:
				$("#star3").attr('src','resources/util/unstar.png');	
				stcount=2;
				break;
			case 4:
				$("#star4").attr('src','resources/util/unstar.png');	
				stcount=3;
				break;
			case 5:
				$("#star4").attr('src','resources/util/unstar.png');
				$("#star5").attr('src','resources/util/unstar.png');	
				stcount=3;
				break;
			default : break;
			}
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			$("#star2").attr('src','resources/util/star.png');
			$("#star3").attr('src','resources/util/star.png');
			stcount=3;
		}
		$("#starcount").text(stcount);
}


function star4Click(){
		var image=$("#star4").attr('src');
		if(stcount==4&&image.match("star.png")){
			$("#star4").attr('src','resources/util/unstar.png');
			stcount=3;
		}
		if(stcount==5&&image.match("star.png")){
			$("#star5").attr('src','resources/util/unstar.png');
			stcount=4;
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			$("#star2").attr('src','resources/util/star.png');
			$("#star3").attr('src','resources/util/star.png');
			$("#star4").attr('src','resources/util/star.png');
			stcount=4;
		}
		$("#starcount").text(stcount);
}
function star5Click(){

		var image=$("#star5").attr('src');
		if(stcount==5&&image.match("star.png")){
			$("#star5").attr('src','resources/util/unstar.png');
			stcount=4;
			$("#starcount").text(stcount);
			return;
		}
		if(image.match("unstar.png")){
			$(".star").attr('src','resources/util/star.png');
			stcount=5;
		}
		$("#starcount").text(stcount);
}