package study.cafe.luna.Question.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.Question.service.GetQuestionBoardListService;
import study.cafe.luna.util.BoardPager;

@Controller
public class GetQuestionBoardListController {
	@Autowired
	private GetQuestionBoardListService  questionBoardListService;
	
	/* 고객의소리 게시판  */
	@RequestMapping(value = "/QuestionBoardList.do")
	public ModelAndView mgBoardView(@RequestParam(defaultValue = "title") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session) throws Exception {
		
		//지점장 아닐때 접근 불가
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("branchName") == null) {
			mv.setViewName("/manager/body/loginX");
			return mv;
		}
		
		String branchName = (String) session.getAttribute("branchName");
		 
		// 게시글 수 구하기
		int count = questionBoardListService.countArticle(searchOption, keyword, branchName);

		int page_scale = 10;
		int block_sclae = 5;
		// 페이징 처리
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);
		int start = 1;
		start = boardPager.getPageBegin();
		int end = 1;
		end = boardPager.getPageEnd();

		//고객의소리 리스트 가져오기
		List<QuestionBoardDTO> list = questionBoardListService.QuestionList(start, end, searchOption, keyword, branchName);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);

		mv.addObject("map", map);
		mv.setViewName("/manager/body/board/mgBoard");

		return mv;
	}
	
}
