package study.cafe.luna.Question.view;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.Question.dto.QuestionBoardDTO;

public class InsertQuestionBoardController {
	
	// �솕硫대쭔 �뿰寃고빐�몺 �떟湲�濡� �솕硫댁닔�젙�빐�빞�븿
		@RequestMapping(value = "/mgBoardinsert.mdo", method = RequestMethod.GET)
		public String mgboardinsertView() {
			return "/body/mgBoardinsert";
		}
	
}
