package study.cafe.luna.admin.view;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.qna.dto.QnABoardDTO;
import study.cafe.luna.qna.service.QnABoardService;

@Controller
public class AdminQnABoardWriteController {

	@Inject
	QnABoardService adminQnABoardService;

	@RequestMapping(value = "/qnaupdate.do", method = RequestMethod.POST)
	public String View(@ModelAttribute QnABoardDTO vo) throws Exception {
		adminQnABoardService.update(vo);
		return "redirect:/board.do";
	}

	@RequestMapping(value = "/qnadelete.do")
	public String deleteView(@RequestParam int num, HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			adminQnABoardService.delete(num);
			return "redirect:/board.do";
		}
		return "/admin/cannotAccess";

	}

	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public ModelAndView mainView(QnABoardDTO aqb, HttpSession session, MemberDTO memcom) {
		memcom = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("member")==null) {
			mav.setViewName("/admin/cannotAccess");
			return mav;
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			session.setAttribute("member", memcom);

			mav.addObject("qncontent", aqb);
			mav.setViewName("/admin/write");
			return mav;
		}
		mav.setViewName("/admin/cannotAccess");
		return mav;

	}

	@RequestMapping(value = "/qnaview.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("num") int num, HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			mav.setViewName("/admin/qnaview");
			mav.addObject("num", adminQnABoardService.read(num));
			return mav;
		}
		mav.setViewName("/admin/cannotAccess");
		return mav;
		
		
	}

	@RequestMapping(value = "/insert.do")
	public String insert(@ModelAttribute QnABoardDTO adminQnABoardVO, HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			adminQnABoardService.insert(adminQnABoardVO);
			return "redirect:/board.do";
		}
		return "/admin/cannotAccess";
	}

}