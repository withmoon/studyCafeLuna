package study.cafe.luna.room.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class MyPageInfoDTO {
	String branchAddr1;
	String roomName;
	String branchName;
	String reservdate;
	String starttime;
	String endtime;
	String receipt_url;
	String roomNum;
	String imp_uid;
	int status;
	String id;
	String reservenddate;
	String reservenddatetime;
	String branchtel;
	public String getBranchAddr1() {
		return branchAddr1;
	}
	public void setBranchAddr1(String branchAddr1) {
		this.branchAddr1 = branchAddr1;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getReservdate() {
		return reservdate;
	}
	public void setReservdate(String reservdate) {
		this.reservdate = reservdate;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getReceipt_url() {
		return receipt_url;
	}
	public void setReceipt_url(String receipt_url) {
		this.receipt_url = receipt_url;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getImp_uid() {
		return imp_uid;
	}
	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReservenddate() {
		return reservenddate;
	}
	public void setReservenddate(String reservenddate) {
		this.reservenddate = reservenddate;
	}
	public String getReservenddatetime() {
		return reservenddatetime;
	}
	public void setReservenddatetime(String reservenddatetime) {
		this.reservenddatetime = reservenddatetime;
	}
	public String getBranchtel() {
		return branchtel;
	}
	public void setBranchtel(String branchtel) {
		this.branchtel = branchtel;
	}
	
}
