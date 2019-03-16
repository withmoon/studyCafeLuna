package study.cafe.luna.user.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.MemberService;

@Controller
public class LogOutController {
	
	@Autowired
	MemberService memser;
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(MemberDTO memcom,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		session.invalidate();
		mav.setViewName("redirect:/main.do");
		return mav;
	}
}
