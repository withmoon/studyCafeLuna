//리포트 보내기
function changeContent(){
	     
	if(document.getElementsByName('title')[0].value==""){
		alert("제목이 입력되지않았습니다");
		document.getElementsByName('title')[0].focus();
		return false;
	}else if(ctt.value==""){
		alert("내용이 없습니다.");
		ctt.focus();
		return false;
	}else if(document.getElementsByName('startdate')[0].value==""){
		alert("이벤트 시작일을 설정해주세요");
		document.getElementsByName('startdate')[0].focus();
		return false;
	}else if(document.getElementsByName('enddate')[0].value==""){
		alert("이벤트 종료일을 설정해주세요");
		document.getElementsByName('enddate')[0].focus();
		return false;
	}else if(image.value==""){
		alert("이미지를 지정해주세요");
		image.focus();
		return false;
	}
	
	$("#content").val($("#ctt").val());
	
	alert("등록되었습니다.");
	return true;
	
	
}