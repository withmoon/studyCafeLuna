package study.cafe.luna.admin.view;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import study.cafe.luna.mailSending.service.AdminManagerApproveService;
import study.cafe.luna.mailSending.service.DeleteApproveservice;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.MemberService;

@Controller
public class ApproveDeleteController {
	@Inject
	DeleteApproveservice deleteApproveservice;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/approvedelete.do")
	public String approvedelete(@RequestParam("id")String id , @RequestParam("type")String type,HttpSession session,MemberDTO memcom)throws Exception{
		 memcom = (MemberDTO) session.getAttribute("member");
	    	
	   		if(memcom.getPosition().equals("총관리자")|memcom.getPosition().equals("관리자")){
	   			memcom = (MemberDTO) session.getAttribute("member");
	   			session.setAttribute("member", memcom);
	   			deleteApproveservice.approvedelete(id);
	   			return "redirect:/admin/"+type+".do";
	   		}
	   			return "/admin/cannotAccess";
	}
}
