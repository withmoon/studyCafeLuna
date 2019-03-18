package study.cafe.luna.admin.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InquireController {
	@RequestMapping(value = "/inquire.do")
	public String view() {
		return "/admin/inquire";
	}

}
