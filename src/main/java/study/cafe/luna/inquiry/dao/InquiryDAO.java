package study.cafe.luna.inquiry.dao;

import java.util.List;

import study.cafe.luna.Question.dto.QuestionBoardDTO;

public interface InquiryDAO {
	// 사용자 문의 갯수 가져오기
	Integer getUserQnCount(String id);

	// 사용자 문의 글 가져오기
	List<QuestionBoardDTO> getUserQnAll(int start, int end, String id);

	// seq에 해당하는 문의 글 삭제
	void deleteUserQna(int seq);

	// seq에 해당하는 content,update
	void upUserQnaContent(int seq, String content);

	// 내용 읽음 처리
	void upUserQnaReadst(int seq);

	// user.고객의 소리 보내기
	public void create(QuestionBoardDTO vo);
}
