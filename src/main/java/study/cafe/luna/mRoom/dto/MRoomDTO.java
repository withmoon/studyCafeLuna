package study.cafe.luna.mRoom.dto;

import java.util.Date;
  
public class MRoomDTO {
	private int roomnum;
	private int filenum;
	private String branchName;
	private String roomName;
	
	private String roomEx1;
	private String roomEx2;
	private String roomEx3;
	private String roomEx4;
	private String inown;
	private String joosu; 
	private Date day1;
	
	private String roomExplain;
	private String roomWarn;
	private String comeRoute;
	private String roomLocate;
	private int roomPrice;
	private String Price;
	private String keyword;
	private String id;
	
	
	//파일업로드
	private String Oname;
	private String Fname;
	private String savePath;

	
	public String getOname() {
		return Oname;
	}
	public void setOname(String oname) {
		Oname = oname;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getDay1() {
		return day1;
	}
	public void setDay1(Date day1) {
		this.day1 = day1;
	}
	public String getInown() {
		return inown;
	}
	public void setInown(String inown) {
		this.inown = inown;
	}
	public String getJoosu() {
		return joosu;
	}
	public void setJoosu(String joosu) {
		this.joosu = joosu;
	}
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public int getFilenum() {
		return filenum;
	}
	public void setFilenum(int filenum) {
		this.filenum = filenum;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	


	
}
