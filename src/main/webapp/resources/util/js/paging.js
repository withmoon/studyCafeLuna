		//번호넣을 ul아이디,현재페이지번호,블럭제한수,페이지블럭갯수,생성될li의 아이디(아무거나),click시 콜백메서드
function blockPage(ulID,curpage,block_scale,totpage,liID,clickfuncname,param1,param2){
	$("#"+ulID).children().remove();
	var dom='';
	var startpage=((curpage%block_scale==0)? 
			curpage/block_scale:(Math.floor(curpage/block_scale)*block_scale)+1);
	//시작부터 블럭까지 돌림
	for(var i=startpage; i<totpage+1; i++){
		if(i>block_scale&&i==startpage){
			dom+='<a onclick="'+clickfuncname+'('+(i-1)+')"><li>[이전]</li></a>';
		}
		if(i!=startpage&&i%block_scale==1){
			dom+='<a onclick="'+clickfuncname+'('+i+')"><li>[다음]</li></a>';
			break;
		}
		if(param1==undefined){
			dom+='<a id="'+liID+i+'" onclick="'+clickfuncname+'('+i+')"><li>'+i+'</li></a>';
		}
		if(param1!=undefined&&param2==undefined){
			dom+='<a id="'+liID+i+'" onclick="'+clickfuncname+'(&#039'+param1+'&#039,'+i+')"><li>'+i+'</li></a>';
		}
		if(param2!=undefined){
			dom+='<a id="'+liID+i+'" onclick="'+clickfuncname+'('+i+',&#039'+param1+'&#039,&#039sj:'+param2+'&#039)"><li>'+i+'</li></a>';
		}
	}
	$("#"+ulID).append(dom);
	chColor(liID+curpage);
}

function chColor(cur){
	$("#"+cur).css("color","orange");
}
