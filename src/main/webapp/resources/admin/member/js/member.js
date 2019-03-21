var filterVal10 = 'blur(10px)';
var filterVal0 = 'blur(0px)';
var emails='';
var ids='';
$(function() {
	memberList(1);
	
	//회원
	$('.userinfo').click(function() {
		memberList(1);
	});
	
	//지점장
	$('.branchinfo').click(function() {
		infoList(1);
	});
});

//회원정보
function memberList(mpage) {
	
	$.ajax({     
		 type:"GET",  
		 url:"aMemberList.do",    
	     data:{curPage:mpage},      
	     success:function(data){
	    	 $(".table-striped").children().remove();
	    	 var mem = '';
	    	 
	    	 mem += '<tr>';
	    	 mem += '<th><input type="checkbox" id="allSeq" onclick="checkAll()"></th>';
	    	 mem += '<th>이름</th><th>아이디</th><th>전화번호</th><th>이메일</th><th>제명</th>';
    		 mem += '</tr>';
    		 
	    	 for(var i=0; i<data.memberList.length; i++){
	    		 mem += '<tr>';
	    		 mem += '<td><input type="checkbox" name="checkRow" class="chkbox" id="chkseq'+i+'" value="'+data.memberList[i].id+';'+data.memberList[i].email+'" onclick="attachUserInfo(&#039'+data.memberList[i].id+'&#039,&#039'+data.memberList[i].email+'&#039,'+i+')"/></td>';
	    		 mem += '<td>'+data.memberList[i].id+'</td>';
	    		 mem += '<td>'+data.memberList[i].name+'</td>';
	    		 mem += '<td>'+data.memberList[i].phone+'</td>';
	    		 mem += '<td>'+data.memberList[i].email+'</td>';
	    		 if(data.memberList[i].brStatus==0){
	    			 mem += '<td><input type="button" onclick="editContentExpulmember(&#039'+data.memberList[i].id+'&#039,&#039'+data.memberList[i].email+'&#039)" value="제명"></a></td>';
	    		 }
	    		 if(data.memberList[i].brStatus==-2){
	    			 mem+='<td><input type="button" onclick="cancleExplurUser(&#039'+data.memberList[i].id+'&#039,&#039'+data.memberList[i].email+'&#039)" value="제명 취소"></a></td>';
	    		 }
	    		 mem += '</tr>';
	    	 }
	    	 
	    	 $(".table-striped").append(mem)
	    	  ids='';
	    	 emails='';
	    	 $(".cendmBtn").children().remove();
	    	 blockPage("memberPaging",mpage,data.memberPage.BLOCK_SCALE,data.memberPage.totPage,"memberP","memberList");
	     }
	});
}
var keyword='';
var searchOption='';
//회원 검색
function AllmemberList(mpage) {
	
	keyword=$("#keyword").val();
	searchOption=$("#searchOption option:selected").val();
	$.ajax({     
		 type:"POST",  
		 url:"getAllMember.do",    
	     data:{curPage:mpage,keyword:keyword,searchOption:searchOption},      
	     success:function(data){
	    	 $(".table-striped").children().remove();
	    	 var mem = '';
	    	 
	    	 mem += '<tr>';
	    	 mem += '<th><input type="checkbox" id="allSeq" onclick="checkAll()"></th>';
	    	 mem += '<th>이름</th><th>아이디</th><th>전화번호</th><th>이메일</th><th>생일</th>';
  		 mem += '</tr>';
  		 
	    	 for(var i=0; i<data.memberList.length; i++){
	    		 mem += '<tr>';
	    		 mem += '<td><input type="checkbox" name="checkRow" class="chkbox" id="chkseq'+i+'" value="'+data.memberList[i].id+';'+data.memberList[i].email+';" onclick="attachUserInfo(&#039'+data.memberList[i].id+'&#039,&#039'+data.memberList[i].email+'&#039,'+i+')"/></td>';
	    		 mem += '<td>'+data.memberList[i].id+'</td>';
	    		 mem += '<td>'+data.memberList[i].name+'</td>';
	    		 mem += '<td>'+data.memberList[i].phone+'</td>';
	    		 mem += '<td>'+data.memberList[i].email+'</td>';
	    		 mem += '<td>'+data.memberList[i].birth+'</td>';
	    		 mem += '</tr>';
	    	 }
	    	 
	    	 $(".table-striped").append(mem)
	    	  ids='';
	    	 emails='';
	    	 $(".cendmBtn").children().remove();
	    	 blockPage("memberPaging",mpage,data.memberPage.BLOCK_SCALE,data.memberPage.totPage,"memberP","AllmemberList");
	     }
	});
}

//지점장정보
function infoList(ipage) {
 
	$.ajax({     
		 type:"GET",  
		 url:"infoList.do",    
	     data:{curPage:ipage},      
	     success:function(data){
	    	 $(".table-striped").children().remove();
	    	 var inf = '';

	    	 inf += '<tr>';
	    	 inf += '<th><input type="checkbox" id="allSeq" onclick="checkAll()"></th>';
	    	 inf += '<th>이름</th><th>아이디</th><th>전화번호</th><th>이메일</th><th>지점명</th>';
	    	 inf += '<th>주소</th><th>삭제</th>';
	    	 inf += '</tr>';
    		 
	    	 for(var i=0; i<data.infoList.length; i++){
	    		 inf += '<tr>';
	    		 inf += '<td><input type="checkbox" name="checkRow" class="chkbox" id="chkseq'+i+'" value="'+data.infoList[i].id+';'+data.infoList[i].email+'" onclick="attachUserInfo(&#039'+data.infoList[i].id+'&#039,&#039'+data.infoList[i].email+'&#039,'+i+')"/></td>';
	    		 inf += '<td>'+data.infoList[i].id+'</td>';
	    		 inf += '<td>'+data.infoList[i].name+'</td>';
	    		 inf += '<td>'+data.infoList[i].phone+'</td>';
	    		 inf += '<td>'+data.infoList[i].email+'</td>';
	    		 inf += '<td>'+data.infoList[i].branchName+'</td>';
	    		 inf += '<td>'+data.infoList[i].branchAddr1+'</td>';
	    		 inf += '<td><a href="approvedelete.do?id='+data.infoList[i].id+'&type=member">삭제</a></td>';
	    		 inf += '</tr>';
	    	 }
	    	 
	    	 $(".table-striped").append(inf);
	    	 ids='';
	    	 emails='';
	    	 $(".cendmBtn").children().remove();
	    	 blockPage("memberPaging",ipage,data.infoPage.BLOCK_SCALE,data.infoPage.totPage,"memberP","infoList");
	     }
	});
}

//제명 하겠다 내용을 띄워달라
function editContentExpulmember(id,email){
	$("#sangdan").text("제명 사유");
	$(".explur").show();
	$(".emailcontents").hide();
	$(".emailcontents").hide();
	if(confirm(id+"님의 계저을 제명 처리하시겠습니까?")){
	$('body > *:not(.explur) ').css('filter',filterVal10);
	$(".explur").show();
	$("#sendToUser").attr("type","button");
	$("#sendToUser").attr("onclick","expulmember('"+id+"','"+email+"')");
	}
}
//제명 취소
function cancleExplur(){
	$('body > *:not(.explur) ').css('filter',filterVal0);
	$(".explur").hide();
}
//제명 처리
function expulmember(id,email,title){
	var content=$("#excontent").val();

	$.ajax({     
		 type:"GET",  
		 url:"expulmember.do",    
	     data:{id:id,email:email,content:content,title:title},
	     success:function(){
	    	 alert(id+"님이 제명되었습니다.");
	    	 memberList(1);
	    	 cancleExplur();
	     }
	});
} 
//제명 처리
function cancleExplurUser(id,email){
	$.ajax({     
		 type:"GET",  
		 url:"expulmember.do",    
	     data:{id:id,email:email},
	     success:function(){
	    	 alert(id+"님의 제명이 취소되었습니다.");
	    	 memberList(1);
	     }
	});
}


//체크박스 누를시
function attachUserInfo(id,email,i){
	 $(".cendmBtn").children().remove();
	 if( $("#chkseq"+i).is(':checked') ){
		 emails+=email+";";
		 ids+=id+";";
		 $(".cendmBtn").append("<p>"+ids+"</p>");
		 console.log(ids+ "  rosdpr "+emails);
		 return;
	 }else{
		 var emsp=emails.split(email+";");
		 var idsp=ids.split(id+";");
		 ids=idsp[0]+""+idsp[1];
		 emails=emsp[0]+""+emsp[1];
		 $(".cendmBtn").append("<p>"+ids+"</p>");
		 return; 
	 }
}

//선택박스 모두 체크
function checkAll(){
	 if( $("#allSeq").is(':checked') ){
		 $("input[name=checkRow]").prop("checked", true);
		 ids='';
	     for(i=0; i <$("input[name=checkRow]").prop("checked", true).length; i++) {
	    	 var idsplit=$("#chkseq"+i).val().split(";");
	    	 ids+=idsplit[0]+";";
	    	 emails+=idsplit[1]+";";
	  	 }
	     $(".cendmBtn").children().remove();
	     $(".cendmBtn").append("<p>"+ids+"</p>");
	     console.log(ids+" " +emails);
	     return;
	 }else{
		  $(".cendmBtn").children().remove();
		  ids='';
		  emails='';
	     $("input[name=checkRow]").prop("checked", false);
	 }
}
//메일보내기 클릭
function sendEmailToMembers(){
	$("#sangdan").text("메일 보내기");
	$("#sendToUser").removeAttr("onclick");
	$("#sendToUser").attr("type","submit");
	$('body > *:not(.explur) ').css('filter',filterVal10);
	$(".explur").show();
	$(".emailcontents").show();
	
}
//내용작성 후 메일 보내기
function sendEmail(){
	$("#ids").val(ids);
	$("#ems").val(emails);
}

//========================================
	function AllMail(type) {

	$("#sangdan").text("메일 보내기");
	$("#type").val(type);
	
	console.log(type);
	
	$("#memform").removeAttr("action");//지워구 해도 되는건가요?
	$("#memform").attr("action","AllMail.do");//바뀌나..
	$("#sendToUser").removeAttr("onclick");
	$("#sendToUser").attr("type","submit");
	$('body > *:not(.explur) ').css('filter',filterVal10);
	$(".explur").show();
	$(".emailcontents").show();
	
}

