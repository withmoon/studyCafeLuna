package study.cafe.luna.Question.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.Question.dao.QuestionBoardDAO;
import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.member.service.GetAllMemberCountService;

@Service
public class GetQuestionBoardListServiceImpl implements GetAllMemberCountService {
	
	@Autowired
	private QuestionBoardDAO boardDAO;

	@Override
	public Integer getAllMemberCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Autowired GetUserQnCountDAOImpl guqcDAOImpl;
	 * 
	 * @Autowired GetUserQnAllDAOImpl guqaDAOImpl;
	 * 
	 * @Autowired DeleteUserQnaDAOImpl duqDAOImpl;
	 * 
	 * @Autowired UpUserQnaContentDAOImpl uuqDAOImpl;
	 * 
	 * @Autowired UpUserQnaReadstDAOImpl uuqrDAOImpl;
	 */
	// 게시글 페이징/검색
	/*
	 * @Override public List<QuestionBoardDTO> QboardList(int start, int end, String
	 * searchOption, String keyword, String branchName) throws Exception { // TODO
	 * Auto-generated method stub System.out.println("QboardList 서비스"); return
	 * boardDAO.listAll(start, end, searchOption, keyword, branchName); }
	 * 
	 * // 레코드계산
	 * 
	 * @Override public int countArticle(String searchOption, String keyword, String
	 * branchName) throws Exception { // TODO Auto-generated method stub
	 * System.out.println("countArticle 레코드계산"); return
	 * boardDAO.countArticle(searchOption, keyword, branchName); }
	 */
	
	/*
	 * @Override public Integer getUserQnCount(String id) { return
	 * guqcDAOImpl.getUserQnCount(id); }
	 * 
	 * @Override public List<QuestionBoardDTO> getUserQnAll(int start,int end,String
	 * id) { return guqaDAOImpl.getUserQnAll(start,end,id); }
	 */
}
