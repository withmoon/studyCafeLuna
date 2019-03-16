/**
 * 
 */
/*
 * function today() { var day = new Date();
 * 
 * var month = today.getUTCMonth() + 1; //months from 1-12 var day =
 * today.getUTCDate(); var year = today.getUTCFullYear();
 * 
 * today = year + "-" + month + "-" + day; }
 * 
 * $(document).ready(function() { $("#date").html(today); });
 */

function day() {
	var day = new Date();
	var today = day.getFullYear()+"년 "+(day.getMonth() + 1)+"월 "+day.getDate()+"일"; 
		/*
		(d.getMonth() + 1) + "/" + d.getDate() + "/"
			+ d.getFullYear();*/

	$("#date").html(today);

}

$(document).ready(function() {

	day();

});