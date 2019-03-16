package study.cafe.luna.user.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.GetHowToUseListService;
import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class UseGuideController {
	@Autowired
	GetHowToUseListService getHowToUseListService;
	
	@RequestMapping(value="/useGuide.do",method=RequestMethod.GET)
	public ModelAndView useGuide(MemberDTO memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberDTO)session.getAttribute("member");
		}
		
		session.setAttribute("member", memcom);
		
		ModelAndView mav=new ModelAndView();
		
		List<HowToUseDTO> htulist=getHowToUseListService.getHowToUseList();
		mav.setViewName("/user/useGuide");
		mav.addObject("htulist",htulist);
		return mav;
	}
}
