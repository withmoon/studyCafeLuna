var formnum=0;
//글쓰기 폼
function showWriteForm(){
	$("#listForm").hide();
	$("#writeForm").show();
}
//글쓰기 취소
function cancleWrite(){
	$(".formtx").val("");
	$("#listForm").show();
	for(var i=1; i<formnum+1; i++){
		$(".form"+i).remove();
	}
	$("#writeForm").hide();
}
//글쓰기 폼 추가
function addWriteForm(){
	formnum++;
	var addDom='';
	addDom+='<tr class="form'+formnum+'"><th>내용:</th>';
	addDom+='<td><textarea id="content'+formnum+'" name="content'+formnum+'" cols="110" rows="5"></textarea></td>';
	addDom+='<td align="center" rowspan="2"><input type="button"  onclick="addWriteForm()" value="추가"/><br/>';
	addDom+='<input type="button"  onclick="delWriteForm('+formnum+')" value="삭제"/></td>';
	addDom+='</tr> <tr class="form'+formnum+'"> <th>파일:</th>';
	addDom+='<td><input type="file" name="file" placeholder="file" id="file" value="file" class="form-control" ></td> </tr>';
   $("#writeForm table tbody").append(addDom);
}
//write중 삭제 클릭시
function delWriteForm(formnum){
	$(".form"+formnum).remove();
}
//값 세팅
function setVal(){
	if(document.getElementsByName('title')[0].value==""){
		alert("제목을 입력해주세요");
		document.getElementsByName('title')[0].focus();
		return false;
	}else if(document.getElementsByName('content0')[0].value==""){
		alert("내용을 입력해주세요");
		document.getElementsByName('content0')[0].focus();
		return false;
	}else if($("#file").value=""){
		alert("이미지를 설정해주세요");
		$("#file").focus();
		return false;
	}
	
	alert("??");
	$("#maxCnum").val(formnum);
	return false;
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
			$("#imgsum").attr("src",i.target.result);
		}
		reader.readAsDataURL(f);
	});
	
}