package study.cafe.luna.qna.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.qna.dao.QnABoardDAO;
import study.cafe.luna.qna.dto.QnABoardDTO;

@Repository
public class QnABoardDAOImpl implements QnABoardDAO {

   @Autowired
   SqlSessionTemplate sqlsession;

   //질문목록
   public List<QnABoardDTO> qnaAll(int start, int end) {
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("start", start);
	   map.put("end", end);
	   return sqlsession.selectList("qnaBoardDAO.qnaAll", map);
   }

   //질문갯수
   public int countQnA(String subject) {
	   return sqlsession.selectOne("qnaBoardDAO.countQnA", subject);
   }
   
   //질문 상세보기
   @Override
   public QnABoardDTO qnaRead(int num) throws Exception {
	   return sqlsession.selectOne("qnaBoardDAO.viewQnA", num);
   }
   
   //질문수정하기
   @Override
   public void qupdate(QnABoardDTO vo) {
      sqlsession.update("qnaBoardDAO.qupdate",vo);
   }
   
   //질문삭제하기
   @Override
   public void qdelete(QnABoardDTO vo) {
      sqlsession.delete("qnaBoardDAO.qdelete",vo);
   }
   
   @Override
   public void insert(QnABoardDTO adminQnABoardVO) throws Exception {
      // TODO Auto-generated method stub
      sqlsession.insert("qnaBoardDAO.insertQnABoard", adminQnABoardVO);

   }

   

   
}