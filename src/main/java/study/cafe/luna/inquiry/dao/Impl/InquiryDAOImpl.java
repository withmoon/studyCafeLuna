package study.cafe.luna.inquiry.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.inquiry.dao.InquiryDAO;
import study.cafe.luna.inquiry.dto.InquiryBoardDTO;

@Repository
public class InquiryDAOImpl implements InquiryDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void deleteUserQna(int seq) {
		sqlSession.delete("QuestionBoard.deleteUserQna",seq);
	}
	@Override
	public List<InquiryBoardDTO> getUserQnAll(int start,int end,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("start",start);
		map.put("end", end);
		return sqlSession.selectList("QuestionBoard.getUserQnAll",map);
	}
	@Override
	public Integer getUserQnCount(String id) {
		return sqlSession.selectOne("QuestionBoard.getUserQnCount",id);
	}
	@Override
	public void upUserQnaContent(int seq, String content) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("seq", seq);
		map.put("content", content);
		sqlSession.update("QuestionBoard.upUserQnaContent",map);
	}
	@Override
	public void upUserQnaReadst(int seq) {
		sqlSession.update("QuestionBoard.upUserQnaReadst",seq);
	}
	
	@Override
	public void create(InquiryBoardDTO vo) {
		sqlSession.insert("QuestionBoard.informUser", vo);
	}
	
	//문의게시판 전체목록
	@Override
	public List<InquiryBoardDTO> QuestionList(int start, int end, String searchOption, String keyword,String branchName) {
		//검색옵션 , 키워드 맵에 저장
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", branchName);
		//#start #end 에 입력될 값
		map.put("start",start);
		map.put("end", end);
		
		return sqlSession.selectList("QuestionBoard.listAll",map);
	}

	//상세보기
	@Override
	public InquiryBoardDTO QbaordRead(InquiryBoardDTO vo) throws Exception {
		return sqlSession.selectOne("QuestionBoard.QRead",vo); 
	}
	@Override
	public int countArticle(String searchOption,String keyword,String branchName) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("branchName", branchName);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("QuestionBoard.countArticle", map);
	}
	
	
	@Override
	public int mailstatus(InquiryBoardDTO vo) {
		return sqlSession.update("QuestionBoard.mailstatus",vo);
	}

	//admin 문의 목록
	@Override
	public List<InquiryBoardDTO> inquireList(int start, int end,String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
     	map.put("start", start);
     	map.put("searchOption", searchOption);
     	map.put("keyword", keyword);
     	map.put("end", end);
    
		return sqlSession.selectList("QuestionBoard.inquireList", map);
	}
	
	//admin 문의 갯수 
	@Override
	public int countInqure(String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
     	map.put("keyword", keyword);
		return sqlSession.selectOne("QuestionBoard.countInqure", map);
	}

	@Override
	public InquiryBoardDTO inquireread(Integer seq) throws Exception {
		return sqlSession.selectOne("QuestionBoard.inquireread",seq);
	}
	@Override
	public void inquiredelete(Integer seq) throws Exception {
		sqlSession.delete("QuestionBoard.inquiredelete",seq);
	}
}
