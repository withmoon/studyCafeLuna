package study.cafe.luna.manager.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.Question.dto.QuestionBoardDTO;
 

public interface ManagerService {
	//로그인수 +1 
	public void logincount();
	//branchname 구하기...
	String branchname(String id);
	//로그인 수 가져오기
	int login();
	//예약수 가져오기 
	int roomcount(HttpSession session,String days);
	//회원가입 수 
	public int join(); 
	//회원수 
	public int member();
}
