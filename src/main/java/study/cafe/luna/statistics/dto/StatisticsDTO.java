package study.cafe.luna.statistics.dto;

import java.util.Date;
  
public class StatisticsDTO {
	//일별매출
	private String branchname;
	private Date date1;
	private Date date2;
	private Date reservdate;
	private String adate;
	private int gunsu;
	private int total;
	private int status;
	private int status2; 
	
	
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	
	
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	public Date getReservdate() {
		return reservdate;
	}
	public void setReservdate(Date reservdate) {
		this.reservdate = reservdate;
	}
	public int getGunsu() {
		return gunsu;
	}
	public void setGunsu(int gunsu) {
		this.gunsu = gunsu;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus2() {
		return status2;
	}
	public void setStatus2(int status2) {
		this.status2 = status2;
	}
	
	
}
