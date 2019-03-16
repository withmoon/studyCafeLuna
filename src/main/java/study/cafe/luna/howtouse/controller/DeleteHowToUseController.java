package study.cafe.luna.howtouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import study.cafe.luna.howtouse.service.DeleteHowToUseService;

@Controller
public class DeleteHowToUseController {
	
	@Autowired
	DeleteHowToUseService deleteHowToUseService;
	
	@RequestMapping("deleteHowToUse.do")
	public String deleteHowToUse(@RequestParam("num") int num) {
		deleteHowToUseService.deleteHowToUse(num);
		return "redirect:/howtouseboard.ado";
	}
}