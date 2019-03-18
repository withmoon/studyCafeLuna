package study.cafe.luna.admin.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class ReportWriteController {

	

	@RequestMapping(value="/reportwrite.do")
	public String write(HttpSession session, MemberDTO memcom) {
		memcom = (MemberDTO) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);

			return "/admin/reportwrite";
		}
		return "/admin/cannotAccess";

	}

}
