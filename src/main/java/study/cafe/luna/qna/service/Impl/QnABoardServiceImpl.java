package study.cafe.luna.qna.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.qna.dao.QnABoardDAO;
import study.cafe.luna.qna.dto.QnABoardDTO;
import study.cafe.luna.qna.service.QnABoardService;

@Service
public class QnABoardServiceImpl implements QnABoardService {
   @Autowired
   QnABoardDAO	qnaBoardDAO;

   //질문 목록
   @Override
   public List<QnABoardDTO> qnaAll(int start, int end, HttpSession session) {
	   return qnaBoardDAO.qnaAll(start, end);
   }

   //질문갯수
   @Override
   public int countQnA(String subject) {
	   return qnaBoardDAO.countQnA(subject);
   }
   
   @Override
   public void insert(QnABoardDTO adminQnABoardVO) throws Exception {
	   qnaBoardDAO.insert(adminQnABoardVO);
   }

   @Override
   public QnABoardDTO read(int num) throws Exception {
      return qnaBoardDAO.read(num);
   }

   @Override
   public void update(QnABoardDTO vo) throws Exception {
	   qnaBoardDAO.update(vo);
   }

   @Override
   public void delete(int num) throws Exception {
	   qnaBoardDAO.delete(num);
   }

   /*user_inform*/
   //질문상세보기
   @Override
   public QnABoardDTO qnaRead(int num) throws Exception {
	   return qnaBoardDAO.qnaRead(num);
}
}