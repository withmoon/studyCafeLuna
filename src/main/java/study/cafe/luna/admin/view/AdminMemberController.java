package study.cafe.luna.admin.view;

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
import study.cafe.luna.member.service.MemberService;
import study.cafe.luna.util.BoardPager;

@Controller
public class AdminMemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/member.do", method = RequestMethod.GET)
	public String mainView(HttpSession session, MemberDTO memcom) {
		memcom = (MemberDTO) session.getAttribute("member");
		if (session.getAttribute("member") == null) {
			return "/admin/cannotAccess";
		}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			return "/admin/member";
		}
		return "/admin/cannotAccess";
	}

	// 1. 회원 목록
	@RequestMapping(value = "/aMemberList.ao", method = RequestMethod.GET)
	public @ResponseBody JSONObject aMemberList(@RequestParam(defaultValue = "1") int curPage, MemberDTO mc,
			HttpSession session) {
		// 페이징 처리
		int count = memberService.countMember(mc.getId());

		int page_scale = 10; // 페이지당 게시물 수
		int block_sclae = 5; // 화면당 페이지 수
		// 페이지 나누기처리
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<MemberDTO> memberList = memberService.memberList(start, end, session);

		JSONObject obj = new JSONObject();

		obj.put("memberList", memberList);
		obj.put("memberPage", boardPager);
		return obj;
	}
}