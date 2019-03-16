<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>카카오페이</title>
    <meta charset="utf-8">
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
	<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
	<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script> <!-- 아임포트를 사용한 카카오 페이 -->
</head>
<body>

<input type="hidden" id="email" name="email" value="${member.email}"/>
<input type="hidden" id="name" name="name" value="${member.name}"/>
<input type="hidden" id="phone" name="phone" value="${member.phone}"/>

<script>

var roomname=$(opener.document).find("#roomName").val();
var payamount=$(opener.document).find("#payAmount").val();
var branchName=$(opener.document).find("#branchName").val();
var email=$("#email").val();
var name=$("#name").val();
var phone=$("#phone").val();
var item=branchName+" "+roomname;

IMP.init('imp55565811'); 

IMP.request_pay({
    pg : 'kakaopay',
    pay_method : 'card',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : item, //아이템 명
    amount : payamount, //총결제 금액
    buyer_email : email, //구매자 이메일
    buyer_name : name, //id
    buyer_tel : phone, //번호
    company : '달빛 스터디카페'+branchName //지점명
}, function(rsp) {
    if ( rsp.success ) {
    	//alert(rsp.receipt_url);
        $(opener.document).find("#imp_uid").val(rsp.imp_uid);
        $(opener.document).find("#merchant_uid").val(rsp.merchant_uid);
        $(opener.document).find("#paid_ats").val(rsp.paid_at);
        $(opener.document).find("#receipt_url").val(rsp.receipt_url);
        $(opener.document).find("#pg_provider").val(rsp.pg_provider);
        $(opener.document).find("#pg_tid").val(rsp.pg_tid);
        $(opener.document).find("#status").val(1);
 	   	window.close();
 	   	
 	   $(opener.document).find("#theForm").attr("action","mypage.udo?").submit();
  	 	alert("결제가 성공적으로 이루어졌습니다", {
            icon: "success"
        });	
  	 	
    } else {
		var msg = '결제에 실패하였습니다.';              
        alert(msg);             	
     	window.close();
    }
});
</script>
</body>
</html>
