package study.cafe.luna.keeproom.controller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
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
	public @ResponseBody JSONObject changekeeproom(HttpSession session,MemberDTO memcom, KeepRoomDTO krd,
			@RequestParam("roomnum")int roomnum, @RequestParam("kst") int kst) {
		memcom=(MemberDTO)session.getAttribute("member");
		JSONObject obj = new JSONObject();
	
		if(session.getAttribute("member")!=null) {
			krd.setId(memcom.getId());
			krd.setRoomnum(roomnum);
			if(kst==0) {
				rkser.deletekroom(krd);
				obj.put("result", "찜하기가 취소되었습니다.");
			}else {
				rkser.keeproom(krd);
				obj.put("result", "찜이 완료되었습니다.");
			}
		}else {
			obj.put("result", "로그인 후 이용 가능합니다.");
		}
		return obj;
	}
	
}
