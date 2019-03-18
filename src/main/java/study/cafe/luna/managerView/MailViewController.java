package study.cafe.luna.managerView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailViewController {
	@RequestMapping(value = "/mailView.mdo")
	public String mailView() {
		return "/manager/body/mailView";
	}
}
