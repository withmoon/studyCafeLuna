
function manager() {
	var f = document.getElementById("logo");
	f.action = "/manager.do";
	f.method ="post";
	f.submit();
}


function showUpdateForm(){
//	$('body > *:not(#upInfo) ').css('filter',filterVal10);
	$("#upInfo").display="";
	$("#upInfo").show();
}
function hideUpdateForm(){
//	$('body > *:not(#upInfo) ').css('filter',filterVal0);
	$("#upInfo").hide();
}



