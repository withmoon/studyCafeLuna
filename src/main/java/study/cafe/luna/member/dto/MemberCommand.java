package study.cafe.luna.member.dto;

import org.springframework.web.multipart.MultipartFile;

public class MemberCommand {
	//memberDAO
	String kid;
	String id;
	String pw;
	String name;
	String phone;
	String birth;
	String email;
	String branchName;
	String zipcode;
	String branchAddr1;
	String branchAddr2;
	String branchAddr3;	
	String brStatus;
	String position;
	String regdate;
	int count; 
	
	String branchtel;
	MultipartFile branchimgf;
	String branchimg;
	String branchoriginimg;
	
	String sido;
	String gugun;
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getBranchAddr1() {
		return branchAddr1;
	}
	public void setBranchAddr1(String branchAddr1) {
		this.branchAddr1 = branchAddr1;
	}
	public String getBranchAddr2() {
		return branchAddr2;
	}
	public void setBranchAddr2(String branchAddr2) {
		this.branchAddr2 = branchAddr2;
	}
	public String getBranchAddr3() {
		return branchAddr3;
	}
	public void setBranchAddr3(String branchAddr3) {
		this.branchAddr3 = branchAddr3;
	}
	public String getBrStatus() {
		return brStatus;
	}
	public void setBrStatus(String brStatus) {
		this.brStatus = brStatus;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBranchtel() {
		return branchtel;
	}
	public void setBranchtel(String branchtel) {
		this.branchtel = branchtel;
	}
	public MultipartFile getBranchimgf() {
		return branchimgf;
	}
	public void setBranchimgf(MultipartFile branchimgf) {
		this.branchimgf = branchimgf;
	}
	public String getBranchimg() {
		return branchimg;
	}
	public void setBranchimg(String branchimg) {
		this.branchimg = branchimg;
	}
	public String getBranchoriginimg() {
		return branchoriginimg;
	}
	public void setBranchoriginimg(String branchoriginimg) {
		this.branchoriginimg = branchoriginimg;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	
}