package study.cafe.luna.managerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.manager.dao.ManagerDAO;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.room.dao.RoomReviewDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;

@Controller
public class EventViewController {
	@Autowired
	ManagerDAO managerDAO;
	@Autowired
	RoomReviewDAO roomReviewDAO;

	@RequestMapping(value = "/Event.do")
	public ModelAndView eventView(MemberDTO memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		Map<String, Object> map = new HashMap<String, Object>();
		if (flashMap != null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		} else {
			memcom = (MemberDTO) session.getAttribute("member");
		}

		//고객의소리 최신 5개 가져오기
	    List<InquiryBoardDTO> qlist = managerDAO.board();
	    List<RoomReviewDTO> roomreview = roomReviewDAO.getReview(session); //리뷰가져오기
	    map.put("qlist", qlist);
	    map.put("roomreview",roomreview);
	    
		// 지점장 아닐때 접근 불가
		ModelAndView mv = new ModelAndView();
		mv.addObject("map",map);
		
		if (session.getAttribute("branchName") == null) {
			mv.setViewName("/manager/body/loginX");
			return mv;
		}
		mv.setViewName("/manager/body/board/mgEvent");
		return mv;
	}

}
