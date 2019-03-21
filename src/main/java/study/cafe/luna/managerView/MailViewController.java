package study.cafe.luna.managerView;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailViewController {
	@RequestMapping(value = "/mailView.do")
	public String mailView(HttpSession session) {

		//지점장 아닐때 접근 불가
		if (session.getAttribute("branchName") == null) {
			return "/manager/body/loginX";
		}
		
		return "/manager/body/mailView";
	}
}
