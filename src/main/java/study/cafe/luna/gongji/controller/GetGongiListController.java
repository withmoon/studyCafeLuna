package study.cafe.luna.gongji.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.notice.dto.NoticeBoardDTO;
import study.cafe.luna.notice.service.NoticeBoardService;
import study.cafe.luna.util.BoardPager;

@Controller
public class GetGongiListController {
	
	@Autowired
	NoticeBoardService adminNoticeBoardService;
	// 공지사항 목록
	@RequestMapping(value = "gongjiboardList.do", method = RequestMethod.GET)
	public @ResponseBody JSONObject gongjiboardList(@RequestParam(defaultValue = "1") int curPage,
			NoticeBoardDTO noticeboardVO, HttpSession session) 
	{
		
		// 페이징 처리
		int count = adminNoticeBoardService.countNotice(noticeboardVO.getTitle());

		int page_scale = 10; // 페이지당 게시물 수
		int block_sclae = 5; // 화면당 페이지 수
		// 페이지 나누기처리
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		// 목록
		List<NoticeBoardDTO> noticeList = adminNoticeBoardService.noticeAll(start, end, session);

		JSONObject obj = new JSONObject();

		obj.put("noticeList", noticeList);
		obj.put("noticePage", boardPager);
		return obj;
	}
}
