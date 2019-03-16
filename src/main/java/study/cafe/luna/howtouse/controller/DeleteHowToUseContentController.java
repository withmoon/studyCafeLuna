package study.cafe.luna.howtouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.DeleteHowToUseContentService;

@Controller
public class DeleteHowToUseContentController {
	
	@Autowired
	DeleteHowToUseContentService deleteHowToUseContentService;
	
	@RequestMapping(value="deleteHowToUseContent.do",method=RequestMethod.POST)
	public @ResponseBody void deleteHowToUseContent(HowToUseDTO htu){
		deleteHowToUseContentService.deleteHowToUseContent(htu);
	}
}
