package study.cafe.luna.Question.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import study.cafe.luna.Question.dto.QuestionBoardDTO;

public interface GetQuestionBoardListService {
	
	// 문의글 목록보기
	public List<QuestionBoardDTO> QuestionList(int start, int end, String searchOption, String keyword, String branchName)
			throws Exception;

	// admin 문의목록
	public List<QuestionBoardDTO> inquireList(int start, int end, String searchOption, String keyword,
			HttpSession session);

	// 문의 갯수
//	public int countInqure(String searchOption, String keyword);

	// 레코드계산
	public int countArticle(String searchOption, String keyword, String branchName) throws Exception;
}
