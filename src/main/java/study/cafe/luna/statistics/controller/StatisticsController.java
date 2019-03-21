package study.cafe.luna.statistics.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.manager.dao.ManagerDAO;
import study.cafe.luna.room.dao.RoomReviewDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;
import study.cafe.luna.statistics.dto.StatisticsDTO;
import study.cafe.luna.statistics.service.StatisticsService;
import study.cafe.luna.util.BoardPager;

@Controller
public class StatisticsController {

	@Autowired
	public StatisticsService statisticsService;
	@Autowired
	ManagerDAO managerDAO;
	@Autowired
	RoomReviewDAO roomReviewDAO;

	// 일별 예약
	@RequestMapping(value = "/Salesreserve.do")
	public ModelAndView mgSalesReserveView(@RequestParam(defaultValue = "") String date1,
			@RequestParam(defaultValue = "") String date2, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("branchName") == null) {
			System.out.println("移댁뭅�삤 濡쒓렇�씤 �떎�뙣");
			mv.setViewName("/manager/body/loginX");
			return mv;
		}

		if (date1 == null || date1.equals("")) {
			date1 = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		if (date2 == null || date2.equals("")) {
			date2 = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		session.setAttribute("date1", date1);
		session.setAttribute("date2", date2);

		String branchName = (String) session.getAttribute("branchName");
		int count = statisticsService.count(date1, date2, branchName);
		// 고객의소리 최신 5개 가져오기
		List<InquiryBoardDTO> qlist = managerDAO.board();
		List<RoomReviewDTO> roomreview = roomReviewDAO.getReview(session); // 리뷰가져오기

		int page_scale = 10;
		int block_sclae = 5;
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<StatisticsDTO> list = statisticsService.SalesReserveList(start, end, date1, date2);
		System.out.println(list);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("boardPager", boardPager);
		map.put("qlist", qlist);
		map.put("roomreview", roomreview);
		mv.addObject("map", map);
		mv.setViewName("/manager/body/sales/mgSalesreserve");
		System.out.println(map);
		return mv;
	}

}
