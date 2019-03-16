function kakapop(){
	var spct=0;
	reservlist=reservtime+reserveEndTime;
	var rtlist=reservlist.split(',');
	for ( var i in rtlist ) {
		spct++;
	}
	if(spct<5){
		alert("달빛 스터디는 기본 두시간 예약입니다.^^");
		return;
	}
	if(reservtime==''||seldate==''){
		alert("스케줄 및 시간을 선택해주세요^^");
		return;
	}
	if(reservtime!=''&&seldate!=''){
		window.open("kakaopay.udo", "_blank", "scrollbars=1,resizable=1,width=400,height=550");
	}
}