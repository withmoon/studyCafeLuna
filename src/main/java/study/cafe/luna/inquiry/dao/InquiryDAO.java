package study.cafe.luna.inquiry.dao;

import java.util.List;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;

public interface InquiryDAO {
	// 사용자 문의 갯수 가져오기
	Integer getUserQnCount(String id);

	// 사용자 문의 글 가져오기
	List<InquiryBoardDTO> getUserQnAll(int start, int end, String id);

	// seq에 해당하는 문의 글 삭제
	void deleteUserQna(int seq);

	// seq에 해당하는 content,update
	void upUserQnaContent(int seq, String content);

	// 내용 읽음 처리
	void upUserQnaReadst(int seq);

	// user.고객의 소리 보내기
	void create(InquiryBoardDTO vo);
	
	//어드민 문의 상세보기
	InquiryBoardDTO inquireread(Integer seq)throws Exception;
	
	//어드민 문의 지우기
	void inquiredelete(Integer seq)throws Exception;

	// 게시글 목록
	List<InquiryBoardDTO> QuestionList(int start, int end, String searchOption, String keyword, String branchName);

	List<InquiryBoardDTO> inquireList(int start, int end, String searchOption, String keyword); // admin 문의목록

	int countInqure(String searchOption, String keyword); // 문의 갯수

	// 게시글 상세보기
	InquiryBoardDTO QbaordRead(InquiryBoardDTO vo) throws Exception;

	// 레코드 계싼
	int countArticle(String searchOption, String keyword, String branchName) throws Exception;

	// 메일체크
	int mailstatus(InquiryBoardDTO vo);
}
