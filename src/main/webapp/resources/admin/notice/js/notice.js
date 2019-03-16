$(function() {
	noticeList(1);
});

//공지사항
function noticeList(npage) {
	$.ajax({
		type:"GET",
		url:"gongjiboardList.ado",
		data:{curPage:npage},
		success:function(data) {
			console.log(data.noticeList[0].title + " 블러왔냥 " +data.noticeList.length);
			console.log(data.noticePage.nPage)
			
			/*테이블*/
			var inform_table = document.getElementById('notice_table');
			var new_table = document.createElement('tbody');
			new_table.id = 'notice_table';
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
						window.open('gongjiview.ado?num='+num,'_self');
					}, false);
				})(num);
				
				var newDate = newRow.insertCell(2);
				var regdate = new Date(data.noticeList[i].regdate);
				var regdateFormat = regdate.toISOString().slice(2,10);
				var newText2 = document.createTextNode(regdateFormat);
				newDate.appendChild(newText2);
			}
			inform_table.parentNode.replaceChild(new_table,inform_table);
			
			blockPage("noticePaging",npage,data.noticePage.BLOCK_SCALE,data.noticePage.totPage,"noPaging2","noticeList");
		}
	}); //end ajax
}