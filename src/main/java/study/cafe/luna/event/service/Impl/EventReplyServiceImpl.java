package study.cafe.luna.event.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.event.dao.Impl.EventReplyDAOImpl;
import study.cafe.luna.event.dto.EventReplyDTO;
import study.cafe.luna.event.service.EventReplyService;

@Service
public class EventReplyServiceImpl implements EventReplyService {
	@Autowired
	EventReplyDAOImpl eventReplyDAOImpl;

	//댓글 목록
	@Override
	public List<EventReplyDTO> eReplyList(int seq, int start, int end, HttpSession session) {
		return eventReplyDAOImpl.eReplyList(seq, start, end);
	}

	//댓글 갯수
	@Override
	public int counteReply(int rno) {
		return eventReplyDAOImpl.counteReply(rno);
	}

	//댓글 작성
	@Override
	public void create(EventReplyDTO eReplyVO) {
		eventReplyDAOImpl.create(eReplyVO);
	}

	//댓글수정
	@Override
	public void eReplyUp(EventReplyDTO eReplyVO) {
		eventReplyDAOImpl.eReplyUp(eReplyVO);
	}

	//댓글삭제
	@Override
	public void eReplyDe(EventReplyDTO eReplyVO) {
		eventReplyDAOImpl.eReplyDe(eReplyVO);
	}
	
}
