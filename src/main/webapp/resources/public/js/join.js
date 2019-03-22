$(window).load(function() {
	$("td").val("");
	$("input").focusout(function() {
		if ($(this).val() != "") {
			$(this).addClass("has-content");
		} else {
			$(this).removeClass("has-content");
		}
	});
});
$(document).ready(function() {
	$("#branchimgf").on("change",ImgFileSelect);
});

 /*메인이미지 썸네일*/
function ImgFileSelect(i) {
	var files = i.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	filesArr.forEach(function(f) {
		if(!f.type.match("image.*")){
			alert("확장자는 이미지만 가능합니다."); 
			return;
		}
		
		sel_file = f;
		
		var reader = new FileReader();
		reader.onload = function(i) {
			$("#imgsum").attr("src",i.target.result);
		}
		reader.readAsDataURL(f);
	});
	
}

function isbranch(){
	var url='join.do?br=on';
	window.location=url;
}
function isMem(){
	var url='join.do?br=off';
	window.location=url;
}

function idCheck(){
	var id=$("#id").val();
	if (id=='') {
		alert("아이디를 입력해 주세요.");
		$("#id").focus();
		return;
	}
	if(id.substring(0,2)=="k#"){
		alert("사용할수 없는 아이디입니다.");
		$("#id").focus();
		return;
	}
	if(id!=''){
		 var idReg =  /^[a-z]+[a-z0-9]{0,19}$/g;
	        if(!idReg.test(id)) {
	            alert("아이디는 영문자와 숫자함께 입력 해주셔야합니다.");
	            return;
	        }
	}
		alert("왜 안오냐");
		var popupX = (window.screen.width / 2) - (200 / 2);
		var popupY= (window.screen.height /2) - (300 / 2);
		
		/* post */
		var form = document.createElement("form");
		url="join/idCheck.do";
		window.open("","form",'status=no, width=200,height=10,left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
		
		form.method="post";
		form.action=url;
		form.target="form";
		var input = document.createElement('input');
		input.type = 'hidden';
		input.name = 'id';
		input.value = id;
		form.appendChild(input);
		document.body.appendChild(form);
		
		form.submit();
		
		document.body.removeChild(form);

}

function inputCheck() {	
	
	var sub=$("#id").val();
	
	if(sub.substring(0,2)=="k#"){
		alert("사용할수 없는 아이디입니다.");
		$("#id").focus();
		return false;
	}
	
	if(sub!=''){
		 var idReg = /^[a-z]+[a-z0-9]$/g;
	        if(!idReg.test(sub)) {
	            alert("아이디는 영문자와 숫자만 입력 가능합니다.");
	            return false;
	        }
	}
	
	if ($("#pw").val() != $("#repw").val()) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#repw").focus();
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
	if(birth.length!=6){
		alert("생일은 6자리 형식으로 입력해주세요 [ 입력예시 : 820127 ] ");
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
	
	$("join").submit();
}
