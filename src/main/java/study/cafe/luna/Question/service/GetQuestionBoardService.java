package study.cafe.luna.Question.service;

import study.cafe.luna.Question.dto.QuestionBoardDTO;

public interface GetQuestionBoardService {

	// 게시글 상세보기
	public QuestionBoardDTO QbaordRead(QuestionBoardDTO vo) throws Exception;
	
	

	
}
