//메신져이미지 누르면 알림으로 바로 내려감
function goToNotice(){
	scrollDown(".allnon");
}
var keepdc=0;
var reserdc=0;
var noticedc=0;
//리스트 닫고 열고
function displayBoard(num){
	if(num==1&&keepdc==0){
		$(".favorlist").hide();
		keepdc=1;
		scrollOn(".favorlist");
		return;
	}
	if(num==1&&keepdc==1){
		$(".favorlist").display="";
		$(".favorlist").show();
		keepdc=0;
		scrollDown(".favorlist");
		return;
	}
	if(num==2&&reserdc==0){
		$(".rslist").hide();
		reserdc=1;
		scrollOn(".reservation");
		return;
	}
	if(reserdc==1&&reserdc==1){
		$(".rslist").display="";
		$(".rslist").show();
		reserdc=0;
		scrollDown(".rslist");
		return;
	}
	
}
//열고닫고 스크롤 함수
function scrollOn(str){
	var offset = $(str).offset();
    $('html, body').animate({scrollTop : offset.top}, 400);
}
function scrollDown(str){
	var offset = $(str).offset();
    $('html, body').animate({scrollTop : offset.top-50}, 400);
}
//회원 탈퇴
function userOut(){
	if(confirm("정말로 탈퇴 하시겠습니까?")){
	$.ajax({      
		type:"POST",  
		url:"deactivatemember.do",      
		success:function(){
			alert("성공적으로 탈퇴 되었습니다.");
			window.location.href="logout.do";
		}
	});
	}else{
		alert("취소되었습니다");
	}
}