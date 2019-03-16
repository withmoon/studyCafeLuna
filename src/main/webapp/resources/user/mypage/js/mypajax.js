var cancleSt=0;
var imp_uid="";
var filterVal10 = 'blur(10px)';
var filterVal0 = 'blur(0px)';
var alamseq='';
function goToQandA(){
	scrollDown(".ntlnon");
}
//환불 요청 ajax 
function cancleReserve(imp){
	imp_uid=imp;
	$('body > *:not(.ccReserDiv) ').css('filter',filterVal10);
	$(".ccReserDiv").display="";
	$(".ccReserDiv").show();
	
}
//환불하시겠습니까?
function goCancle(){
	gogoCC(imp_uid);
	$('body > *:not(.ccReserDiv) ').css('filter',filterVal0);
}

function noCancle(){
	$(".ccReserDiv").hide();
	$('body > *:not(.ccReserDiv) ').css('filter',filterVal0);
}
function gogoCC(imp_uid){
	$.ajax({      
		type:"POST",  
		url:"cancleReserve.udo",    
		data:{imp_uid:imp_uid},     
		success:function(data){
			$("#"+imp_uid).children().remove();
			var stdom="<label>환불요청중</label>";
			$("#"+imp_uid).append(stdom);
			noCancle();
			alert("환불 요청이 완료되었습니다");
		}
	});
}
/*환불완료 확인완료*/
function confirmCancle(seq){
	$.ajax({      
		type:"POST",  
		url:"readalam.udo",    
		data:{seq:seq},     
		success:function(){
			$("#conf"+seq).remove();
			readTd(seq);
		}
	});
}
/*else 내용 열기*/
function openElse(seq,content,fromwhat){
	alamseq=seq;
	$('body > *:not(.showElse) ').css('filter',filterVal10);
	
	$("#elsett").val(content);
	$("#elsect").val(fromwhat);
	
	$(".showElse").display="";
	$(".showElse").show();
	
	$.ajax({      
		type:"POST",  
		url:"readalam.udo",    
		data:{seq:seq},     
		success:function(){
			readTd(seq);
		}
	});
}
function readTd(seq){
	$(".conf"+seq).css({"color":"gray"});
}
function closeElse(){
	$(".showElse").hide();
	$('body > *:not(.showElse) ').css('filter',filterVal0);
}