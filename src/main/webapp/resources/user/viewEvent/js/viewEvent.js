var seq = getParameterByName("seq");

$(function() {
	eReplyList(1);
});

function replyOnOff(seq) {
	 if($(".reply2").css("display") == "none"){
		 $(".reply2").show();
			
		 eReplyList(1);
	 } else{
		 $(".reply2").hide();
	 }
}

//댓글 목록
function eReplyList(erpage) {
	$.ajax({
		type:"GET",
		url:"eReplyList.do",
		data: {seq:seq,curPage:erpage},
		success : function(data) {
			$('.replyList').children().remove();
			var ereply='';
			if(data.eReplyList.length==0) {
				ereply += '<div class="rbox"><p>댓글이 없어요... 남겨주시면 힘이 됩니다...</p></div>';
				$('.replyList').append(ereply);
				return;
			}
			if(data.eReplyList.length!=0) {
				for(var i=0; i<data.eReplyList.length; i++) {
					var regdate = new Date(data.eReplyList[i].regdate);
					var regdateFormat = regdate.toISOString().slice(2,10);
					ereply += '<div class="rbox">작성자 : '+data.eReplyList[i].replyer+'</br>작성날짜 : '+regdateFormat+'<br/>';
					ereply += '<label id="upRe'+data.eReplyList[i].rno+'">'+data.eReplyList[i].replytext+'</label>';
					if(data.userid == data.eReplyList[i].replyer) {
						ereply += '<span><button id="upbt'+data.eReplyList[i].rno+'" onclick="upReply('+seq+','+data.eReplyList[i].rno+')">수정</button> ';
						ereply += '<button hidden="true" id="caRE'+data.eReplyList[i].rno+'" onclick="caRE()">취소</button> ';
						ereply += '<button onclick="deRE('+seq+','+data.eReplyList[i].rno+')">삭제</button></span>';
					}
					
					ereply += '</div>';
				}
				$('.replyList').append(ereply);
				blockPage("replyPaging",erpage,data.eReplyPage.BLOCK_SCALE,data.eReplyPage.totPage,"reli","eReplyList");
			}
		}
	});
}

//댓글 등록
function writeCommand(seq){
	var content=$("#replytext").val();
	
	$.ajax({
		type:"POST",
		url:"eReplyInsert.do",
		data: {bseq:seq,content:content},
		success : function(data) {
			replyOnOff(seq);
			$("#replytext").val("");
			eReplyList(1);
			alert("댓글이 등록되었습니다");
			 $(".reply2").show();
		}
	});
}

//댓글 수정클릭
function upReply(seq,rno) {
	var replytext=$("#upRe"+rno).text();
	$("#caRE"+rno).show();
	$("#upbt"+rno).html("완료");
	$("#upRe"+rno).text("");
	$("#upRe"+rno).append("<input id='upre' type='text' size='90' value='"+replytext+"'/>");
	$("#upbt"+rno).attr("onclick","upRe("+seq+","+rno+")");
	$("#caRE"+rno).attr("onclick","caRE("+rno+",'sj:"+replytext+"')");
}
//댓글 수정
function upRe(seq,rno) {
	var content = $("#upre").val();
	
	$.ajax({
		type:'POST',
		url:'eReplyUpdate.do',
		data:{rno:rno,content:content},
		success : function(data) {
			eReplyList(1);
		}
	});
}

//댓글 수정 취소
function caRE(rno,content) {
	var replyt=content.substring(3);
	$("#caRE"+rno).hide();
	$("#upRe"+rno).children().remove();
	$("#upRe"+rno).text(replyt);
	$("#upbt"+rno).html("수정");
}

//댓글 삭제
function deRE(seq,rno) {
	$.ajax({
		type:'POST',
		url:'eReplyDelete.do',
		data:{rno:rno},
		success : function(data) {
			eReplyList(1);
		}
	});
}

/*창닫기*/
function windowClose() {
	window.close();
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