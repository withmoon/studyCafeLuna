package study.cafe.luna.admin.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class AdminInfoController {

	@RequestMapping(value = "/admininfo.do", method = RequestMethod.GET)
	public String view(HttpSession session, MemberDTO memcom) {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			return "/admin/admininfo";
		}
		return "/admin/cannotAccess";
	}
}