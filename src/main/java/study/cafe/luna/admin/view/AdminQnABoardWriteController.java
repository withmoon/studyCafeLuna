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
	QnABoardService qnaBoardService;

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
	
	/*자주묻는게시판 보기*/
	@RequestMapping(value = "/qnaview.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("num") int num, HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			mav.setViewName("/admin/qnaview");
			mav.addObject("qbv", qnaBoardService.qnaRead(num));
			return mav;
		}
		
		mav.setViewName("/admin/cannotAccess");
		return mav;
		
		
	}

	/*자주묻는게시판 쓰기*/
	@RequestMapping(value = "/insert.do")
	public String insert(@ModelAttribute QnABoardDTO adminQnABoardVO, HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			qnaBoardService.insert(adminQnABoardVO);
			return "redirect:/board.do";
		}
		return "/admin/cannotAccess";
	}
	
	/*자주묻는게시판 수정*/
	@RequestMapping(value = "/qnaupdate.do", method = RequestMethod.POST)
	public String qnaupdate(@ModelAttribute QnABoardDTO vo, @RequestParam(value="num", defaultValue="1") int num,
			   @RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
		
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setNum(num);
		
		qnaBoardService.qupdate(vo);
		return "redirect:/board.do";
	}
	
	/*자주묻는게시판 삭제*/
	@RequestMapping(value = "/qnadelete.do")
	public String deleteView(@RequestParam(value="num") int num, HttpSession session, MemberDTO memcom, QnABoardDTO vo) {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			vo.setNum(num);
			qnaBoardService.qdelete(vo);
			/*return "redirect:/board.do";*/
		}
		return "/admin/cannotAccess";

	}

}