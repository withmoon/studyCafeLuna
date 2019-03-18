package study.cafe.luna.admin.view;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.qna.dto.QnABoardDTO;
import study.cafe.luna.qna.service.QnABoardService;
import study.cafe.luna.util.BoardPager;

@Controller
public class AdminQNABoardController {    
    @Inject
   QnABoardService qnaBoardService;
    
    @RequestMapping(value = "/board.do")
    public String list(HttpSession session, MemberDTO memcom){ 
    	memcom = (MemberDTO) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
	    	return "/admin/board";
		}
		return "cannotAccess";

     }
    
    @RequestMapping(value = "/boardList.do", method=RequestMethod.GET)
    public @ResponseBody JSONObject boardList(@RequestParam(defaultValue="1") int curPage,
									QnABoardDTO qnaBoardVO, HttpSession session){ 
    	//페이징 처리
    	int count = qnaBoardService.countQnA(qnaBoardVO.getSubject());
    			
    	int page_scale = 10;
    	int block_sclae = 5;
    	// 페이지 나누기처리 
    	BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

    	int start = boardPager.getPageBegin();
    	int end = boardPager.getPageEnd();
    			
    	//목록
    	List<QnABoardDTO> qnaList = qnaBoardService.qnaAll(start, end, session);
    			
    	JSONObject obj = new JSONObject();

    	obj.put("qnaList", qnaList);
    	obj.put("qnaPage", boardPager);
    	return obj;
    }
}