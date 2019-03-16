package study.cafe.luna.room.dto;

public class RoomInfoDTO {
	String branchName;
	int roomNum;
	String roomName; 
	String roomEx1; 
	String roomEx2; 
	String roomEx3;
	String roomEx4;
	String roomExplain;
	//주의사항
	String roomWarn;
	//오시는길
	String comeRoute;
	//방 주소 스트링으로 받아 js에서 처리할 예정
	String roomLocate;
	//파일 이름--LookOver에서 한개씩만 쓰므로 넣어놈
	String fname;
	//시도/구군 붙여서
	String sidogugun;
	//예약 현황
	String reservstate;
	//예약 하고자하는 날짜
    String startdate;
    //제외 방번호
    String notinRoomNum;
    //지점 주소만 도로명으로
    String branchAddr1;
    String branchtel;
    
    int roomprice;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomEx1() {
		return roomEx1;
	}

	public void setRoomEx1(String roomEx1) {
		this.roomEx1 = roomEx1;
	}

	public String getRoomEx2() {
		return roomEx2;
	}

	public void setRoomEx2(String roomEx2) {
		this.roomEx2 = roomEx2;
	}

	public String getRoomEx3() {
		return roomEx3;
	}

	public void setRoomEx3(String roomEx3) {
		this.roomEx3 = roomEx3;
	}

	public String getRoomEx4() {
		return roomEx4;
	}

	public void setRoomEx4(String roomEx4) {
		this.roomEx4 = roomEx4;
	}

	public String getRoomExplain() {
		return roomExplain;
	}

	public void setRoomExplain(String roomExplain) {
		this.roomExplain = roomExplain;
	}

	public String getRoomWarn() {
		return roomWarn;
	}

	public void setRoomWarn(String roomWarn) {
		this.roomWarn = roomWarn;
	}

	public String getComeRoute() {
		return comeRoute;
	}

	public void setComeRoute(String comeRoute) {
		this.comeRoute = comeRoute;
	}

	public String getRoomLocate() {
		return roomLocate;
	}

	public void setRoomLocate(String roomLocate) {
		this.roomLocate = roomLocate;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSidogugun() {
		return sidogugun;
	}

	public void setSidogugun(String sidogugun) {
		this.sidogugun = sidogugun;
	}

	public String getReservstate() {
		return reservstate;
	}

	public void setReservstate(String reservstate) {
		this.reservstate = reservstate;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getNotinRoomNum() {
		return notinRoomNum;
	}

	public void setNotinRoomNum(String notinRoomNum) {
		this.notinRoomNum = notinRoomNum;
	}

	public String getBranchAddr1() {
		return branchAddr1;
	}

	public void setBranchAddr1(String branchAddr1) {
		this.branchAddr1 = branchAddr1;
	}

	public String getBranchtel() {
		return branchtel;
	}

	public void setBranchtel(String branchtel) {
		this.branchtel = branchtel;
	}

	public int getRoomprice() {
		return roomprice;
	}

	public void setRoomprice(int roomprice) {
		this.roomprice = roomprice;
	}
    
}
