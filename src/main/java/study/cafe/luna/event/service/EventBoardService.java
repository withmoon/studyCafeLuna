package study.cafe.luna.event.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.event.dto.EventBoardDTO;

public interface EventBoardService {
	public List<EventBoardDTO> eventAll(int start, int end, HttpSession session); //진행 이벤트 목록
	public List<EventBoardDTO> eventEndAll(int start, int end, HttpSession session); //마감이벤트 목록
	public int countEvent(String title); //진행이벤트글 갯수 (페이징)
	public int countEventEnd(String title); //마감이벤트글 갯수 (페이징)
	//이벤트 글쓰기
	public Integer eventSeq(); //최대 번호 가져오기
	public void eventwrite(EventBoardDTO eboardVO); //이벤트 글 등록
	
	public EventBoardDTO read(int seq) throws Exception; //이벤트 상세보기
	
	//이벤트 수정
	public void update(EventBoardDTO eboardVO);//이벤트수정
	public Integer event_Seq();
	
    public void delete(EventBoardDTO eboardVO);//삭제
}