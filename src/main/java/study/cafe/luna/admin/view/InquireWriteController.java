package study.cafe.luna.admin.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.inquiry.service.InquiryService;
import study.cafe.luna.member.dto.MemberDTO;

@Controller 
public class InquireWriteController {
	@Autowired
	InquiryService service;

	
	@RequestMapping(value = "/inquirewrite.do")
	public ModelAndView views(@RequestParam Integer seq,HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			mav.setViewName("/admin/inquirewrite");
			mav.addObject("seq", service.inquireread(seq));
			return mav;
		}
		mav.setViewName("cannotAccess");
		return mav;
	}
}
