package study.cafe.luna.event.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.event.dto.EventReplyDTO;

public interface EventReplyService {
	public List<EventReplyDTO> eReplyList(int seq, int start, int end, HttpSession session); //댓글 목록
	public int counteReply(int rno); //글 갯수
	public void create(EventReplyDTO eReplyVO); //댓글 입력
	public void eReplyUp(EventReplyDTO eReplyVO); //댓글 수정
	public void eReplyDe(EventReplyDTO eReplyVO); //댓글 삭제
}
