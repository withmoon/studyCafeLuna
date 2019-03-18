package study.cafe.luna.admin.view;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.cafe.luna.mailSending.service.AdminManagerApproveService;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.MemberService;

@Controller
public class ApproveController {
	
	@Inject
	AdminManagerApproveService adminManagerApproveService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/approve.do", method=RequestMethod.GET)
	   public String mainView(HttpSession session,MemberDTO memcom) {
		 memcom = (MemberDTO) session.getAttribute("member");
	    	
	   		if(memcom.getPosition().equals("총관리자")|memcom.getPosition().equals("관리자")){
	   			memcom = (MemberDTO) session.getAttribute("member");
	   			session.setAttribute("member", memcom);
		        return "/admin/approve";
	   		}
	   		return "/admin/cannotAccess";
	}
}
