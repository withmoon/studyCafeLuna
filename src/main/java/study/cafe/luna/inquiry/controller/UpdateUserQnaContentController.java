package study.cafe.luna.inquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.inquiry.service.InquiryService;

@Controller
public class UpdateUserQnaContentController {
	@Autowired
	InquiryService iqser;
	
	@RequestMapping(value="/upUserQnaContent.udo",method=RequestMethod.GET) 
	public @ResponseBody void upUserQnaContent(@RequestParam("seq") int seq,@RequestParam("content") String content) {
		iqser.upUserQnaContent(seq, content);
	}
}
