package study.cafe.luna.user.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.member.dto.MemberDTO;
/**
 * 
 * @author saeah
 * ���� ���� ���Դϴ�.
 *
 */
@Controller
public class MainViewController {
	
	//���� �Ƕ��� �� �Դϴ�.
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public ModelAndView mainView(HttpSession session,MemberDTO memcom,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		//?��?���??��
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberDTO)session.getAttribute("member");
		}
		session.setAttribute("member", memcom);
		//?��까�? 고침
		mav.setViewName("/public/mainpage");
		return mav;
	}
}
