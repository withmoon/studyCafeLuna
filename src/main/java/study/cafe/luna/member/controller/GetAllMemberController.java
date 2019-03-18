package study.cafe.luna.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.GetAllMemberCountService;
import study.cafe.luna.member.service.GetAllMemberService;
import study.cafe.luna.report.dto.ReportDTO;
import study.cafe.luna.util.BoardPager;

@Controller
public class GetAllMemberController {
	@Autowired
	GetAllMemberService getAllMemberService;
	@Autowired
	GetAllMemberCountService getAllMemberCountService;
	
	@RequestMapping(value="/getAllMember.do", method=RequestMethod.POST)
	public @ResponseBody JSONObject getAllMember(ReportDTO rpd,HttpSession session,@RequestParam("curPage") int curPage,
			@RequestParam(value="searchOption",required=false,defaultValue="") String searchOption,
			@RequestParam(value="keyword",required=false,defaultValue="") String keyword){
		MemberDTO memcom=(MemberDTO)session.getAttribute("member");
		session.setAttribute("member", memcom);

		Integer count = getAllMemberCountService.getAllMemberCount(searchOption, keyword);
		
		int page_scale = 10;
		int block_sclae = 5;
		// 페이지 나누기처리 
		BoardPager pager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = pager.getPageBegin();
		int end = pager.getPageEnd();

		List<MemberDTO> memberlist=getAllMemberService.getAllMember(start,end,searchOption, keyword);

		JSONObject obj = new JSONObject();
		obj.put("memberList", memberlist);
		obj.put("memberPage", pager);
		return obj;
	}
}
