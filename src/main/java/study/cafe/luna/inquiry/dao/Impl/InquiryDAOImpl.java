package study.cafe.luna.inquiry.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.inquiry.dao.InquiryDAO;

@Repository
public class InquiryDAOImpl implements InquiryDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void deleteUserQna(int seq) {
		sqlSession.delete("QuestionBoard.deleteUserQna",seq);
	}
	@Override
	public List<QuestionBoardDTO> getUserQnAll(int start,int end,String id) {
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
	public void create(QuestionBoardDTO vo) {
		sqlSession.insert("QuestionBoard.informUser", vo);
	}
	
}
