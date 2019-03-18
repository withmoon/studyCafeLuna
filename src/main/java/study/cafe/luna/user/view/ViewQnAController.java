package study.cafe.luna.user.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.qna.service.QnABoardService;

@Controller
public class ViewQnAController {
	@Autowired
	QnABoardService qnaBoardService;
	
	//공지사항_질문사항 상세보기
	@RequestMapping(value="/viewQnA.do", method=RequestMethod.GET)
	public ModelAndView viewQnAView(int num, HttpSession session,MemberDTO memcom,HttpServletRequest request) throws Exception {
		//여서부터
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
			if(flashMap!=null) {
				memcom.setId(flashMap.get("id").toString());
				session.setAttribute("member", memcom);
			}else {
				memcom=(MemberDTO)session.getAttribute("member");
			}
								
			session.setAttribute("member", memcom);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/viewQnA");
		mav.addObject("qbv", qnaBoardService.qnaRead(num));
		return mav;
	}
}
