package study.cafe.luna.user.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoundBranchController {
	
	@RequestMapping(value="/foundbranch.do", method=RequestMethod.GET)
	public String foundBranchView() {
		return "/user/foundbranch";
	}
}
