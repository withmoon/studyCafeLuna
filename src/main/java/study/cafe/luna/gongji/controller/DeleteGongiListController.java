package study.cafe.luna.gongji.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import study.cafe.luna.gongji.service.DeleteGongiBoardService;
import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class DeleteGongiListController {
	@Autowired
	DeleteGongiBoardService deleteNoticeBoardService;
	
	//공지사항 삭제
	@RequestMapping(value = "/gongjidelete.do", method = RequestMethod.GET)
	public String delete(@RequestParam int num, HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");

		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			deleteNoticeBoardService.noticedelete(num);
			return "redirect:/admin/gongji.do";
		}
		return "/admin/cannotAccess";
	}
}
