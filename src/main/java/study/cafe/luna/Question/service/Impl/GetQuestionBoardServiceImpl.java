package study.cafe.luna.Question.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.Question.dao.QuestionBoardDAO;
import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.Question.service.GetQuestionBoardService;

@Service
public class GetQuestionBoardServiceImpl implements GetQuestionBoardService {
	
	@Autowired
	QuestionBoardDAO questionBoardDAO;
	
	//게시글 상세보기
		@Override
		public QuestionBoardDTO QbaordRead(QuestionBoardDTO vo) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("QboardRead 서비스");
			return questionBoardDAO.QbaordRead(vo);
		}
}
