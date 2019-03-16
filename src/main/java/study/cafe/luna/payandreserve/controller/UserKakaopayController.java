package study.cafe.luna.payandreserve.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.MemberService;
import study.cafe.luna.payment.dto.RoomPaymentDTO;
import study.cafe.luna.room.dto.RoomInfoDTO;

@Controller
public class UserKakaopayController {
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="/kakaopay.do", method=RequestMethod.GET)
	public ModelAndView kakaopayView(RoomInfoDTO roomin,MemberDTO memcom,RoomPaymentDTO roomPay,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		
		memcom = (MemberDTO) session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		memcom=memser.getMyPageInfo(memcom);
		
		mav.addObject("roomInfo",roomin);
		mav.addObject("roomPay",roomPay);
		mav.addObject("member",memcom);
		return mav;
	}
}