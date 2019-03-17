package study.cafe.luna.room.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.room.dto.RoomReviewDTO;
import study.cafe.luna.room.service.RoomReviewService;

@Controller
public class UserWriteReviewController {
	@Autowired
	RoomReviewService rrser;
	//인선트 한담에 룸넘만 반환해 주면 data에서 얘 룸넘을 찾아서 환불이면 환불이랑 영수증만 표시 환불아니면 영수증만 표시
	@RequestMapping(value="/writeReview.do",method = RequestMethod.GET)
	public @ResponseBody void insertReview(MemberDTO memcom,RoomReviewDTO rrd,@RequestParam("starCount")int starCount,@RequestParam("roomnum")int roomnum,
												@RequestParam("content")String content,HttpSession session){
		//아이디 세팅
		memcom=(MemberDTO)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		rrd.setId(memcom.getId());
		rrd.setReviewContent(content);
		rrd.setRoomNum(roomnum);
		rrd.setStarCt(starCount);
		
		//리뷰 넣기
		rrser.insertReview(rrd);
	}
}