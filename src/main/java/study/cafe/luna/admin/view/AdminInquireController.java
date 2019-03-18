package study.cafe.luna.admin.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.Question.service.GetQuestionBoardListService;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.util.BoardPager;


@Controller
public class AdminInquireController {

	@Autowired
	GetQuestionBoardListService service;

	@Autowired
	private JavaMailSender mailSender;
	  
	@RequestMapping(value = "/inquire.ado")
	public String view() {
		return "inquire";
	}
	
	//문의계시판
	@RequestMapping(value = "/inquireList.ado", method=RequestMethod.GET)
	public @ResponseBody JSONObject  inquireList(@RequestParam(defaultValue="1") int curPage,
			QuestionBoardDTO qboardVO, HttpSession session,
									@RequestParam(value="searchOption",defaultValue = "title") String searchOption,
									@RequestParam(value="keyword",defaultValue = "") String keyword) {
		//페이징 처리
    	int count = service.countInqure(searchOption, keyword);
    			
    	int page_scale = 10; // 페이지당 게시물 수
    	int block_sclae = 5; // 화면당 페이지 수
    	// 페이지 나누기처리 
    	BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);

    	int start = boardPager.getPageBegin();
    	int end = boardPager.getPageEnd();
    	
    	
		List<QuestionBoardDTO> inquireList = service.inquireList(start, end, searchOption, keyword, session);
		
		JSONObject obj = new JSONObject();

    	obj.put("inquireList", inquireList);
    	obj.put("inquirePage", boardPager);
    	return obj;
	}
	

	@RequestMapping(value = "/inquirewrite.ado")
	public ModelAndView views(@RequestParam Integer seq,HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			mav.setViewName("inquirewrite");
			mav.addObject("seq", service.inquireread(seq));
			return mav;
		}
		mav.setViewName("cannotAccess");
		return mav;
	}
	
	@RequestMapping(value = "/inquiredelete.ado" ,method=RequestMethod.GET)
    public @ResponseBody void delete(@RequestParam("seq") int seq) throws Exception {
    	service.inquiredelete(seq);
    }   
}
