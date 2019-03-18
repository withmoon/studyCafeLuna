package study.cafe.luna.inquiry.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.inquiry.service.InquiryService;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.util.BoardPager;
@Controller
public class GetUserQnAllController {
	@Autowired
	InquiryService iqser;
	
	@RequestMapping(value="/qnalist.do",method=RequestMethod.GET) 
	public @ResponseBody JSONObject getUserQnAll(HttpSession session,MemberDTO memcom,
																		@RequestParam(value="curpage",defaultValue = "1") int curPage) {
		memcom=(MemberDTO)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		int count =iqser.getUserQnCount(memcom.getId());
		
		int page_scale = 3;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager pager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = pager.getPageBegin();
		int end = pager.getPageEnd();

		//알림 정보 가져오기
		List<InquiryBoardDTO> qnalist=iqser.getUserQnAll(start,end,memcom.getId());
		
		JSONObject obj = new JSONObject();
		obj.put("alist", qnalist);
		obj.put("apager", pager);
		return obj;
	}
}
