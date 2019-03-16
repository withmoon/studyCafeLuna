$(function() {
	inquireList(1);
});

//문의계시판
function inquireList(inpage) {
	var searchOption=$("#searchSel option:selected").val();
	var keyword=$("#keyword").val();
	$.ajax({     
		 type:"GET",  
		 url:"inquireList.ado",    
	     data:{curPage:inpage,searchOption:searchOption,keyword:keyword},      
	     success:function(data){
	    	 $("#inquire_table").children().remove();
	    	 var inqui = '';
	    	 
	    	 //alert(data.inquireList.length);
	    	 for(var i=0; i<data.inquireList.length; i++){
	    		 
	    		 var regdate = new Date(data.inquireList[i].regdate);
	    		 var regdateFormat = regdate.toISOString().slice(2,10);
	    		 if(data.inquireList[i].mail==0){
	    			 inqui += '<tr>';
	    		 }
	    		 if(data.inquireList[i].mail==1){
	    			 inqui += '<tr style="color:lightgray">';
	    		 }
	    		 inqui += '<td>'+data.inquireList[i].seq+'</td>';
	    		 inqui += '<td>'+data.inquireList[i].id+'</td>';
	    		 inqui += '<td>'+data.inquireList[i].title+'</td>';
	    		 inqui += '<td>'+data.inquireList[i].branchName+'</td>';
	    		 inqui += '<td>'+regdateFormat+'</td>';
	    		 inqui += '<td><a href="javascript:showUserContent('+data.inquireList[i].seq+',&#039sj:'+data.inquireList[i].title+'&#039,&#039sj:'+data.inquireList[i].content+'&#039,&#039sj:'+data.inquireList[i].reply+'&#039)">열람</a> <a href="javascript:inquiredelete('+data.inquireList[i].seq+')">삭제</a></td>';
	    		 inqui += '</tr>';
	    	 }
	    	 
	    	 $("#inquire_table").append(inqui);    	 
	    	 blockPage("inquirePaging",inpage,data.inquirePage.BLOCK_SCALE,data.inquirePage.totPage,"inquireP","inquireList");
	     }
	});
}
//열람 클릭시 내용 보여주기
function showUserContent(seq,title,content,reply){
	var tt=title.substring(3);
	var ct=content.substring(3);
	var rp=reply.substring(3);
	$("#title").text(tt);
	$("#content").text(ct);
	if(rp==undefined||rp==''||rp=='null'){
		$("#reple").text("아직 답변이 없습니다.");
		$(".writeDiv").show();
		$("#sendBtn").attr("onclick","replyToUser("+seq+")");
		return;
	}
	if(rp!=undefined&&rp!=''){
		$("#reple").text(">"+rp);
		$(".writeDiv").show();
		$("#sendBtn").attr("onclick","replyToUser("+seq+")");
		return;
	}
	
}

//가리기
function hideWriteDiv(){
	$(".writeDiv").hide();
}

//답변하기 클릭 --추후 생성
function showWriteDiv(){
	
}
//답장 완료 --추후 생성
function replyToUser(seq){
	alert(seq);
}
//삭제
function inquiredelete(seq){
	$.ajax({     
		 type:"GET",  
		 url:"inquiredelete.ado",    
	     data:{seq:seq},      
	     success:function(data){
	    	 inquireList(1);
	     }
	});
}