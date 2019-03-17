package study.cafe.luna.manager.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.manager.dao.ManagerDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;


@Repository 
public class ManagerDAOImpl implements ManagerDAO{
 
	@Autowired 
	private SqlSession SqlSession; 
	//로그인 리스트 
	@Override
	public int login() {
		System.out.println("logincount DAO");
		return SqlSession.selectOne("managerDAO.login");
	}
	
	//로그인 수 +1 
	@Override
	public void logincount() {
		System.out.println("logincount+1 DAO");
		SqlSession.update("managerDAO.logincount");
	}
    //지점명 가져오기
	@Override
	public String branchname(String id) {
		System.out.println("branchname DAO");
		return SqlSession.selectOne("managerDAO.branchname",id);
	}
    //
	@Override
	public int roomcount(HttpSession session, String days) {
		System.out.println("roomcount DAO");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("branchName", session.getAttribute("branchName"));
		map.put("days",days);
		return SqlSession.selectOne("managerDAO.roomcount",map);
	}

	//회원가입수 
	@Override
	public int join() {
		System.out.println("join DAO");
		return SqlSession.selectOne("managerDAO.join");
	}
	//회원수 가져오기
	@Override
	public int member() {
		System.out.println("member DAO");
		return SqlSession.selectOne("managerDAO.member");
	}

	@Override
	public int reroom() {
		System.out.println("reroom DAO");
		return SqlSession.selectOne("managerDAO.reroom");
	}

	@Override
	public List<QuestionBoardDTO> board() {
		System.out.println("reroom DAO");
		return SqlSession.selectList("managerDAO.board");
	}
	/*
	 * @Override public List<StatisticsVO> chart() {
	 * System.out.println("chart DAO"); return
	 * SqlSession.selectList("managerDAO.chart"); }
	 */
	  @Override 
	  public List<RoomReviewDTO> review() {
		 System.out.println("review DAO"); return
         SqlSession.selectList("managerDAO.review"); 
	  }
	 

	

}
