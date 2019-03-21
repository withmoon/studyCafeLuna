package study.cafe.luna.Reserve.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.Reserve.dto.ReserveDTO;
import study.cafe.luna.Reserve.service.ReserveService;
import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.manager.dao.ManagerDAO;
import study.cafe.luna.room.dao.RoomReviewDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;
import study.cafe.luna.util.BoardPager;

@Controller
public class GetReserveController {
	// �쁽�솴

	@Autowired
	private ReserveService reserveService;
	@Autowired
	ManagerDAO managerDAO;
	@Autowired
	RoomReviewDAO roomReviewDAO;

	// 예약현황
	@RequestMapping(value = "/Reserve.do")
	public ModelAndView mgReserveView(@RequestParam(defaultValue = "roomnum") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("branchName") == null) {
			System.out.println("移댁뭅�삤 濡쒓렇�씤 �떎�뙣");
			mv.setViewName("loginX.do");
			return mv;
		}

		String branchName = (String) session.getAttribute("branchName");
		int count = reserveService.ReserveCount(searchOption, keyword, branchName);

		int page_scale = 20;
		int block_sclae = 5;
		// �럹�씠吏� �굹�늻湲곗쿂由�
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<ReserveDTO> list = reserveService.mgReserveList(start, end, searchOption, keyword, branchName);
		// 고객의소리 최신 5개 가져오기
		List<InquiryBoardDTO> qlist = managerDAO.board();
		List<RoomReviewDTO> roomreview = roomReviewDAO.getReview(session); // 리뷰가져오기

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qlist", qlist);
		map.put("roomreview", roomreview);
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);

		mv.addObject("map", map);
		mv.setViewName("/manager/body/presentCondition/mgReserve");

		return mv;
	}

}
