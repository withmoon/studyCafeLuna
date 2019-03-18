package study.cafe.luna.gongji.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.util.BoardPager;

@Controller
public class GetGongiReplyController {

	// 댓글목록
//	@RequestMapping(value = "/aGReplyList.do", method = RequestMethod.GET)
//	public @ResponseBody JSONObject aGReplyView(@RequestParam(value = "num") int num,
//			@RequestParam(defaultValue = "1") int curPage, MemberDTO memcom, NoticeReplyVO gReplyVO,
//			HttpSession session) {
//		gReplyVO.setNum(num);
//
//		// 페이징 처리
//		int count = nReplyService.countnReply(num);
//		int page_scale = 5; // 페이지당 게시물 수
//		int block_sclae = 10; // 화면당 페이지 수
//		// 페이지 나누기처리
//		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);
//
//		int start = boardPager.getPageBegin();
//		int end = boardPager.getPageEnd();
//
//		List<NoticeReplyVO> nReplyList = nReplyService.nReplyList(num, start, end, session);
//
//		JSONObject obj = new JSONObject();
//		obj.put("nReplyList", nReplyList);
//		obj.put("nReplyPage", boardPager);
//		return obj;
//	}
}
