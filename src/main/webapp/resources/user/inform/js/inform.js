/*공지사항*/
$(function() {
	$('.list_tab2').hide();

	 noticeList(1);
	
	 //공지사항
	 $('.informNotice').click(function() {
		 $('.list_tab2').hide();
		 $('.list_tab').show();
		 noticeList(1); 
	});
	 
	 //자주묻는질문
	 $('.informQnA').click(function() {
		 $('.list_tab2').hide();
		 $('.list_tab').show();
		 qnaList(1);
	});
	 
	 //고객의 소리
	 $('.informUser').click(function() {
			$('.list_tab').hide();
			$('.list_tab2').show();
			
	});
		
	var area0= $("#sido_select>option").map(function() { return $(this).val(); });
		
		
		// 시/도 선택 박스 초기화
		$("select[name^=sido]").each(function() {
			$selsido = $(this);
			$selsido.next().append("<option value=''>시/구/군 선택</option>");
		});

		 
		// 시/도 선택시 구/군 설정
		$("select[name^=sido]").change(function() {
			var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의
																						// 구군
																						// Array
			var $gugun = $(this).next(); // 선택영역 군구 객체
			$("option",$gugun).remove(); // 구군 초기화
			
			var sido=$("option:selected",$(this));
			
			$.ajax({      
				 type:"GET",  
				 url:"getSidoGugun.do",    
			     data:sido,      
			     success:function(data){   
			    	 for(var i=0; i<data.length; i++){
			    		 $gugun.append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			    	 }
			     }
			});
		});
		
		$("select[name^=gugun]").each(function() {
			$selgugun = $(this);
			$selgugun.next().append("<option value=''>지점 선택</option>");
		});
		
		// 지점 설정
		$("select[name^=gugun]").change(function() {
			var area = "area"+$("option",$(this)).index($("option:selected",$(this)));
			
			var $branch = $(this).next();
			$("option",$branch).remove();
			
			var gugun = $("option:selected", $(this));
			
			$.ajax({      
				 type:"GET",  
				 url:"branchName.do",    
			     data:gugun,      
			     success:function(data){   
			    	 for(var i=0; i<data.length; i++){
			    		 $branch.append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			    	 }
			     }
			});
		});
});

//공지사항
function noticeList(npage) {
	$.ajax({
		type:"GET",
		url:"informlist.do",
		data:{curPage:npage},
		success:function(data) {
			console.log(data.noticeList[0].title + " 블러왔냥 " +data.noticeList.length);
			console.log(data.noticePage.nPage)
			
			/*테이블*/
			var inform_table = document.getElementById('inform_table');
			var new_table = document.createElement('tbody');
			new_table.id = 'inform_table';
			for(var i=0; i<data.noticeList.length; i++) {
				var newRow = new_table.insertRow(new_table.rows.length);
				
				var newNum = newRow.insertCell(0);
				var num = data.noticeList[i].num;
				var newText = document.createTextNode(num);
				newNum.appendChild(newText);
				
				var newTitle = newRow.insertCell(1);
				var a = document.createElement('a');
				var newText1 = document.createTextNode(data.noticeList[i].title);
				a.appendChild(newText1);
				newTitle.appendChild(a);
				(function(num) {
					a.addEventListener('click', function() {
						window.open('viewNotice.do?num='+num,'_self');
					}, false);
				})(num);
				
				var newDate = newRow.insertCell(2);
				var regdate = new Date(data.noticeList[i].regdate);
				var regdateFormat = regdate.toISOString().slice(2,10);
				var newText2 = document.createTextNode(regdateFormat);
				newDate.appendChild(newText2);
			}
			inform_table.parentNode.replaceChild(new_table,inform_table);
			
			blockPage("informPaging",npage,data.noticePage.BLOCK_SCALE,data.noticePage.totPage,"noPaging2","noticeList");
		}
	}); //end ajax
}

//자주묻는질문
function qnaList(qpage) {
	$.ajax({
		type:"GET",
		url:"informChange.do",
		data:{curPage:qpage},
		success:function(data) {
			/*테이블*/
			var inform_table = document.getElementById('inform_table');
			var new_table = document.createElement('tbody');
			new_table.id = 'inform_table';
			
			for(var i=0; i<data.qnaList.length; i++) {
				var newRow = new_table.insertRow(new_table.rows.length);
				
				var newNum = newRow.insertCell(0);
				var num = data.qnaList[i].num;
				var newText = document.createTextNode(num);
				newNum.appendChild(newText);
				var newSubject = newRow.insertCell(1);
				var a = document.createElement('a');
				var newText1 = document.createTextNode(data.qnaList[i].subject);
				a.appendChild(newText1);
				newSubject.appendChild(a);
				(function(num) {
					a.addEventListener('click', function() {
						window.open('viewQnA.do?num='+num,'_self');
					}, false);
				})(num);
				
				var newDate = newRow.insertCell(2);
				var regdate = new Date(data.qnaList[i].regdate);
				var regdateFormat = regdate.toISOString().slice(2,10);
				var newText2 = document.createTextNode(regdateFormat);
				newDate.appendChild(newText2);
				
			}
			inform_table.parentNode.replaceChild(new_table,inform_table);
			
			blockPage("informPaging",qpage,data.qnaPage.BLOCK_SCALE,data.qnaPage.totPage,"noPaging2","qnaList");
		}
	}); //end ajax
}

//고객의 소리 보내기
function userCommand(){
	var branchName=$("#branch").val();
	var title=$("#title").val();
	var content=$("#content").val();

	$.ajax({
		type:"POST",
		url:"informUser.do",
		data:{branchName:branchName,title:title,content:content},
		success:function(data) {
			$('#branch').val("");
			$('#title').val("");
			$('#content').val("");
			
			alert("소중한 의견 너무나 감사합니다~");
			
			var url='mypage.do';
			window.location=url;
		}
	});
}