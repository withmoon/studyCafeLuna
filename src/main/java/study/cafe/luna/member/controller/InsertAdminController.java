package study.cafe.luna.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.MemberService;
import study.cafe.luna.util.SHA256;

@Controller
public class InsertAdminController {
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="insertAdmin.do", method=RequestMethod.POST)
	public @ResponseBody void insertAdmin (MemberDTO memcom) throws Exception{
		//비번 암호화
		SHA256 sha=SHA256.getInsatnce();
		String shaPass=sha.getSha256(memcom.getPw().getBytes());
		memcom.setPw(shaPass);
		
		memser.insertAdmin(memcom);
	}
}
