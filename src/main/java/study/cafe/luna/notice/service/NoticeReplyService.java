package study.cafe.luna.notice.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.notice.dto.NoticeReplyDTO;

public interface NoticeReplyService {
	public List<NoticeReplyDTO> nReplyList(int num,int start, int end, HttpSession session); //댓글 목록
	public int countnReply(int rno); //글 갯수
	public void create(NoticeReplyDTO nReplyVO); //댓글 입력
	public void nReplyUp(NoticeReplyDTO nReplyVO); //댓글 수정
	public void nReplyDe(NoticeReplyDTO nReplyVO); //댓글 삭제
}
