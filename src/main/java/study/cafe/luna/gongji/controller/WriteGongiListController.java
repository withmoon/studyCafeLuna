package study.cafe.luna.gongji.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class WriteGongiListController {
	//공지사항 입력
		@RequestMapping(value = "/gongjiwrite.do", method = RequestMethod.GET)
		public String View(HttpSession session, MemberDTO memcom) {
			memcom = (MemberDTO) session.getAttribute("member");

			if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
				memcom = (MemberDTO) session.getAttribute("member");
				session.setAttribute("member", memcom);
				return "/admin/gongjiwrite";
			}
			return "/admin/cannotAccess";	
		}

}
