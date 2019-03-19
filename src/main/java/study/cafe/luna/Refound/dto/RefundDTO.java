package study.cafe.luna.Refound.dto;

import java.util.Date;
 
public class RefundDTO { 
	//매출현황
	private Date date;
	private Integer inone;
	private Integer su;
	private Integer sales1;
	private String market;
	private Integer sales2;
	private Integer total;
	 
	//회원관리
	private String id; 
	private String name;
	private String phone;
	private String email;
	private String BRANCHNAME;

	//예약현황
	private int rownum;
	private int seq; //��ȣ
	private String branchName;
	private String branchname;
	private int roomnum;
	private Date reservdate;
	private int status; //����
	private int brstatus; //�����ѱ�  뭐에 쓸려고 만든지 아시는분 
	private int Gunsu;
	
	
	
	
	public int getGunsu() {
		return Gunsu;
	}
	public void setGunsu(int gunsu) {
		Gunsu = gunsu;
	}
	public String getBRANCHNAME() {
		return BRANCHNAME;
	}
	public void setBRANCHNAME(String bRANCHNAME) {
		BRANCHNAME = bRANCHNAME;
	}
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
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public Date getReservdate() {
		return reservdate;
	}
	public void setReservdate(Date reservdate) {
		this.reservdate = reservdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getBrstatus() {
		return brstatus;
	}
	public void setBrstatus(int brstatus) {
		this.brstatus = brstatus;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getInone() {
		return inone;
	}
	public void setInone(Integer inone) {
		this.inone = inone;
	}
	public Integer getSu() {
		return su;
	}
	public void setSu(Integer su) {
		this.su = su;
	}
	public Integer getSales1() {
		return sales1;
	}
	public void setSales1(Integer sales1) {
		this.sales1 = sales1;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public Integer getSales2() {
		return sales2;
	}
	public void setSales2(Integer sales2) {
		this.sales2 = sales2;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
