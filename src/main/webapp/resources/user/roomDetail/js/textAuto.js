$(document).ready(function(){
	var textEle1 = $('.etx1');
	textEle1[0].style.height = 'auto';
	var textEleHeight = textEle1.prop('scrollHeight');
	textEle1.css('height', textEleHeight);
	
	var textEle2 = $('.etx2');
	textEle2[0].style.height = 'auto';
	var textEleHeight = textEle2.prop('scrollHeight');
	textEle2.css('height', textEleHeight);
	
	var textEle3 = $('.etx3');
	textEle3[0].style.height = 'auto';
	var textEleHeight = textEle3.prop('scrollHeight');
	textEle3.css('height', textEleHeight);
});
function rivDown(pnum){
	 var offset = $("." + pnum).offset();
     $('html, body').animate({scrollTop : offset.top}, 400);
}