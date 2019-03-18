package study.cafe.luna.Question.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.inquiry.service.InquiryService;

@Controller
public class GetQuestionBoardController {

	@Autowired
	private InquiryService getQuestionBoardService;

	@RequestMapping(value = "/mgBoardview.do")
	public ModelAndView mgboardinsertView(@RequestParam int num, @RequestParam int curPage, InquiryBoardDTO vo,
			@RequestParam String searchOption, @RequestParam String keyword, HttpSession session) throws Exception {
		vo.setBranchName((String) session.getAttribute("branchName"));
		vo.setSeq(num);
		System.out.println("세션 id" + vo.getBranchName());

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/manager/body/board/mgBoardview");
		mv.addObject("view", getQuestionBoardService.QbaordRead(vo));
		return mv;

	}

}
