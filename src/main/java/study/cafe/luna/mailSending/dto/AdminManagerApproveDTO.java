package study.cafe.luna.mailSending.dto;



import org.springframework.stereotype.Component;

@Component
public class AdminManagerApproveDTO {

	int num;
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
	String position;
	String type;
	int brStatus;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getBrStatus() {
		return brStatus;
	}
	public void setBrStatus(int brStatus) {
		this.brStatus = brStatus;
	}
	@Override
	public String toString() {
		return "AdminManagerApproveVO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", birth="
				+ birth + ", email=" + email + ", branchName=" + branchName + ", zipcode=" + zipcode + ", branchAddr1="
				+ branchAddr1 + ", branchAddr2=" + branchAddr2 + ", position=" + position + ", brStatus=" + brStatus
				+ "]";
	}
	
	

	
	
}
