package study.cafe.luna.gongji.controller;

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
import study.cafe.luna.notice.dto.NoticeBoardDTO;
import study.cafe.luna.notice.service.NoticeBoardService;
import study.cafe.luna.room.dao.RoomReviewDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;
import study.cafe.luna.util.BoardPager;

@Controller
public class ManagerGongjiController {

	@Autowired
	NoticeBoardService noticeBoardService;
	@Autowired
	ManagerDAO managerDAO;
	@Autowired
	RoomReviewDAO roomReviewDAO;

	@RequestMapping(value = "/Gongji.do")
	public ModelAndView informView(@RequestParam(defaultValue = "title") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			NoticeBoardDTO noticeboardVO, HttpSession session) {

		int count = noticeBoardService.countNotice(noticeboardVO.getTitle());

		int page_scale = 10; // �럹�씠吏��떦 寃뚯떆臾� �닔
		int block_sclae = 5; // �솕硫대떦 �럹�씠吏� �닔
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<NoticeBoardDTO> noticeList = noticeBoardService.noticeAll(start, end, session);
		// 고객의소리 최신 5개 가져오기
		List<InquiryBoardDTO> qlist = managerDAO.board();
		List<RoomReviewDTO> roomreview = roomReviewDAO.getReview(session); // 리뷰가져오기

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("boardPager", boardPager);

		map.put("qlist", qlist);
		map.put("roomreview", roomreview);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", noticeList);
		mv.addObject("map", map);
		mv.setViewName("/manager/body/board/mgNoticeBoard");
		return mv;
	}
}
