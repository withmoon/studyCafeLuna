package study.cafe.luna.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.MemberService;

@Controller
public class GetAdminListController {
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="getAdminList.do", method=RequestMethod.POST)
	public @ResponseBody List<MemberDTO> getAdminList (){
		List<MemberDTO> list=memser.getAdminList();
		return list;
	}
}
