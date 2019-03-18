package study.cafe.luna.notice.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.notice.dao.Impl.NoticeReplyDAOImpl;
import study.cafe.luna.notice.dto.NoticeReplyDTO;
import study.cafe.luna.notice.service.NoticeReplyService;

@Service
public class NoticeReplyServiceImpl implements NoticeReplyService {
	@Autowired
	NoticeReplyDAOImpl noticeReplyDAOImpl;
	
	//댓글 목록
	@Override
	public List<NoticeReplyDTO> nReplyList(int num, int start, int end, HttpSession session) {
		return noticeReplyDAOImpl.nReplyList(num, start, end);
	}

	//댓글 갯수
	@Override
	public int countnReply(int rno) {
		return noticeReplyDAOImpl.countnReply(rno);
	}

	
	//댓글 작성
	@Override
	public void create(NoticeReplyDTO nReplyVO) {
		noticeReplyDAOImpl.create(nReplyVO);
	}

	//댓글 수정
	@Override
	public void nReplyUp(NoticeReplyDTO nReplyVO) {
		noticeReplyDAOImpl.nReplyUp(nReplyVO);
	}

	@Override
	public void nReplyDe(NoticeReplyDTO nReplyVO) {
		noticeReplyDAOImpl.nReplyDe(nReplyVO);
	}
}
