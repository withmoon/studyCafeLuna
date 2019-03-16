var sel_file;


$(document).ready(function() {
	document.getElementById("img2").style.display="block"; 
	document.getElementById("img3").style.display="block"; 
	document.getElementById("img4").style.display="block"; 
	document.getElementById("img5").style.display="block"; 
	
	$("#input_img").on("change",ImgFileSelect);
	$("#input_img2").on("change",Img2FileSelect);
	$("#input_img3").on("change",Img3FileSelect);
	$("#input_img4").on("change",Img4FileSelect);
	$("#input_img5").on("change",Img5FileSelect);

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
