package study.cafe.luna.user.view;

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

import study.cafe.luna.keeproom.dto.KeepRoomDTO;
import study.cafe.luna.keeproom.service.RoomKeepService;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.payment.dto.RoomPaymentDTO;
import study.cafe.luna.payment.dto.RoomReserveDTO;
import study.cafe.luna.room.dto.RoomFileDTO;
import study.cafe.luna.room.dto.RoomInfoDTO;
import study.cafe.luna.room.service.RoomService;

@Controller
public class RoomDetailController {
	
	@Autowired
	RoomService romser;
	@Autowired
	RoomKeepService rkser;
	
	@RequestMapping(value = "/roomDetail.do", method = RequestMethod.GET)
	public ModelAndView roomDetailView(@RequestParam(value="roomnum",required=false,defaultValue="")int roomnum,
			@RequestParam(value="seldate",required=false,defaultValue="")String seldate,
			KeepRoomDTO krd,RoomInfoDTO roomin,MemberDTO memcom,RoomPaymentDTO roomPay,RoomReserveDTO romre, HttpSession session,HttpServletRequest request)
			throws Exception {
		
		ModelAndView mav = new ModelAndView();
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
		roomin.setRoomNum(roomnum);
		roomin=romser.getDetailRoomInfo(roomin);
		
		List<RoomFileDTO> roomImgList=romser.getRoomAllimg(roomnum);
		
		//Optional<MemberCommand> maybeMember = Optional.ofNullable(memcom);
		Integer keepstate=0;
		if(memcom!=null) {
			krd.setId(memcom.getId());
			krd.setRoomnum(roomnum);
			keepstate=rkser.getKeepStatus(krd);
		}
		
		mav.addObject("roomPay",roomPay);
		mav.addObject("roomInfo",roomin);
		mav.addObject("keepstate",keepstate);
		mav.addObject("roomImgList",roomImgList);
		mav.addObject("sel_date",seldate);
		mav.addObject("romre",romre);
		mav.addObject("member", session.getAttribute("member"));
		mav.setViewName("/user/roomDetail");
		return mav;
	}
}
