package study.cafe.luna.user.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.MemberService;

@Controller
public class IdCheckController {

	@Autowired
	MemberService memser;

	// @RequestParam("id") String id
	@RequestMapping(value = "join/idCheck.do", method = RequestMethod.POST)
	public ModelAndView idCehckjoin(MemberDTO memcom) {
		ModelAndView mav = new ModelAndView();

		int result = memser.idCheck(memcom);

		String message = result == 1 ? "중복된 아이디입니다" : "사용가능한 아이디입니다.";
		String btnMessage = result == 1 ? "다시입력" : "사용하기";

		mav.addObject("member", memcom);
		mav.addObject("message", message); // 존재하는 아이디 입니다.
		mav.addObject("btnMessage", btnMessage); // 닫기
		mav.setViewName("/public/idCheck");

		return mav;
	}

	
}
