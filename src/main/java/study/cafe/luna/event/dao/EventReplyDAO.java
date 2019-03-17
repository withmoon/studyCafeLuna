package study.cafe.luna.event.dao;

import java.util.List;

import study.cafe.luna.event.dto.EventReplyDTO;

public interface EventReplyDAO {
	public List<EventReplyDTO> eReplyList(int seq, int start, int end); //댓글 목록
	public int counteReply(int num); //글 갯수
	public void create(EventReplyDTO eReplyVO); //댓글 입력
	public void eReplyUp(EventReplyDTO eReplyVO); //댓글 수정
	public void eReplyDe(EventReplyDTO eReplyVO); //댓글 삭제
}
