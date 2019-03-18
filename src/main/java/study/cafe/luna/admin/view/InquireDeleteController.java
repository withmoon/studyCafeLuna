package study.cafe.luna.admin.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.Question.service.GetQuestionBoardListService;

@Controller
public class InquireDeleteController {
	@Autowired
	GetQuestionBoardListService service;

	@Autowired
	private JavaMailSender mailSender;
	  
	@RequestMapping(value = "/inquiredelete.do" ,method=RequestMethod.GET)
    public @ResponseBody void delete(@RequestParam("seq") int seq) throws Exception {
    	service.inquiredelete(seq);
    } 
	
}
