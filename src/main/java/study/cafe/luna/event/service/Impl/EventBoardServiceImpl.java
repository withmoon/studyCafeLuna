package study.cafe.luna.event.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.event.dao.Impl.EventBoardDAOImpl;
import study.cafe.luna.event.dto.EventBoardDTO;
import study.cafe.luna.event.service.EventBoardService;

@Service
public class EventBoardServiceImpl implements EventBoardService{
   
   @Autowired
   EventBoardDAOImpl eventBoardImpl;
   
   //진행이벤트목록
   @Override
   public List<EventBoardDTO> eventAll(int start, int end, HttpSession session) {
	   return eventBoardImpl.eventAll(start, end);
   }

   //종료이벤트목록
   @Override
   public List<EventBoardDTO> eventEndAll(int start, int end, HttpSession session) {
	   return eventBoardImpl.eventEndAll(start, end);
   }

   //진행이벤트글 갯수
   @Override
   public int countEvent(String title) {
	   return eventBoardImpl.countEvent(title);
   }
 	
   //종료이벤트글 갯수
   @Override
   public int countEventEnd(String title) {
	   return eventBoardImpl.countEventEnd(title);
   }
   
   //이밴트 글쓰기
   /*최대 번호 가져오기*/
   @Override
   public Integer eventSeq() {
	   return eventBoardImpl.eventSeq();
   }
   /*이벤트 글 등록*/
   @Override
   public void eventwrite(EventBoardDTO eboardVO) {
	   eventBoardImpl.eventwrite(eboardVO);
   }
 	
   //이벤트 상세보기
   @Override
   public EventBoardDTO read(int seq) throws Exception {
	   return eventBoardImpl.read(seq);
   }

   //이벤트 수정
   @Override
   public void update(EventBoardDTO eboardVO) {
	   eventBoardImpl.update(eboardVO);
   }
   @Override
	public Integer event_Seq() {
	   return eventBoardImpl.event_Seq();
	}

   //이벤트 삭제
   @Override
   public void delete(EventBoardDTO eboardVO) {
	   eventBoardImpl.delete(eboardVO);
   }
}