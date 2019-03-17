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
public class UserUpReviewContentController {
	@Autowired
	RoomReviewService rrser;
	
	@RequestMapping(value="/upReviewContent.do",method = RequestMethod.GET)
	public @ResponseBody void upReviewContent(RoomReviewDTO rrd,HttpSession session,@RequestParam("reviewContent")String reviewContent,@RequestParam("roomnum")int roomnum){
		MemberDTO memcom=(MemberDTO)session.getAttribute("member");
		rrd.setId(memcom.getId());
		rrd.setReviewContent(reviewContent);
		rrd.setRoomNum(roomnum);
		rrser.upReviewContent(rrd);
	}
}
