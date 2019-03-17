package study.cafe.luna.admin.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.GetHowToUseListService;
import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class HowToUseController {
	@Autowired
	GetHowToUseListService getHowToUseListService;
	
	@RequestMapping(value="/howtouseboard.do")
	public ModelAndView mains(HttpSession session, MemberDTO memcom) {
		ModelAndView mav=new ModelAndView();
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		mav.setViewName("/admin/cannotAccess");
    		return mav;
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			List<HowToUseDTO> htulist=getHowToUseListService.getHowToUseList();
			mav.addObject("htulist",htulist);
			mav.setViewName("/admin/howtouseboard");
			return mav;
		}
		mav.setViewName("/admin/cannotAccess");
		return mav;
	}
	
	
}
