package study.cafe.luna.notice.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.notice.dao.NoticeReplyDAO;
import study.cafe.luna.notice.dto.NoticeReplyDTO;


@Repository
public class NoticeReplyDAOImpl implements NoticeReplyDAO {
	@Autowired
	SqlSessionTemplate SqlSession;
	
	//답글 목록
	public List<NoticeReplyDTO> nReplyList(int num, int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
     	map.put("start", start);
     	map.put("end", end);
     	
		return SqlSession.selectList("noticeReplyDAO.nReplyList", map);
	}
	
	//답글 갯수
	@Override
	public int countnReply(int num) {
		return SqlSession.selectOne("noticeReplyDAO.countnReply", num);
	}

	//답글 입력
	public void create(NoticeReplyDTO nReplyVO) {
		SqlSession.insert("noticeReplyDAO.nReplyInsert", nReplyVO);
	}

	//댓글 수정
	@Override
	public void nReplyUp(NoticeReplyDTO nReplyVO) {
		SqlSession.update("noticeReplyDAO.nReplyUpdate", nReplyVO);
	}

	@Override
	public void nReplyDe(NoticeReplyDTO nReplyVO) {
		SqlSession.delete("noticeReplyDAO.nReplyDelete", nReplyVO);
	}
}
