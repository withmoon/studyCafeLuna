package study.cafe.luna.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.event.dto.EventBoardDTO;
import study.cafe.luna.event.service.EventBoardService;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.util.BoardPager;


@Controller
public class EventController {
	@Autowired
	EventBoardService evntBoardService;
    
	@RequestMapping(value="/event.do", method=RequestMethod.GET)
    public String evenView(MemberDTO memcom,HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException {
    	 memcom = (MemberDTO) session.getAttribute("member");
    	if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
   		if(memcom.getPosition().equals("총관리자")|memcom.getPosition().equals("관리자")){
   			memcom = (MemberDTO) session.getAttribute("member");
   			session.setAttribute("member", memcom);
	        return "/admin/event";
   		}else {
   			return "/admin/cannotAccess";
   		}
	}
}
 