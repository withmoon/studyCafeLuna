package study.cafe.luna.keeproom.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.keeproom.dto.KeepRoomDTO;
import study.cafe.luna.keeproom.service.RoomKeepService;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.room.dto.RoomInfoDTO;
import study.cafe.luna.util.BoardPager;
@Controller
public class UserKeepListController {
	@Autowired
	RoomKeepService rkser;
	

	@RequestMapping(value="/keeproomlist.do",method=RequestMethod.GET) 
	public @ResponseBody JSONObject changekeeproom(HttpSession session,MemberDTO memcom, KeepRoomDTO krd,
																		@RequestParam(value="curpage",defaultValue = "1") int curPage) {
		memcom=(MemberDTO)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		int count = rkser.getKeepCount(memcom.getId());
		
		int page_scale = 4;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager keepPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = keepPager.getPageBegin();
		int end = keepPager.getPageEnd();

		List<RoomInfoDTO> list = rkser.getKeeplist(start, end, memcom.getId());
		JSONObject obj = new JSONObject();
		obj.put("klist", list);
		obj.put("kpager", keepPager);
		return obj;
	}
}
