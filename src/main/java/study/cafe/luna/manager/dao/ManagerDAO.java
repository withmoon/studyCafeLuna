package study.cafe.luna.manager.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.room.dto.RoomReviewDTO;

public interface ManagerDAO {
	
	int login(); //로그인 수 가져오기 
	
	void logincount(); //로그인수+1;
	
	MemberDTO branchname(String id); //branchname 가져오기..
	
	int roomcount(HttpSession session, String days); //예약수 가져오기

	int join(); //회원가입수 가져오기
	
	int member(); //회원수 가져오기
	
	int reroom(); //환불수 가져오기 
	List<InquiryBoardDTO> board(); //고객의소리 미리보기 가져오기
	//차트
//	List<StatisticsVO> chart();
	
	
}
