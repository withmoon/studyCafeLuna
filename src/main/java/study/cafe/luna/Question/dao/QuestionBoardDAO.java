package study.cafe.luna.Question.dao;

import java.util.List;

import study.cafe.luna.Question.dto.QuestionBoardDTO;

public interface QuestionBoardDAO {

	
	
	public void insertBoard(QuestionBoardDTO vo);

	// 게시글 목록
	public List<QuestionBoardDTO> QuestionList(int start, int end, String searchOption, String keyword, String branchName);

	public List<QuestionBoardDTO> inquireList(int start, int end, String searchOption, String keyword); // admin 문의목록

	public int countInqure(String searchOption, String keyword); // 문의 갯수

	// 게시글 상세보기
	public QuestionBoardDTO QbaordRead(QuestionBoardDTO vo) throws Exception;

	// 레코드 계싼
	public int countArticle(String searchOption, String keyword, String branchName) throws Exception;

	// 메일체크
	public int mailstatus(QuestionBoardDTO vo);

	// admin
	public void inquireinsert(QuestionBoardDTO vo) throws Exception;

	public QuestionBoardDTO inquireread(Integer seq) throws Exception;

	public void inquiredelete(Integer seq) throws Exception;
}
