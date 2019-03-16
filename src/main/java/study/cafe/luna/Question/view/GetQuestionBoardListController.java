package study.cafe.luna.Question.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.Question.service.GetQuestionBoardListService;
import study.cafe.luna.Question.service.MgService;
import study.cafe.luna.util.BoardPager;

public class GetQuestionBoardListController {

	/* 고객의소리 게시판  */
	@RequestMapping(value = "/mgBoard.mdo")
	public ModelAndView mgBoardView(@RequestParam(defaultValue = "title") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("branchName") == null) {
			System.out.println("移댁뭅�삤 濡쒓렇�씤 �떎�뙣");
			mv.setViewName("/body/loginX");
			return mv;
		}

		String branchName = (String) session.getAttribute("branchName");
		System.out.println(branchName + "吏��젏 臾몄쓽寃뚯떆湲�");
		
		// 게시글 수 구하기
//		int count = GetQuestionBoardListService.countArticle(searchOption, keyword, branchName);
//		System.out.println(count + "媛�");

		int page_scale = 10;
		int block_sclae = 5;
		// 페이징 처리
//		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);
//		int start = boardPager.getPageBegin();
//		int end = boardPager.getPageEnd();

//		List<QuestionBoardDTO> list = MgService.QboardList(start, end, searchOption, keyword, branchName);

		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("list", list);
//		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
//		map.put("boardPager", boardPager);

		mv.addObject("map", map);
		mv.setViewName("body/board/mgBoard");

		return mv;
	}
	
}
