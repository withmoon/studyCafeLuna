package study.cafe.luna.user.view;

import org.springframework.stereotype.Controller;

@Controller
public class ViewQnAController {
/*	@Autowired
	AdminQnABoardService qnaBoardService;
	
	//공지사항_질문사항 상세보기
	@RequestMapping(value="/viewQnA.udo", method=RequestMethod.GET)
	public ModelAndView viewQnAView(int num, HttpSession session,MemberCommand memcom,HttpServletRequest request) throws Exception {
		//여서부터
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
			if(flashMap!=null) {
				memcom.setId(flashMap.get("id").toString());
				session.setAttribute("member", memcom);
			}else {
				memcom=(MemberCommand)session.getAttribute("member");
			}
								
			session.setAttribute("member", memcom);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewQnA");
		mav.addObject("qbv", qnaBoardService.qnaRead(num));
		return mav;
	}*/
}
