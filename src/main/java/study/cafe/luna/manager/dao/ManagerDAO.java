package study.cafe.luna.manager.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.Question.dto.QuestionBoardDTO;

public interface ManagerDAO {
	//로그인 수 가져오기 
	int login(); 
	//로그인수+1;
	void logincount(); 
	//branchname 가져오기..
	String branchname(String id);
	//예약수 가져오기
	int roomcount(HttpSession session, String days);
	//회원가입수 가져오기
	int join();
	//회원수 가져오기
	int member();
	//환불수 가져오기 
	int reroom(); 
	 
	//고객의소리 미리보기 가져오기
	List<QuestionBoardDTO> board();
	//리뷰가져오기
//	List<RoomReviewDTO> review();
	//차트
//	List<StatisticsVO> chart();
	
	
}
