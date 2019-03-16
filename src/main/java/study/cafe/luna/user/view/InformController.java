package study.cafe.luna.user.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class InformController {
//	@Autowired
//	AdminNoticeBoardService noticeBoardService;
//	@Autowired
//	AdminQnABoardService qnaBoardService;
//	@Autowired
//	MgService qboardService;
//	@Autowired
//	RoomService roomser;
	
	//공지사항 목록
	@RequestMapping(value="/inform.udo", method=RequestMethod.GET)
	public ModelAndView viewinform(ModelAndView mav, MemberDTO memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberDTO)session.getAttribute("member");
		}
		
		//List<String> sido=roomser.getSido();
		//mav.addObject("sido",sido);
		
		return mav;
	}
	
	/*@RequestMapping(value="/informlist.udo", method=RequestMethod.GET)
	public @ResponseBody JSONObject informView(@RequestParam(defaultValue="1") int curPage, AdminNoticeBoardVO noticeboardVO,
									HttpSession session) {
		//페이징 처리
		int count = noticeBoardService.countNotice(noticeboardVO.getTitle());
		//int count = noticeBoardService.countNotice(mav);
		

		int page_scale = 10; // 페이지당 게시물 수
		int block_sclae = 5; // 화면당 페이지 수
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		//목록
		List<AdminNoticeBoardVO> noticeList = noticeBoardService.noticeAll(start, end, session);
		
		JSONObject obj = new JSONObject();

		obj.put("noticeList", noticeList);
		obj.put("noticePage", boardPager);
		return obj;
	}
	
	//자주묻는 질문 목록
	@RequestMapping(value="/informChange.udo", method=RequestMethod.GET)
	public @ResponseBody JSONObject informQnNAView(@RequestParam(defaultValue="1") int curPage,
													AdminQnABoardVO qnaBoardVO, HttpSession session) {
		//페이징 처리
		int count = qnaBoardService.countQnA(qnaBoardVO.getSubject());
		//int count = qnaBoardService.countQnA(mav);
		
		int page_scale = 10;
		int block_sclae = 5;
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		//목록
		List<AdminQnABoardVO> qnaList = qnaBoardService.qnaAll(start, end, session);
		
		JSONObject obj = new JSONObject();

		obj.put("qnaList", qnaList);
		obj.put("qnaPage", boardPager);
		return obj;
	}
	
	//고객의 소리 insert
	@RequestMapping(value="/informUser.udo", method=RequestMethod.POST)
	public @ResponseBody void informUser(@RequestParam(value="branchName") String branchName,
										@RequestParam(value="title") String title, @RequestParam(value="content") String content,
										QBoardVO qboardVO, HttpSession session) {
		
		MemberCommand memcom= (MemberCommand) session.getAttribute("member");

		qboardVO.setId(memcom.getId());
		qboardVO.setBranchName(branchName);
		qboardVO.setTitle(title);
		qboardVO.setContent(content);
		
		qboardService.create(qboardVO);
	}*/
}
