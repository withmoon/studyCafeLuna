var num = getParameterByName('num');

$(function() {
	nReplyList(1);
});

function replyOnOff(num) {
	 if($(".reply2").css("display") == "none"){
		 $(".reply2").show();
			
		 nReplyList(1);
	 } else{
		 $(".reply2").hide();
	 }
}

//댓글 목록
function nReplyList(nrpage) {
	$.ajax({
		type:"GET",
		url:"nReplyList.udo",
		data: {num:num,curPage:nrpage},
		success : function(data) {
			$('.replyList').children().remove();
			var nreply='';
			if(data.nReplyList.length==0) {
				nreply += '<div class="rbox"><p>댓글이 없어요... 남겨주시면 힘이 됩니다...</p></div>';
				$('.replyList').append(nreply);
				return;
			}
			if(data.nReplyList.length!=0) {
				for(var i=0; i<data.nReplyList.length; i++) {
					var regdate = new Date(data.nReplyList[i].regdate);
					var regdateFormat = regdate.toISOString().slice(2,10);
					nreply += '<div class="rbox">작성자 : '+data.nReplyList[i].replyer+'</br>작성날짜 : '+regdateFormat+'<br/>';
					nreply += '<label id="upRe'+data.nReplyList[i].rno+'">'+data.nReplyList[i].replytext+'</label>';	
					if(data.userid == data.nReplyList[i].replyer) {
						nreply += '<span><button id="upbt'+data.nReplyList[i].rno+'" onclick="upReply('+num+','+data.nReplyList[i].rno+')">수정</button> ';
						nreply += '<button hidden="true" id="caRE'+data.nReplyList[i].rno+'" onclick="caRE()">취소</button> ';
						nreply += '<button onclick="deRE('+num+','+data.nReplyList[i].rno+')">삭제</button></span>';
					}
					
					nreply += '</div>';
				}
				$('.replyList').append(nreply);
				console.log(data.nReplyPage.BLOCK_SCALE+ " " +nrpage+" " +data.nReplyPage.totPage);
				blockPage("replyPaging",nrpage,data.nReplyPage.BLOCK_SCALE,data.nReplyPage.totPage,"reli","nReplyList");
			}
		}
	});
}

//댓글 등록
function writeCommand(num){
	var content=$("#replytext").val();
	
	$.ajax({
		type:"POST",
		url:"nReplyInsert.udo",
		data: {bnum:num,content:content},
		success : function(data) {
			replyOnOff(num);
			$("#replytext").val("");
			nReplyList(1);
			alert("댓글이 등록되었습니다");
			 $(".reply2").show();
		}
	});
}

//댓글 수정클릭
function upReply(num,rno) {
	var replytext=$("#upRe"+rno).text();
	$("#caRE"+rno).show();
	$("#upbt"+rno).html("완료");
	$("#upRe"+rno).text("");
	$("#upRe"+rno).append("<input id='upre' type='text' size='90' value='"+replytext+"'/>");
	$("#upbt"+rno).attr("onclick","upRe("+num+","+rno+")");
	$("#caRE"+rno).attr("onclick","caRE("+rno+",'sj:"+replytext+"')");
}

//댓글 수정
function upRe(num,rno) {
	var content = $("#upre").val();
	
	$.ajax({
		type:'POST',
		url:'nReplyUpdate.udo',
		data:{rno:rno,content:content},
		success : function(data) {
			nReplyList(1);
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
function deRE(num,rno) {
	$.ajax({
		type:'POST',
		url:'nReplyDelete.udo',
		data:{rno:rno},
		success : function(data) {
			nReplyList(1);
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