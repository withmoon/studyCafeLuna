var formnum=0;
$(function(){
	formnum=$("#size").val();
});
var count=0;
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
	addDom+='<td align="center" rowspan="2">';
	addDom+='<input type="button"  onclick="delWriteForm('+formnum+')" value="삭제"/></td>';
	addDom+='</tr> <tr class="form'+formnum+'"> <th>파일:</th>';
	addDom+='<td><input type="file" name="file" placeholder="file" id="file" value="file" class="form-control" ></td> </tr>';
 $("#writeForm table tbody").append(addDom);
}
//write중 삭제 클릭시
function delWriteForm(cnum,num){
	if(num==undefined){
		formnum--;
		$(".form"+cnum).remove();
	}
	if(num!=undefined){
		if(confirm("정말로 삭제하시겠습니까?")){
			$.ajax({      
				type:"POST",  
				url:"deleteHowToUseContent.do",
				data:{num:num,cnum:cnum},
				success:function(){
					alert('성공적으로 삭제되었습니다.');
					location.reload();
				}
			});
		}
	}
}

//값 세팅
function setVal(){
	$("#maxCnum").val(formnum);
}
//수정 들어감
function updating(){
	$(".imgBtns").show();
	$(".formtx").removeAttr("disabled");
	$("#addForm").show();
	$("#upBtn").val("수정완료");
	$("#upBtn").attr("onclick","updateContent()");
	$("#upcnBtn").show();
}
//수정 취소
function cancleUp(){
	$(".imgBtns").hide();
	$("#upcnBtn").hide();
	$("#addForm").hide();
	$(".formtx").attr("disabled","disabled");
	$("#upBtn").val("수정하기");
	$("#upBtn").attr("onclick","updating()");
}
//실제 없데이트 처리
function updateContent(){
	$("#maxCnum").val(formnum);
	$("#form").removeAttr("action");
	$("#form").attr("action","updateHowToUse.do");
	$("#form").submit();
}
//이미지 수정
function updateImg(cnum,num){
	$("#fimg"+cnum+" #file").display='';
	$("#fimg"+cnum+" img").hide();
	$("#fimg"+cnum+" #file").show();
	$("#imgCcBtn"+cnum).show();
	$("#upim"+cnum).hide();
}
//이미지 수정 완료
function updateimg(cnum,num){
	
}

//이미지 수정 취소
function cancleUpImg(cnum){
	$("#upim"+cnum).show();
	$("#fimg"+cnum+" img").show();
	$("#fimg"+cnum+" #file").hide();
	$("#imgCcBtn"+cnum).hide();
}