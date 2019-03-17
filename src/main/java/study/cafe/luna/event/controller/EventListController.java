package study.cafe.luna.event.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.event.dto.EventBoardDTO;
import study.cafe.luna.event.service.EventBoardService;
import study.cafe.luna.util.BoardPager;
@Controller
public class EventListController {
	@Autowired
	EventBoardService evntBoardService;
	 //이벤트목록
    //진행중인이벤트
    @RequestMapping(value="/eventNow.do", method=RequestMethod.GET)
    public @ResponseBody JSONObject eventNow(@RequestParam(defaultValue="1") int curPage,
    		EventBoardDTO eventboardVO, HttpSession session) {
    	//페이징처리
    	int count = evntBoardService.countEvent(eventboardVO.getTitle());
    				
    	int page_scale = 10;
    	int block_sclae = 5;
    	// 페이지 나누기처리 
    	BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

    	int start = boardPager.getPageBegin();
    	int end = boardPager.getPageEnd();
    				
    	List<EventBoardDTO> eventList = evntBoardService.eventAll(start, end, session);
    				
    	JSONObject obj = new JSONObject();

    	obj.put("eventList", eventList);
    	obj.put("eNowPage", boardPager);
    	return obj;
    }
    
  //종료이벤트
  	@RequestMapping(value="/eventEnd.do", method=RequestMethod.GET)
  	public @ResponseBody JSONObject eventEnd(@RequestParam(defaultValue="1") int curPage,
  			EventBoardDTO eventboardVO, HttpSession session) {
  		//페이징처리
  		int count = evntBoardService.countEventEnd(eventboardVO.getTitle());
  		
  		int page_scale = 10;
  		int block_sclae = 5;
  		// 페이지 나누기처리 
  		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

  		int start = boardPager.getPageBegin();
  		int end = boardPager.getPageEnd();
  		
  		List<EventBoardDTO> eventEndList = evntBoardService.eventEndAll(start, end, session);

  		JSONObject obj = new JSONObject();
  		
  		obj.put("eventEndList", eventEndList);
  		obj.put("eFinshPage", boardPager);
  		return obj;
  	}
}
