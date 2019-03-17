/*진행 이벤트*/
$(function() {
	eventList(1);
	
	//진행중인 인벤트
	$('.eventNow').click(function() {
		eventList(1);
	});
	
	//종료중인 이벤트
	$('.eventFinsh').click(function() {
		eventEndList(1);
	});
});

//진행중인 이벤트
function eventList(enpage) {
	$.ajax({      
		 type:"GET",  
		 url:"eventNow.do",    
	     data:{curPage:enpage},      
	     success:function(data){
	    	 var my_tbody = document.getElementById('my-tbody');
	    	 var new_tbody=document.createElement('tbody');
	    	 new_tbody.id='my-tbody';
	    	 for(var i=0; i<data.eventList.length; i++){
	    	
	    		 var newRow = new_tbody.insertRow(new_tbody.rows.length);

	    	 	var newSeq = newRow.insertCell(0);
	    	 	var seq = data.eventList[i].seq;
	    	 	var newText  = document.createTextNode(seq);
	    	 	newSeq.appendChild(newText);
	    	 	
	    	 	var newTitle = newRow.insertCell(1);
	    	 	var a = document.createElement('a');	   
	    	 	var newText1  = document.createTextNode(data.eventList[i].title);
	    	 	a.appendChild(newText1);
	    	 	newTitle.appendChild(a);
	    	 	(function(seq) {
	    	 		a.addEventListener('click',function() {
	    	 			window.open('viewEvent.do?seq='+seq,'_blank','width=700,height=720,location=no,status=no,scrollbars=yes');
	    	 		}, false);
	    	 	})(seq);
	    	 	
	    	 	 
	    	 	var newWriter = newRow.insertCell(2);
	    	 	var newText2  = document.createTextNode(data.eventList[i].writer);
	    	 	newWriter.appendChild(newText2);
	    	 	
	    	 	var newDate = newRow.insertCell(3);
	    	 	var startdate = new Date(data.eventList[i].startdate);
	    	 	var startdateFormat = startdate.toISOString().slice(2,10);
	    	 	var enddate = new Date(data.eventList[i].enddate);
	    	 	var enddateFormat = enddate.toISOString().slice(2,10);
	    	 	var newText3  = document.createTextNode(startdateFormat + ' ~ ' + enddateFormat);
	    	 	newDate.appendChild(newText3);
	    	 }
	    	 my_tbody.parentNode.replaceChild(new_tbody,my_tbody);
	    	 
	    	 blockPage("pageT",enpage,data.eNowPage.BLOCK_SCALE,data.eNowPage.totPage,"pageT2","eventList");
	     }
	});
}

//종료된이벤트
function eventEndList(eqpage) {
	$.ajax({      
		 type:"GET",  
		 url:"eventEnd.do",    
	     data:{curPage:eqpage},      
	     success:function(data){   
	    	 var my_tbody = document.getElementById('my-tbody');
	    	 var new_tbody=document.createElement('tbody');
	    	 new_tbody.id='my-tbody';
	    	 for(var i=0; i<data.eventEndList.length; i++){
	    	
	    		 var newRow = new_tbody.insertRow(new_tbody.rows.length);

	    	 	var newSeq = newRow.insertCell(0);
	    	 	var seq = data.eventEndList[i].seq;
	    	 	var newText  = document.createTextNode(seq);
	    	 	newSeq.appendChild(newText);
	    	 	
	    	 	var newTitle = newRow.insertCell(1);
	    	 	var a = document.createElement('a');	   
	    	 	var newText1  = document.createTextNode(data.eventEndList[i].title);
	    	 	a.appendChild(newText1);
	    	 	newTitle.appendChild(a);
	    	 	(function(seq) {
	    	 		a.addEventListener('click',function() {
	    	 			window.open('viewEvent.do?seq='+seq,'_blank','width=700,height=720,location=no,status=no,scrollbars=yes');
	    	 		}, false);
	    	 	})(seq);
	    	 	
	    	 	 
	    	 	var newWriter = newRow.insertCell(2);
	    	 	var newText2  = document.createTextNode(data.eventEndList[i].writer);
	    	 	newWriter.appendChild(newText2);
	    	 	
	    	 	var newDate = newRow.insertCell(3);
	    	 	var startdate = new Date(data.eventEndList[i].startdate);
	    	 	var startdateFormat = startdate.toISOString().slice(2,10);
	    	 	var enddate = new Date(data.eventEndList[i].enddate);
	    	 	var enddateFormat = enddate.toISOString().slice(2,10);
	    	 	var newText3  = document.createTextNode(startdateFormat + ' ~ ' + enddateFormat);
	    	 	newDate.appendChild(newText3);
	    	 }
	    	 my_tbody.parentNode.replaceChild(new_tbody,my_tbody);
	    	 
	    	 blockPage("pageT",eqpage,data.eFinshPage.BLOCK_SCALE,data.eFinshPage.totPage,"pageT2","eventEndList");
	     }
	}); 
}