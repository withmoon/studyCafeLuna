package study.cafe.luna.keeproom.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.keeproom.dto.KeepRoomDTO;
import study.cafe.luna.keeproom.service.RoomKeepService;
import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class UserKeepRoomController {
	@Autowired
	RoomKeepService rkser;
	
	@RequestMapping("/changekeeproom.do")
	public @ResponseBody void changekeeproom(HttpSession session,MemberDTO memcom, KeepRoomDTO krd,
			@RequestParam("roomnum")int roomnum, @RequestParam("kst") int kst) {
		memcom=(MemberDTO)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		krd.setId(memcom.getId());
		krd.setRoomnum(roomnum);
		if(kst==0) {
			rkser.deletekroom(krd);
		}else {
			rkser.keeproom(krd);
		}
	}
	
}
