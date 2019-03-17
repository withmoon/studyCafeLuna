package study.cafe.luna.Question.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.Question.dto.QuestionBoardDTO;

public class InsertQuestionBoardController {
	
		@RequestMapping(value = "/mgBoardinsert.mdo", method = RequestMethod.GET)
		public String mgboardinsertView() {
			return "/manager/body/mgBoardinsert";
		}
	
}
