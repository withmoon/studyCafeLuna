package study.cafe.luna.mRoom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.mRoom.dao.MRoomDAO;
import study.cafe.luna.manager.dao.ManagerDAO;
import study.cafe.luna.room.dao.RoomReviewDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;

@Controller
public class MRoomUploadController {

	@Autowired
	ManagerDAO managerDAO;
	@Autowired
	public MRoomDAO MRoomDAO;
	@Autowired
	RoomReviewDAO roomReviewDAO;
	
	// 방생성 화면
	@RequestMapping(value = "/mRoomUpload.do", method = RequestMethod.GET)
	public ModelAndView mgRoomUpload(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		// ,방번호 , 주소
		int roomcount = MRoomDAO.roomcount();
		String roomLocate = MRoomDAO.roomLocate(session);
		String comeRoute= session.getAttribute("branchaddr1")+" "+session.getAttribute("branchaddr2")+" "+session.getAttribute("branchName");
		System.out.println(comeRoute);
		//String 
		
		// 고객의소리 최신 5개 가져오기
		List<InquiryBoardDTO> qlist = managerDAO.board();
		List<RoomReviewDTO> roomreview = roomReviewDAO.getReview(session); // 리뷰가져오기


		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qlist", qlist);
		map.put("roomreview", roomreview);
		map.put("branchName", session.getAttribute("branchName"));
		map.put("comeroute",comeRoute);
		map.put("session", session);//?
		map.put("roomcount", roomcount);
		map.put("roomLocate", roomLocate);
		mv.setViewName("/manager/body/room/roomupload");
		mv.addObject("map", map);

		return mv;
	}
}
