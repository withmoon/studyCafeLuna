package study.cafe.luna.room.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.GetMemberPositionService;
import study.cafe.luna.room.dto.RoomReviewDTO;
import study.cafe.luna.room.service.RoomReviewService;
import study.cafe.luna.util.BoardPager;

@Controller
public class UserGetRoomAllReviewController {
	@Autowired
	RoomReviewService rrser;
	@Autowired
	GetMemberPositionService getMemberPositionService;
	
	@RequestMapping(value="/getRoomAllReview.do",method = RequestMethod.GET)
	public @ResponseBody JSONObject getSidoGugung(HttpSession session,@RequestParam("curpage")int curPage,@RequestParam("roomnum")int roomnum){
		
		MemberDTO memcom=(MemberDTO)session.getAttribute("member");
		session.setAttribute("member", memcom);
	
		
		int count = rrser.getReviewCount(roomnum);
		
		int page_scale = 10;
		int block_sclae = 10;
		// 페이지 나누기처리 
		BoardPager reviewPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = reviewPager.getPageBegin();
		int end = reviewPager.getPageEnd();

		
		List<RoomReviewDTO> allreviewlist=rrser.getRoomAllReview(start,end,roomnum);
		String reviewscore=rrser.getReviewStarAvg(roomnum);
		if(session!=null&memcom!=null) {
			memcom=getMemberPositionService.getMemberPosition(memcom.getId());
		}
		JSONObject obj = new JSONObject();
		obj.put("rvlist", allreviewlist);
		if(memcom!=null) {
			obj.put("member", memcom);
		}
		obj.put("rvpager", reviewPager);
		obj.put("rvscore", reviewscore);
		return obj;
	}
}
