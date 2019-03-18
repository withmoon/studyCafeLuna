package study.cafe.luna.managerView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;

@Controller
public class MailFormViewController {

	@RequestMapping(value = "/mailForm.do")
	public String mailForm(InquiryBoardDTO vo) throws Exception {
		return "/manager/body/mailForm";
	}

}
