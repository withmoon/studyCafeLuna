var num = getParameterByName("num");

$(function() {
	$(".qupdate").hide();
});

function upbt() {
	$(".qview").hide();
	$(".qupdate").show();
}

//삭제버튼
function btdel(num) {
	$.ajax({
		type:'POST',
		url:'qnadelete.do',
		data:{num:num},
		success : function(data) {
			alert("삭제되었습니다.");
			var url='board.do';
			window.location=url;
		}
	});
}

function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}