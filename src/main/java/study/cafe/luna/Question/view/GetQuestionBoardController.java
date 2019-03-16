package study.cafe.luna.Question.view;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.Question.service.GetQuestionBoardService;

public class GetQuestionBoardController {
	@RequestMapping(value = "/mgBoardview.do")
	public ModelAndView mgboardinsertView(@RequestParam int num, @RequestParam int curPage, QuestionBoardDTO vo,
			@RequestParam String searchOption, @RequestParam String keyword, HttpSession session) throws Exception {
		//	議고쉶�닔 ��鍮� MgService.increaseViewcnt(bno, session);*/
		vo.setBranchName((String) session.getAttribute("branchName"));
		vo.setSeq(num);
		System.out.println("세션 id" + vo.getBranchName());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/board/mgBoardview");
//		mv.addObject("view", GetQuestionBoardService.QbaordRead(vo));
		return mv;
	}
}
