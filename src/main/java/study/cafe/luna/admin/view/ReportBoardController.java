package study.cafe.luna.admin.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class ReportBoardController {

	@RequestMapping(value="/reportboard.do")
	public String report(HttpSession session, MemberDTO memcom) {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			return "/admin/reportboard";
		}
		return "/admin/cannotAccess";
		

	}

}
