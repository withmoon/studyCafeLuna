package study.cafe.luna.inquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.inquiry.service.InquiryService;

@Controller
public class DeleteUserQnaController {
	@Autowired
	InquiryService iqser;
	
	@RequestMapping(value="/deleteUserQna.udo",method=RequestMethod.GET) 
	public @ResponseBody void deleteUserQna(@RequestParam("seq") int seq) {
		iqser.deleteUserQna(seq);
	}
			
}
