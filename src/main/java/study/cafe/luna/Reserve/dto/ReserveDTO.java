package study.cafe.luna.Reserve.dto;

import java.util.Date;
 
public class ReserveDTO { 
	
	//예약현황
	private int rownum;
	private int seq; //��ȣ
	private String imp_uid; //id
	private String merchant_uid;
	private String branchName;
	private String branchname;
	private String gunsu;
	private int roomnum;
	private String reservetime;
	private Date reservdate;
	private Date paid_at;
	private int status; //����
	private int brstatus; //�����ѱ�  뭐에 쓸려고 만든지 아시는분 
	private Date nowdate;
	
	
	

	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getGunsu() {
		return gunsu;
	}
	public void setGunsu(String gunsu) {
		this.gunsu = gunsu;
	}
	public String getReservetime() {
		return reservetime;
	}
	public void setReservetime(String reservetime) {
		this.reservetime = reservetime;
	}
	public Date getReservdate() {
		return reservdate;
	}
	public void setReservdate(Date reservdate) {
		this.reservdate = reservdate;
	}
	public int getBrstatus() {
		return brstatus;
	}
	public void setBrstatus(int brstatus) {
		this.brstatus = brstatus;
	}
	public Date getNowdate() {
		return nowdate;
	}
	public void setNowdate(Date nowdate) {
		this.nowdate = nowdate;
	}
	public String getImp_uid() {
		return imp_uid;
	}
	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}
	public String getMerchant_uid() {
		return merchant_uid;
	}
	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public Date getPaid_at() {
		return paid_at;
	}
	public void setPaid_at(Date paid_at) {
		this.paid_at = paid_at;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
