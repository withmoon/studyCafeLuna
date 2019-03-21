package study.cafe.luna.qna.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.qna.dto.QnABoardDTO;

public interface QnABoardService {
	public List<QnABoardDTO> qnaAll(int start, int end, HttpSession session); //질문목록
	public int countQnA(String subject); //질문 갯수
	public QnABoardDTO qnaRead(int num) throws Exception; //질문 상세보기
	public void qupdate(QnABoardDTO vo); //질문 수정
	public void qdelete(QnABoardDTO vo); //질문삭제
    public void insert(QnABoardDTO vo) throws Exception;
}