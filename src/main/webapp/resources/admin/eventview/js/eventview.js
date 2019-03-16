var seq = getParameterByName("seq");

$(function(){
	eReplyList(1);
	$(".eupdate").hide();
	$("#image").hide();
	$("#imgDel").hide();
	
	//이미지 수정버튼 클릭시
	$("#imgSave").click(function() {
		$("#img").hide();
		$("#imgSave").hide();
		$("#image").show();
		$("#imgDel").show();
	});
	
	//이미지 수정취소버튼 클릭시
	$("#imgDel").click(function() {
		$("#image").hide();
		$("#imgDel").hide();
		$("#img").show();
		$("#imgSave").show();
	});
});

function upbt() {
	$(".eview").hide();
	$(".eupdate").show();
}

function changeContent(){
	$("#content").val($("#ctt").val());
}

function replyOnOff(seq) {
	 if($(".reply2").css("display") == "none"){
		 $(".reply2").show();
			
		 eReplyList(1);
	 } else{
		 $(".reply2").hide();
	 }
}

//삭제버튼
function btdel(seq) {
	$.ajax({
		type:'POST',
		url:'deleteevent.ado',
		data:{seq:seq},
		success : function(data) {
			alert("삭제되었습니다.");
			var url='event.ado';
			window.location=url;
		}
	});
}

//댓글 목록
function eReplyList(erpage) {
	$.ajax({
		type:"GET",
		url:"aEReplyList.ado",
		data: {seq:seq,curPage:erpage},
		success : function(data) {
			$('.replyList').children().remove();
			var ereply='';
			if(data.eReplyList.length==0) {
				ereply += '<div class="rbox"><p>댓글이 없다... 무플이다....</p></div>';
				$('.replyList').append(ereply);
				return;
			}
			if(data.eReplyList.length!=0) {
				for(var i=0; i<data.eReplyList.length; i++) {
					var regdate = new Date(data.eReplyList[i].regdate);
					var regdateFormat = regdate.toISOString().slice(2,10);
					ereply += '<div class="rbox">작성자 : '+data.eReplyList[i].replyer+'</br>작성날짜 : '+regdateFormat+'<br/>';
					ereply += '<label id="upRe'+data.eReplyList[i].rno+'">'+data.eReplyList[i].replytext+'</label>';
					ereply += '<button hidden="true" id="caRE'+data.eReplyList[i].rno+'" onclick="caRE()">취소</button> ';
					ereply += '<button onclick="deRE('+seq+','+data.eReplyList[i].rno+')">삭제</button></span>';
					ereply += '</div>';
				}
				$('.replyList').append(ereply);
				blockPage("replyPaging",erpage,data.eReplyPage.BLOCK_SCALE,data.eReplyPage.totPage,"reli","eReplyList");
			}
		}
	});
}

//댓글 삭제
function deRE(seq,rno) {
	$.ajax({
		type:'POST',
		url:'aEReplyDelete.ado',
		data:{rno:rno},
		success : function(data) {
			eReplyList(1);
		}
	});
}

function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}
