package study.cafe.luna.mRoom.controller;

import java.io.File;
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
import study.cafe.luna.mRoom.dao.MRoomDAO;
import study.cafe.luna.mRoom.dto.MRoomDTO;
import study.cafe.luna.mRoom.service.MRoomListService;
import study.cafe.luna.manager.dao.ManagerDAO;
import study.cafe.luna.room.dao.RoomReviewDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;
import study.cafe.luna.util.BoardPager;

@Controller
public class MRoomListController {

	@Autowired
	public MRoomListService listService;
	@Autowired
	public MRoomDAO MRoomDAO;
	@Autowired
	ManagerDAO managerDAO;
	@Autowired
	RoomReviewDAO roomReviewDAO;

	// 저장할 파일폴더
	String filePath = "C:\\Users\\진혁\\git\\studyCafeLuna\\src\\main\\webapp\\resources\\rooms\\";

	// 방관리화면
	@RequestMapping(value = "/mRoom.do")
	public ModelAndView mgRoomList(MRoomDTO vo, @RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String keyword, HttpSession session,
			@RequestParam(defaultValue = "1") int curPage) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("branchName") == null) {
			System.out.println("카카오 로그인 실패");
			mv.setViewName("loginX.mdo");
			return mv;
		}

		// 디렉토리 없으면 생성
		File dir = new File(filePath);
		if (!dir.isDirectory()) {
			System.out.println("디렉토리생성");
			dir.mkdirs();
		}
		// 리스트 갯수 계산
		int count = MRoomDAO.countArticle(searchOption, keyword, session);
		// 고객의소리 최신 5개 가져오기
		List<InquiryBoardDTO> qlist = managerDAO.board();
		List<RoomReviewDTO> roomreview = roomReviewDAO.getReview(session); // 리뷰가져오기

		System.out.println(count + "개");

		int page_scale = 15;
		int block_sclae = 5;
		// 페이지 나누기처리
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<MRoomDTO> list = listService.RoomList(session, start, end, vo, searchOption, keyword);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qlist", qlist);
		map.put("roomreview", roomreview);
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);

		mv.addObject("map", map);
		mv.setViewName("/manager/body/room/mgRoom");

		return mv;
	}

}
