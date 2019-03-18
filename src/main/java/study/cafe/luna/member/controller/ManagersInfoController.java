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
import study.cafe.luna.member.service.MemberService;
import study.cafe.luna.util.BoardPager;
@Controller
public class ManagersInfoController {
	
	@Autowired
	MemberService memser;
	 //지점장 정보
	   @RequestMapping(value = "infoList.do", method=RequestMethod.GET)
	   public @ResponseBody JSONObject  infoList(@RequestParam(defaultValue="1") int curPage,
			   									MemberDTO memberCommand) { 
	   	//페이징 처리
	   	int count = memser.countinfo(memberCommand.getId());
	   			
	   	int page_scale = 10; // 페이지당 게시물 수
	   	int block_sclae = 5; // 화면당 페이지 수
	   	// 페이지 나누기처리 
	   	BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

	   	int start = boardPager.getPageBegin();
	   	int end = boardPager.getPageEnd();
	   	
	   	//목록
	   	List<MemberDTO> infoList = memser.infoList(start, end);
	   			
	   	JSONObject obj = new JSONObject();

	   	obj.put("infoList", infoList);
	   	obj.put("infoPage", boardPager);
	   	return obj;
	   }
}
