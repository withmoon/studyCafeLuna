var filterVal10 = 'blur(10px)';
var filterVal0 = 'blur(0px)';
var emails='';
var ids='';
var count=0;
var startdex=0;
$(function(){
	getAdminList();
});
function addAdmin(){
	var id=$("#id").val(); //중복확인
	var pw=$("#pw").val(); 
	var name=$("#name").val();
	var phone=$("#phone").val();
	var email=$("#email").val();
	
	$.ajax({      
		type:"POST",  
		url:"insertAdmin.do",    
		data:{id:id,pw:pw,name:name,phone:phone,email:email},     
		success:function(res){
			alert("관리자 추가가 완료되었습니다.");
			hidenAddForm('addForm');
			getAdminList();
		}
	});
}
function getAdminList(){
	$.ajax({      
		type:"POST",  
		url:"getAdminList.do",    
		success:function(res){
			$("#admintb tbody").children().remove();
			var dom='';
			if(res.length==0){
				dom+='<tr><td colspan="7">현재 추가된 어드민이 없습니다.</td></tr>';
			}
			for(var i=0; i<res.length; i++){
				if(res[i].position=='총관리자'){
					$("#myid").val(res[i].id);
					$("#myname").val(res[i].name);
					$("#myphone").val(res[i].phone);
					$("#myemail").val(res[i].email);
				}
				if(res[i].position=='관리자'){
					if(count==0){
						startdex=i;
					}
					count++;
					dom += '<tr><td><input type="checkbox" name="checkRow" class="chkbox" id="chkseq'+i+'" value="'+res[i].id+';'+res[i].email+'" onclick="attachUserInfo(&#039'+res[i].id+'&#039,&#039'+res[i].email+'&#039,'+i+')"/></td>';
					dom+='<td>'+res[i].id+'</td>';
					dom+='<td>'+res[i].name+'</td>';
					dom+='<td>'+res[i].phone+'</td>';
					dom+='<td>'+res[i].email+'</td>';
					dom+='<td>'+res[i].regdate+'</td>';
					dom+='<td><input type="button" onclick="showUpForm(&#039'+res[i].id+'&#039,&#039'+res[i].name+'&#039,&#039sj:'+res[i].phone+'&#039,&#039sj:'+res[i].email+'&#039)" value="수정">&emsp; ';
					dom+='<input type="button" onclick="deleteAdmin(&#039'+res[i].id+'&#039)" value="삭제"></td><tr>';
				}
			}
			$("#admintb tbody").append(dom);
		}
	});
}
function deleteAdmin(id){
	if(confirm(id+"님을 정말로 삭제하시겠습니까?")){
		$.ajax({      
			type:"POST",  
			url:"deleteAdmin.do",  
			data:{id:id},
			success:function(res){
				alert("성공적으로 삭제되었습니다.");
				 getAdminList();
			}
		});
	}
}
function showUpForm(id,name,phone,email){
	var ph=phone.substring(3);
	var em=email.substring(3);
	$("#infoForm").show();
	$("#adid").val(id);
	$("#adname").val(name);
	$("#adphone").val(ph);
	$("#ademail").val(em);
	
	$("#adsujung").attr("onclick","updateAdmin()");
}
function updateAdmin(id,name,phone,email){
	var id=$("#adid").val();
	var pw=$("#adpw").val();
	var name=$("#adname").val();
	var phone=$("#adphone").val();
	var email=$("#ademail").val();
	$.ajax({      
		type:"POST",  
		url:"updateAdmin.do",  
		data:{id:id,pw:pw,name:name,phone:phone,email:email},
		success:function(res){
			alert("성공적으로 수정되었습니다.");
			 noUpdateAdmin();
			 getAdminList();
		}
	});
}
function updateMyAdmin(){
	var id=$("#myid").val();
	var pw=$("#mypw").val();
	var name=$("#myname").val();
	var phone=$("#myphone").val();
	var email=$("#myemail").val();
	$.ajax({      
		type:"POST",  
		url:"updateAdmin.do",  
		data:{id:id,pw:pw,name:name,phone:phone,email:email},
		success:function(res){
			alert("성공적으로 수정되었습니다.");
			 noUpdateAdmin();
			 hidemyForm();
		}
	});
}
function hidemyForm(){
	$("#myForm").hide();
}
function noUpdateAdmin(){
	$("#infoForm").hide();
}

function hidenAddForm(form){
	$("#"+form).hide();
}

function showAddFom(){
	$("#addForm").show();
}
function showMyFom(){
	$("#myForm").show();
}




//체크박스 누를시
function attachUserInfo(id,email,i){
	 $(".cendmBtn").children().remove();
	 if( $("#chkseq"+i).is(':checked') ){
		 emails+=email+";";
		 ids+=id+";";
		 $(".cendmBtn").append("<p>"+ids+"</p>");
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
	     for(i=startdex; i <$("input[name=checkRow]").prop("checked", true).length+1; i++) {
	    	 var idsplit=$("#chkseq"+i).val().split(";");
	    	 ids+=idsplit[0]+";";
	    	 emails+=idsplit[1]+";";
	  	 }
	     $(".cendmBtn").children().remove();
	     $(".cendmBtn").append("<p>"+ids+"</p>");
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
	$(".explur").show();
	$(".emailcontents").show();
	
}
//내용작성 후 메일 보내기
function sendEmail(){
	$("#type").val("admininfo");
	$("#ids").val(ids);
	$("#ems").val(emails);
}

function cancleExplur(){
	$(".explur").hide();
}
