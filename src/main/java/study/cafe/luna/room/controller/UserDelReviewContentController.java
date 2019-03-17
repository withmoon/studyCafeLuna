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
public class UserDelReviewContentController {
	@Autowired
	RoomReviewService rrser;
	
	@RequestMapping(value="/delReviewContent.do",method = RequestMethod.GET)
	public @ResponseBody void delReviewContent(RoomReviewDTO rrd,HttpSession session,@RequestParam("roomnum")int roomnum,
			@RequestParam(value="id",required=false,defaultValue="")String id
			){
		rrd.setId(id);
		if(id.equals("")) {
			MemberDTO memcom=(MemberDTO)session.getAttribute("member");
			rrd.setId(memcom.getId());
		}
		rrd.setRoomNum(roomnum);
		rrser.delReviewContent(rrd);
	}
}
