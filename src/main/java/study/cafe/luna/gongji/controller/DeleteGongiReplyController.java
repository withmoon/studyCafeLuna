package study.cafe.luna.gongji.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteGongiReplyController {

	// 댓글 삭제
	@RequestMapping(value = "/aGReplyDelete.do", method = RequestMethod.POST)
	public @ResponseBody void aGnReplyDelete(/*NoticeReplyVO nReplyVO,*/ HttpSession session,
			@RequestParam(value = "rno", defaultValue = "1") int rno) {
//		nReplyVO.setRno(rno);
//		nReplyService.nReplyDe(nReplyVO);
	}
}
