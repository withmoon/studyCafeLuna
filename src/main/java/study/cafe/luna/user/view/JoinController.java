package study.cafe.luna.user.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.MemberService;

@Controller
public class JoinController {
	
	@Autowired
	MemberService memser;
	
	
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public ModelAndView mainView(@RequestParam("br") String br){
		ModelAndView mav=new ModelAndView();
		mav.addObject("br",br);
		mav.setViewName("/public/join");
		return mav;
	}
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public ModelAndView kjoinView(RedirectAttributes rdab,@RequestParam("kid") String kid, @RequestParam("knic") String knic,MemberDTO memcom){
		
		ModelAndView mav=new ModelAndView();
		memcom.setId("k#"+kid);
		
		int result=memser.idCheck(memcom);
		
		if(result==1) {
			rdab.addFlashAttribute("id", memcom.getId());
			mav.setViewName("redirect:kakao/home.do");
			return mav;
		}else{
			mav.addObject("kid", "k#"+kid);
			mav.addObject("knic",knic);
			mav.addObject("br","off");
			mav.setViewName("/public/join");
		}
		return mav;
	}
}