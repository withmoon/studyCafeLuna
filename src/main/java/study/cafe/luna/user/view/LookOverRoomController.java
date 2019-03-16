package study.cafe.luna.user.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.room.dto.RoomInfoDTO;
import study.cafe.luna.room.service.RoomService;

@Controller
public class LookOverRoomController {
	
	@Autowired
	RoomService roomser;
	
	@RequestMapping(value="/lookover.do", method=RequestMethod.GET)
	public ModelAndView lookOverView(@RequestParam(value="sido",required=false,defaultValue="서울")String sel_sido,
										@RequestParam(value="gugun",required=false,defaultValue="")String sel_gugun,
										@RequestParam(value="seldate",required=false,defaultValue="")String sel_date,
										RoomInfoDTO romin,HttpSession session,MemberDTO memcom,HttpServletRequest request) {
		//아이디 가져와서 저장
		//여서부터
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberDTO)session.getAttribute("member");
		}
		
		session.setAttribute("member", memcom);
		//여까지 고침
		ModelAndView mav=new ModelAndView();

		List<String> sido=roomser.getSido();
		List<String> gugun=new ArrayList<String>();
		
		List<RoomInfoDTO> roomAllList=new ArrayList<RoomInfoDTO>();
		
		romin.setSidogugun(sel_sido+" "+sel_gugun);

		roomAllList=roomser.getAllRoomInfo(romin);

		mav.addObject("roomList",roomAllList);
		mav.addObject("sido",sido);
		mav.addObject("gugun",gugun);
		mav.addObject("sel_sido",sel_sido);
		mav.addObject("sel_gugun",sel_gugun);
		mav.setViewName("/user/lookover");
		return mav;
	}
	
	
}
