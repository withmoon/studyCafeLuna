package study.cafe.luna.admin.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("moveUserMode.do")
	public String moveUserMode(){
		return "/public/mainpage";
	}
	@RequestMapping("moveAdminMode.do")
	public String moveAdminMode() {
		return "/admin/admin";
	}
	
}
