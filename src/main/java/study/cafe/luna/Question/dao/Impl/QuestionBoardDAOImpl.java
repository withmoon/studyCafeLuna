package study.cafe.luna.Question.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.Question.dao.QuestionBoardDAO;
import study.cafe.luna.Question.dto.QuestionBoardDTO;

@Repository 
public class QuestionBoardDAOImpl  implements QuestionBoardDAO{
  
	@Autowired
	private SqlSessionTemplate SqlSession;

	@Override
	public void insertBoard(QuestionBoardDTO vo) {
		// TODO Auto-generated method stub
		
	}
	//문의게시판 전체목록
	@Override
	public List<QuestionBoardDTO> QuestionList(int start, int end, String searchOption, String keyword,String branchName) {
		//검색옵션 , 키워드 맵에 저장
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", branchName);
		//#start #end 에 입력될 값
		map.put("start",start);
		map.put("end", end);
		
		return SqlSession.selectList("QuestionBoard.listAll",map);
	}

	//상세보기
	@Override
	public QuestionBoardDTO QbaordRead(QuestionBoardDTO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QbaordRead DAO");
		return SqlSession.selectOne("QuestionBoard.QRead",vo); 
	}
	@Override
	public int countArticle(String searchOption,String keyword,String branchName) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("branchName", branchName);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return SqlSession.selectOne("QuestionBoard.countArticle", map);
	}
	
	
	@Override
	public int mailstatus(QuestionBoardDTO vo) {
		System.out.println("메일체크 DAO");
		return SqlSession.update("QuestionBoard.mailstatus",vo);
	}
	
	//user 고객의 소리 insert
	@Override
	public void create(QuestionBoardDTO vo) {
		SqlSession.insert("QuestionBoard.informUser", vo);
	}
	
	//admin 문의 목록
	@Override
	public List<QuestionBoardDTO> inquireList(int start, int end,String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
     	map.put("start", start);
     	map.put("searchOption", searchOption);
     	map.put("keyword", keyword);
     	map.put("end", end);
    
		return SqlSession.selectList("QuestionBoard.inquireList", map);
	}
	
	//admin 문의 갯수 
	@Override
	public int countInqure(String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
     	map.put("keyword", keyword);
		return SqlSession.selectOne("QuestionBoard.countInqure", map);
	}
	
	//admin
	@Override
	public void inquireinsert(QuestionBoardDTO vo) throws Exception {
		SqlSession.update("QuestionBoard.inquireinsert",vo);
	}
	@Override
	public QuestionBoardDTO inquireread(Integer seq) throws Exception {
		return SqlSession.selectOne("QuestionBoard.inquireread",seq);
	}
	@Override
	public void inquiredelete(Integer seq) throws Exception {
		SqlSession.delete("QuestionBoard.inquiredelete",seq);
	}


}
