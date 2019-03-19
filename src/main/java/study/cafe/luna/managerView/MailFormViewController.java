package study.cafe.luna.managerView;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;

@Controller
public class MailFormViewController {

	@RequestMapping(value = "/mailForm.do")
	public String mailForm(InquiryBoardDTO vo,HttpSession session) throws Exception {
		
		//지점장 아닐때 접근 불가
		if (session.getAttribute("branchName") == null) {
			return "/manager/body/loginX";
		}
		
		return "/manager/body/mailForm";
	}

}
