package study.cafe.luna.payandreserve.controller;

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
import study.cafe.luna.payandreserve.service.PayAndReserveService;
import study.cafe.luna.room.dto.MyPageInfoDTO;
import study.cafe.luna.util.BoardPager;

@Controller
public class UserGetReserveListController {
	@Autowired
	PayAndReserveService parser;
	
	@RequestMapping(value="/getReserveList.do",method=RequestMethod.GET) 
	public @ResponseBody JSONObject changekeeproom(MemberDTO memcom,HttpSession session,
			@RequestParam(value="listType",defaultValue = "1") String listType,@RequestParam(value="curpage",defaultValue = "1") int curPage,
			@RequestParam(value="startdate",required=false, defaultValue = "") String startdate,@RequestParam(value="enddate",required=false,defaultValue = "") String enddate) {
		
		memcom=(MemberDTO)session.getAttribute("member");
		session.setAttribute("member", memcom);

		Integer count=parser.getUserPayCount(listType, memcom.getId(),startdate,enddate);
		int page_scale=0;
		int block_sclae=0;
		if(listType.equals("pay")) {
			page_scale= 3;
			block_sclae = 5;
		}else {
			page_scale = 5;
			block_sclae = 3;
		}
		// 페이지 나누기처리 
		BoardPager rvPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = rvPager.getPageBegin();
		int end = rvPager.getPageEnd();

		List<MyPageInfoDTO> mypReservInfo=parser.getUserPayInfo(start, end, listType, memcom.getId(),startdate,enddate);
		JSONObject obj = new JSONObject();
		obj.put("rvlist", mypReservInfo);
		obj.put("rvpager", rvPager);
		return obj;
	}
}
