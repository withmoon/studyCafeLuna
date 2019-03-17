package study.cafe.luna.Question.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.Question.dao.QuestionBoardDAO;
import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.Question.service.GetQuestionBoardListService;

@Service
public class GetQuestionBoardListServiceImpl implements GetQuestionBoardListService{

	@Autowired
	public QuestionBoardDAO questionBoardDAO;

//	  @Autowired 
//	  GetUserQnCountDAOImpl guqcDAOImpl;
//	@Autowired
//	  GetUserQnAllDAOImpl guqaDAOImpl;
//	  @Autowired 
//	  DeleteUserQnaDAOImpl duqDAOImpl;
//	  @Autowired 
//	  UpUserQnaContentDAOImpl uuqDAOImpl;
//	  @Autowired 
//	  UpUserQnaReadstDAOImpl uuqrDAOImpl;
	
	// 게시글 페이징/검색
	@Override 
	public List<QuestionBoardDTO> QuestionList(int start, int end, String searchOption, String keyword, String branchName)
			throws Exception {
		System.out.println("QboardList 서비스");
		return questionBoardDAO.QuestionList(start, end, searchOption, keyword, branchName);
	}
	// 레코드계산
		@Override
		public int countArticle(String searchOption, String keyword, String branchName) throws Exception {
			System.out.println("countArticle 레코드계산");
			return questionBoardDAO.countArticle(searchOption, keyword, branchName);
		}

	
	// admin 문의목록
	@Override
	public List<QuestionBoardDTO> inquireList(int start, int end, String searchOption, String keyword,
			HttpSession session) {
		return questionBoardDAO.inquireList(start, end, searchOption, keyword);
	}
	@Override
	public int countInqure(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

//	  @Override
//    public Integer getUserQnCount(String id) {
//		  return guqcDAOImpl.getUserQnCount(id); 
//		 }

//	  @Override 
//	  public List<QuestionBoardDTO> getUserQnAll(int start,int end,String id) { 
//		 return guqaDAOImpl.getUserQnAll(start,end,id); 
//		 }
}
