//<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('da37e5836c002230d358ce5af57a57ca');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {

        Kakao.API.request({
            url: '/v2/user/me',
            success: function(res) {
            	
            	$("input[name=kid]").val(res.id);
            	$("input[name=knic]").val(res.properties.nickname);
            	
            	kform.submit();

            },
      fail: function(err) {
         alert(JSON.stringify(err));
      }
        });
      },
      fail: function(err) {
       alert(JSON.stringify(err));
      }
    });
// ]]>
    
function findId(){
	$(".findDiv").show();
	$("#sendMail").attr("onclick","sendId()");	
}

function findPW(){
	$(".findDiv").show();
	$("#idtd").show();
	$("#sendMail").attr("onclick","sendpw()");	
}
//아이디 발송
function sendId(){
	var name=$("#nmt").val();
	var email=$("#emt").val(); 
	$.ajax({      
		type:"POST",  
		url:"sendFindthing.do",    
		data:{name:name,email:email},     
		success:function(res){
			if(res.fail=='true'){
				alert("조회하신 정보에 대한 결과가 없습니다.");
				cancleFind();
				return;
			}
			alert("아이디가 메일로 발송 되었습니다^^");
			cancleFind();
		}
	});	
}
//비번 발송
function sendpw(){
	var name=$("#nmt").val();
	var email=$("#emt").val(); 
	var id=$("#idt").val();
	$.ajax({      
		type:"POST",  
		url:"sendFindthing.do",    
		data:{name:name,email:email,id:id},     
		success:function(res){
			if(res.fail=='true'){
				alert("조회하신 정보에 대한 결과가 없습니다.");
				cancleFind();
				return;
			}
			alert("임시 비밀번호가 발송 되었습니다^^ 받으신 비밀번호를 입력 후 마이페이지에서 수정해주세요^^");
			cancleFind();
		}
	});	
}

function cancleFind(){
	$("#idt").val("");
	$("#nmt").val("");
	$("#emt").val("");
	$(".findDiv").hide();
	$("#idtd").hide();
}