package study.cafe.luna.qna.dao;

import java.util.List;

import study.cafe.luna.qna.dto.QnABoardDTO;

public interface QnABoardDAO {
	public List<QnABoardDTO> qnaAll(int start, int end); //질문목록
	public int countQnA(String subject); //질문갯수
	public QnABoardDTO qnaRead(int num) throws Exception; //질문 상세보기
	public void qupdate(QnABoardDTO vo); //질문수정
	public void qdelete(QnABoardDTO vo); //질문삭제
    public void insert(QnABoardDTO adminQnABoardVO) throws Exception;
}