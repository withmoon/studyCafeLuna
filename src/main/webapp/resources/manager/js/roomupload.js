var sel_file;

$(document).ready(function() {
	$("#input_img").on("change",ImgFileSelect);
	$("#input_img2").on("change",Img2FileSelect);
	$("#input_img3").on("change",Img3FileSelect);
	$("#input_img4").on("change",Img4FileSelect);
	$("#input_img5").on("change",Img5FileSelect);
});

function check(){
	theForm = document.form;
	
	if(theForm.roomnum.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.roomnum.focus();
		}
	if(theForm.branchName.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.branchName.focus();
		}
	if(theForm.roomName.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");  
		return theForm.roomName.focus();
		}
	if(theForm.Price.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.Price.focus();
	}
	if(theForm.roomLocate.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.roomLocate.focus();
	}
	if(theForm.roomEx1.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.roomEx1.focus();
	}
	if(theForm.roomEx2.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.roomEx2.focus();
	}
	if(theForm.roomEx3.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.roomEx3.focus();
	}
	if(theForm.roomEx4.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.roomEx4.focus();
	}
	if(theForm.roomExplain.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.roomExplain.focus();
	}
	if(theForm.roomWarn.value==""){
		alert("해당 필드값이 입력되지 않았습니다.");
		return theForm.roomWarn.focus();
	}
	if(theForm.img.value==""){
		alert("이미지 전부 업로드 하지 않으셨습니다.");
		return 
	}
	if(theForm.input_img1.value==""){
		alert("이미지1 전부 업로드 하지 않으셨습니다.");
		return 
	}
	if(theForm.input_img2.value==""){
		alert("이미지2 전부 업로드 하지 않으셨습니다.");
		return 
	}
	if(theForm.input_img3.value==""){
		alert("이미지3 전부 업로드 하지 않으셨습니다.");
		return 
	}
	if(theForm.input_img4.value==""){
		alert("이미지4 전부 업로드 하지 않으셨습니다.");
		return
	}
	theForm.submit();
}


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
			$("#img").attr("src",i.target.result);
		}
		reader.readAsDataURL(f);
	});
	
}
/*이미지2~4*/
function Img2FileSelect(i) {
	document.getElementById("img2").style.display="block"; //이미지가 선택되서 나타나면 div 활성화
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
			$("#img2").attr("src",i.target.result);
		}
		reader.readAsDataURL(f);
	});
}
function Img3FileSelect(i) {
	document.getElementById("img3").style.display="block"; 
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
			$("#img3").attr("src",i.target.result);
		}
		reader.readAsDataURL(f);
	});
}
function Img4FileSelect(i) {
	document.getElementById("img4").style.display="block"; 
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
			$("#img4").attr("src",i.target.result);
		}
		reader.readAsDataURL(f);
	});
}
function Img5FileSelect(i) {
	document.getElementById("img5").style.display="block"; 
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
			$("#img5").attr("src",i.target.result);
		}
		reader.readAsDataURL(f);
	});
}
