function showUpdateForm(){
	$('body > *:not(#upInfo) ').css('filter',filterVal10);
	$("#upInfo").display="";
	$("#upInfo").show();
}
function hideUpdateForm(){
	$('body > *:not(#upInfo) ').css('filter',filterVal0);
	$("#upInfo").hide();
}
var stat=0;
function inputCheck() {	
	
	var sub=$("#id").val();
	
	if(sub.substring(0,2)=="k#"){
		alert("사용할수 없는 아이디입니다.");
		$("#id").focus();
		return false;
	}
	
	
	
	var regExphone = /^\d{3}-\d{3,4}-\d{4}$/;
	var tel=$("#phone").val();
	
	if(!regExphone.test(tel)){
		alert("원활할 예약을 위해 적절한 전화번호를 입력해주세요");
		$("#phone").focus();
		return false;
	}
	
	var regExpbirth = /^[0-9]+$/;
	
	var birth=$("#birth").val();

	if(!regExpbirth.test(birth)){
		alert("생일에 숫자만 입력해주세요");
		$("#birth").focus();
		return false;
	}
	
	var str = $("#email").val();
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
	
	if (!(atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1&& commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize)){
		alert("E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!");
		$("#email").focus();
		return false;
	}
	
	if($("#pw").val()!=''){
		if ($("#repw").val()=='') {
			$("#repw").focus();
			alert("확인용 비밀번호를 입력해주세요");
			return false;
		}
		if ($("#pw").val() != $("#repw").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#repw").focus();
			return false;
		}
		$("#update").attr("action","mypage.udo?stat=1").submit();
		
	}else{
		$("#update").attr("action","mypage.udo?stat=2").submit();
		
	}
	
}
