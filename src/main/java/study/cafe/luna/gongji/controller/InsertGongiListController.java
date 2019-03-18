package study.cafe.luna.gongji.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.cafe.luna.gongji.dto.AdminGongjiBoardDTO;
import study.cafe.luna.gongji.service.InsertNoticeBoardService;
import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class InsertGongiListController {
	
	@Autowired
	InsertNoticeBoardService insertNoticeBoardService;
	
	@RequestMapping(value = "/noticeinsert.do", method = RequestMethod.GET)
	public String insert(@ModelAttribute AdminGongjiBoardDTO vo, HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");

		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			insertNoticeBoardService.noticeinsert(vo);
			return "redirect:/admin/gongji.do";
		}
		return "/admin/cannotAccess";	
	}
}
