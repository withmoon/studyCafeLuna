package study.cafe.luna.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.member.service.MemberService;

@Controller
public class GetBranchNameController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/branchName.do")
	public @ResponseBody List<String> branchName(@RequestParam(value="undefined", defaultValue="서초구")String gugun){
		List<String> branchList = memberService.branchList(gugun);
		return branchList;
	}
}
