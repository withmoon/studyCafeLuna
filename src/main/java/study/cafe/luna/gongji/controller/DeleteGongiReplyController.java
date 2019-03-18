package study.cafe.luna.gongji.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.notice.dto.NoticeReplyDTO;
import study.cafe.luna.notice.service.NoticeReplyService;

@Controller
public class DeleteGongiReplyController {

	@Autowired
	NoticeReplyService noticeReplyService;
	
	// 댓글 삭제
	@RequestMapping(value = "/aGReplyDelete.do", method = RequestMethod.POST)
	public @ResponseBody void aGnReplyDelete(NoticeReplyDTO nReplyVO, HttpSession session,
			@RequestParam(value = "rno", defaultValue = "1") int rno) {
		nReplyVO.setRno(rno);
		noticeReplyService.nReplyDe(nReplyVO);
	}
}
