package study.cafe.luna.user.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.event.dto.EventReplyDTO;
import study.cafe.luna.event.service.EventBoardService;
import study.cafe.luna.event.service.EventReplyService;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.util.BoardPager;

@Controller
public class ViewEventController {
	@Autowired
	EventBoardService eventBoardService;
	@Autowired
	EventReplyService eventReplyService;
	
	//이벤트 상세보기
	@RequestMapping(value="/viewEvent.do", method=RequestMethod.GET)
	public ModelAndView viewEventView( int seq, HttpSession session,MemberDTO memcom,HttpServletRequest request) throws Exception {
		//여서부터
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberDTO)session.getAttribute("member");
		}
								
		session.setAttribute("member", memcom);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/viewEvent");
		mav.addObject("ebv", eventBoardService.read(seq));
		return mav;
	}
	
	//댓글 목록
	@RequestMapping(value="/eReplyList.do", method=RequestMethod.GET)
	public @ResponseBody JSONObject eReplyView(@RequestParam(value="seq") int seq, @RequestParam(defaultValue="1") int curPage,
											MemberDTO memcom, EventReplyDTO eReplyVO,  HttpSession session) {
		eReplyVO.setSeq(seq);
		memcom=(MemberDTO)session.getAttribute("member");
		
		//페이징 처리
		int count = eventReplyService.counteReply(seq);
		int page_scale = 5; // 페이지당 게시물 수
		int block_sclae = 10; // 화면당 페이지 수
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<EventReplyDTO> eReplyList = eventReplyService.eReplyList(seq, start, end, session);
			
		JSONObject obj = new JSONObject();
		if(memcom!=null) {
			obj.put("userid", memcom.getId());
		}
		obj.put("eReplyList", eReplyList);
		obj.put("eReplyPage", boardPager);
		return obj;
	}
	
	//댓글 입력
	@RequestMapping(value="/eReplyInsert.do", method=RequestMethod.POST)
	public @ResponseBody void eReplyInsert(@RequestParam(value="content") String content, @RequestParam(value="bseq") int seq,
											EventReplyDTO eReplyVO, HttpSession session) {
		
		MemberDTO memcom= (MemberDTO) session.getAttribute("member");
		
		eReplyVO.setReplyer(memcom.getId());
		eReplyVO.setReplytext(content);
		eReplyVO.setSeq(seq);
		eventReplyService.create(eReplyVO);
	}
	
	//댓글 수정
	@RequestMapping(value="/eReplyUpdate.do", method=RequestMethod.POST)
	public @ResponseBody void eReplyUpdate(EventReplyDTO eReplyVO,HttpSession session, @RequestParam(value="rno", defaultValue="1") int rno,
											@RequestParam(value="content") String content) {
		eReplyVO.setReplytext(content);
		eReplyVO.setRno(rno);
		eventReplyService.eReplyUp(eReplyVO);
	}
	 
	//댓글 삭제
	@RequestMapping(value="/eReplyDelete.do", method=RequestMethod.POST)
	public @ResponseBody void eReplyDelete(EventReplyDTO eReplyVO,HttpSession session, @RequestParam(value="rno", defaultValue="1") int rno) {
		eReplyVO.setRno(rno);
		eventReplyService.eReplyDe(eReplyVO);
	}
}