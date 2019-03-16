package study.cafe.luna.user.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.GetHowToUseContentService;
import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class ViewUseGuideController {
	@Autowired
	GetHowToUseContentService getHowToUseContentService;
	
	@RequestMapping("viewUseGuide.do")
	public ModelAndView viewUserGuide(@RequestParam("num") int num, MemberDTO memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberDTO)session.getAttribute("member");
		}
		
		session.setAttribute("member", memcom);
		
		ModelAndView mav=new ModelAndView();
		
		List<HowToUseDTO> htuctlist=getHowToUseContentService.getHowToUseContent(num);
		
		int size = htuctlist.size();
		
		for(HowToUseDTO htulists:htuctlist) {
			htulists.setContent(htulists.getContent().replace("<br>","\r\n"));
		}
		
		mav.setViewName("/user/viewUseGuide");
		mav.addObject("htuctlist",htuctlist);
		mav.addObject("size",size);
		return mav;
	}
}
