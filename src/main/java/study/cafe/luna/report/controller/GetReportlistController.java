package study.cafe.luna.report.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.report.dto.ReportDTO;
import study.cafe.luna.report.service.ReportService;
import study.cafe.luna.util.BoardPager;

@Controller
public class GetReportlistController {
	@Autowired
	ReportService rpser;
	
	@RequestMapping(value="/getReportlist.do", method=RequestMethod.POST)
	public @ResponseBody JSONObject getReportlist(ReportDTO rpd,HttpSession session,@RequestParam("curPage") int curPage,
			@RequestParam(value="searchOption",required=false,defaultValue="title") String searchOption,
			@RequestParam(value="keyword",required=false,defaultValue="") String keyword,
			@RequestParam(value="type",required=false,defaultValue="") String type){
		//MemberCommand memcom=(MemberCommand)session.getAttribute("member");
		//session.setAttribute("member", memcom);
		
		rpd.setSearchOption(searchOption);
		rpd.setKeyword(keyword);
		
		System.out.println("내가 받아ㅗ아따 " +searchOption+" " +keyword);
	
		
		if(type.equals("admin")) {
			rpd.setId("");
		}else {
			rpd.setId("brman3");
		}
		Integer count = rpser.getReportCount(rpd);
		
		int page_scale = 3;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager pager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = pager.getPageBegin();
		int end = pager.getPageEnd();

		List<ReportDTO> reportlist=rpser.getReportlist(start, end,rpd);

		JSONObject obj = new JSONObject();
		obj.put("count", count);
		obj.put("list", reportlist);
		obj.put("pager", pager);
		return obj;
	}
}
