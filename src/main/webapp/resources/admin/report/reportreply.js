function insertReportReply(seq){
	console.log(seq+"너 뭐야");
	var reply=$("#replytx").val();
	if(seq==undefined){
		seq=$("#seqid").val();
	}
	$.ajax({
		type : 'POST',
		url : 'insertReportReply.do',
		data : {seq:seq,reply:reply,type:'admin'},
		success : function(){
			getReportReply(seq);
			$("#replytx").val("");
		}
	});
}
	

function getReportReply(seq){
	$.ajax({
		type : 'POST',
		url : 'getReportReply.do',
		data : {seq:seq},
		success : function(data) {
			$("#replylist tbody").children().remove();
			if(data.length==0){
				$("#replylist tbody").append('<td style="width:710px; height:auto; text-align:center; border-bottom:1px solid gray;">현재 댓글이 없습니다.</td>"');
				return;
			}
			var dom='';
			for(i=0; i<data.length; i++){
				$("#replylist thead").append("<input type='hidden' value="+data[i].seq+" id='seqid'/>");
				dom+='<tr><td style="width:710px; height:auto; align:top; border-bottom:1px solid gray;">';
				if(data[i].branchname=='본점'){
					dom+='<b>[관리자]</b> '+data[i].regdate+'<br/>';
					dom+='<p id="rp'+data[i].seq+'">'+data[i].reply+'</p><br/> <input id="rpbtn'+data[i].seq+'" type="button" onclick="updatReportReplying('+seq+','+data[i].seq+')" value="수정"/> <input hidden="true" id="crubtn" type="button" onclick="cancleReplyUpdate()" value="수정취소"/> <input type="button" onclick="deleteReportReply('+seq+','+data[i].seq+')" value="삭제"/>';
				}
				if(data[i].branchname!='본점'){
					dom+='&emsp;> <b>'+data[i].branchname+'</b> '+data[i].regdate+'<br/>';
					dom+='<p id="rp'+data[i].seq+'">&emsp;&emsp;'+data[i].reply+'</p><br/> <input id="rpbtn'+data[i].seq+'" type="button" onclick="updatReportReplying('+seq+','+data[i].seq+')" value="수정"/> <input hidden="true" id="crubtn" type="button" onclick="cancleReplyUpdate()" value="수정취소"/> <input type="button" onclick="deleteReportReply('+seq+','+data[i].seq+')" value="삭제"/>';
				}
				dom+='</td></tr>';
			}
					
			$("#replylist tbody").append(dom);
		}
	});
}
function updatReportReplying(seq,dseq){
	$("#crubtn").show();
	var reple=$("#rp"+dseq).text();
	$("#rp"+dseq).text("");
	$("#rp"+dseq).append("<textarea id='rptx' cols='92' rows='5'>"+reple+"</textarea>");
	//rpbtn
	$("#rpbtn"+dseq).val("수정 완료");
	$("#rpbtn"+dseq).attr("onclick","updateReportReply("+seq+","+dseq+")");
	$("#crubtn").attr("onclick","cancleReplyUpdate("+dseq+",'sj:"+reple+"')");
}
function cancleReplyUpdate(dseq,reple){
	var reple=reple.substring(3);
	$("#crubtn").hide();
	$("#rp"+dseq).children().remove();
	$("#rp"+dseq).text(reple);
	$("#rpbtn"+dseq).val("수정");
}

//댓글 수정
function updateReportReply(seq,dseq){
	var reply=$("#rptx").val();
	$.ajax({
		type : 'POST',
		url : 'updateReportReply.do',
		data : {seq:dseq,reply:reply},
		success : function(){
			getReportReply(seq);
		}
	});
}
//댓글 삭제
function deleteReportReply(seq,dseq){
	$.ajax({
		type : 'POST',
		url : 'deleteReportReply.do',
		data : {seq:dseq},
		success : function(){
			getReportReply(seq);

		}
	});
} 