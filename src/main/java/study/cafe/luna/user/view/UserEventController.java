package study.cafe.luna.user.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.event.service.EventBoardService;
import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class UserEventController {
	@Autowired
	EventBoardService evntBoardService;
	
	@RequestMapping(value="/userevent.do", method=RequestMethod.GET)
	public String eventView(MemberDTO memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberDTO)session.getAttribute("member");
		}
		
		return "/user/event";
	}
	
	
}
