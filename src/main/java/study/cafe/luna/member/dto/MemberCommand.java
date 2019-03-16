package study.cafe.luna.member.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter 
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
}