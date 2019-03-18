package study.cafe.luna.admin.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMailViewController {
	
	@RequestMapping(value = "/adminmail.do")
	public String mainView() {
		return "adminmail";
	}

}
