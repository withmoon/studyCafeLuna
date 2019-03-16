var offset1=".page1";
var offset2=".page2";
var count=0;

$(document).ready(function() {
	$(".page2").hide();
	$(".page3").hide();
	$(".page4").hide();
	$(".page5").hide();
	
var PartOfMain_left= setInterval(changeMain, 4000, count);

});

function changeMain(count){
		if(this.count==0){
			$(".page1").fadeOut(3000);
			$(".page2").fadeIn(2000);
			this.count++;
			return;
		}
		if(this.count==1){
			$(".page2").fadeOut(3000);
			$(".page3").fadeIn(2000);
			this.count++;
			return;
		}
		if(this.count==2){
			$(".page3").fadeOut(3000);
			$(".page4").fadeIn(2000);
			this.count++;
			return;
		}
		if(this.count==3){
			$(".page4").fadeOut(3000);
			$(".page5").fadeIn(2000);
			this.count++;
			return;
		}
		if(this.count==4){
			$(".page5").fadeOut(3000);
			$(".page1").fadeIn(2000);
			this.count=0;
			return;
		}
}

/*
$(".page1").delay(2000).fadeOut(3000);
$(".page2").delay(2000).fadeIn(2000);
$(".page2").delay(6000).fadeOut(3000);
$(".page3").delay(6000).fadeIn(2000);
$(".page3").delay(10000).fadeOut(3000);
$(".page4").delay(10000).fadeIn(2000);
$(".page4").delay(14000).fadeOut(3000);
$(".page5").delay(14000).fadeIn(2000);
 */