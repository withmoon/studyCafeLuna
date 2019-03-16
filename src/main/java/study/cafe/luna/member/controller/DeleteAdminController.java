package study.cafe.luna.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.member.service.MemberService;

@Controller
public class DeleteAdminController {
	@Autowired
	MemberService memser;
	@RequestMapping(value="deleteAdmin.do", method=RequestMethod.POST)
	public @ResponseBody void deleteAdmin (String id) throws Exception{
		memser.deleteAdmin(id);
	}
}
