$(function() {
	qnaList(1);
});

function qnaList(qpage) {
	
	$.ajax({
		type:"GET",
		url:"boardList.do",
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
						window.open('qnaview.do?num='+num,'_self');
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