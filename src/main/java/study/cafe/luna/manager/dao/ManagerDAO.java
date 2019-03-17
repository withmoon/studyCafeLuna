package study.cafe.luna.manager.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.room.dto.RoomReviewDTO;

public interface ManagerDAO {
	
	int login(); //로그인 수 가져오기 
	
	void logincount(); //로그인수+1;
	
	String branchname(String id); //branchname 가져오기..
	
	int roomcount(HttpSession session, String days); //예약수 가져오기

	int join(); //회원가입수 가져오기
	
	int member(); //회원수 가져오기
	
	int reroom(); //환불수 가져오기 
	List<QuestionBoardDTO> board(); //고객의소리 미리보기 가져오기
	
	List<RoomReviewDTO> review(); //리뷰가져오기
	//차트
//	List<StatisticsVO> chart();
	
	
}
