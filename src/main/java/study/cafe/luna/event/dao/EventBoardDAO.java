package study.cafe.luna.event.dao;

import java.util.List;

import study.cafe.luna.event.dto.EventBoardDTO;


public interface EventBoardDAO {
	public List<EventBoardDTO> eventAll(int start, int end); //진행 이벤트 목록
	public List<EventBoardDTO> eventEndAll(int start, int end); //마감이벤트 목록
	public int countEvent(String title); //진행count
	public int countEventEnd(String title); //마감count
	
	//이벤트 글쓰기
	public Integer eventSeq(); //최대 번호 가져오기
	public void eventwrite(EventBoardDTO eboardVO); //이벤트 글 등록
	
	public EventBoardDTO read(int seq) throws Exception; //이벤트 상세보기
	public void update(EventBoardDTO eboardVO); //수정
	public Integer event_Seq(); //최대 번호 가져오기
    
	public void delete(EventBoardDTO eboardVO);//삭제
}