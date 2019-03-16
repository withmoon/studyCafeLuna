var num = getParameterByName('num');

$(function(){
	$(".nupdate").hide();
	nReplyList(1);
});

function upbt() {
	$(".nview").hide();
	$(".nupdate").show();
}

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
		url:"aGReplyList.ado",
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
					nreply += '<button onclick="deRE('+num+','+data.nReplyList[i].rno+')">삭제</button></span>';
					nreply += '</div>';
				}
				$('.replyList').append(nreply);
				console.log(data.nReplyPage.BLOCK_SCALE+ " " +nrpage+" " +data.nReplyPage.totPage);
				blockPage("replyPaging",nrpage,data.nReplyPage.BLOCK_SCALE,data.nReplyPage.totPage,"reli","nReplyList");
			}
		}
	});
}

//댓글 삭제
function deRE(num,rno) {
	$.ajax({
		type:'POST',
		url:'aGReplyDelete.ado',
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