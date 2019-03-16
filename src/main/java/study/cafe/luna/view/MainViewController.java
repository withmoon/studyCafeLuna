package study.cafe.luna.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.member.dto.MemberCommand;
/**
 * 
 * @author saeah
 * ø©±‰ ∏ﬁ¿Œ ∫‰¿‘¥œ¥Ÿ.
 *
 */
@Controller
public class MainViewController {
	
	//∏ﬁ¿Œ ∆«∂ß±‚ ∫‰ ¿‘¥œ¥Ÿ.
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public ModelAndView mainView(HttpSession session,MemberCommand memcom,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		//?ó¨?ÑúÎ∂??Ñ∞
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
		session.setAttribute("member", memcom);
		//?ó¨ÍπåÏ? Í≥†Ïπ®
		mav.setViewName("/public/mainpage");
		return mav;
	}
}
