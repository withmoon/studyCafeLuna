package study.cafe.luna.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.management.dto.ManagementDTO;
import study.cafe.luna.management.service.GetManagermentService;
import study.cafe.luna.util.BoardPager;

@Controller
public class GetmanagementListController {
	@Autowired
	private GetManagermentService getManagermentService ; 

	//회원관리
	@RequestMapping(value = "/management.do")
	public ModelAndView mgSalesView(@RequestParam(defaultValue = "name") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session)
			throws Exception {

		//지점장 아닐때
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 mv.setViewName("loginX.do");
	         return mv;
		}
		
		//회원카운트
		int count = getManagermentService.countArticle(keyword);
		
		int page_scale = 20;
		int block_sclae = 3;
		//페이징 처리
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		//회원리스트
		List<ManagementDTO> list = getManagermentService.managermentList(start, end, keyword,searchOption);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);

		mv.setViewName("/manager/body/presentCondition/mgSales");
		mv.addObject("map", map);
		
		return mv;
	}
	
}
