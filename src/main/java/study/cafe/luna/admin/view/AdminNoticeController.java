package com.study.luna.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminNoticeBoardService;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;
import com.study.luna.mg.model.BoardPager;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.comment.service.NoticeReplyService;
import com.study.luna.user.comment.vo.NoticeReplyVO;

@Controller
public class AdminNoticeController {

	@Autowired
	AdminNoticeBoardService adminNoticeBoardService;
	@Autowired
	NoticeReplyService nReplyService;

	@RequestMapping(value = "/gongji.ado", method = RequestMethod.GET)
	public String mainView(HttpSession session, MemberCommand memcom) {
		memcom = (MemberCommand) session.getAttribute("member");

		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			return "gongji";
		}
		return "cannotAccess";

	}

	// 공지사항 목록
	@RequestMapping(value = "gongjiboardList.ado", method = RequestMethod.GET)
	public @ResponseBody JSONObject gongjiboardList(@RequestParam(defaultValue = "1") int curPage,
			AdminNoticeBoardVO noticeboardVO, HttpSession session) {
		// 페이징 처리
		int count = adminNoticeBoardService.countNotice(noticeboardVO.getTitle());

		int page_scale = 10; // 페이지당 게시물 수
		int block_sclae = 5; // 화면당 페이지 수
		// 페이지 나누기처리
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		// 목록
		List<AdminNoticeBoardVO> noticeList = adminNoticeBoardService.noticeAll(start, end, session);

		JSONObject obj = new JSONObject();

		obj.put("noticeList", noticeList);
		obj.put("noticePage", boardPager);
		return obj;
	}
	
	//공지사항 입력
	@RequestMapping(value = "/gongjiwrite.ado", method = RequestMethod.GET)
	public String View(HttpSession session, MemberCommand memcom) {
		memcom = (MemberCommand) session.getAttribute("member");

		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			return "gongjiwrite";
		}
		return "cannotAccess";	
	}
	
	@RequestMapping(value = "/noticeinsert.ado", method = RequestMethod.GET)
	public String insert(@ModelAttribute AdminNoticeBoardVO vo, HttpSession session, MemberCommand memcom) throws Exception {
		memcom = (MemberCommand) session.getAttribute("member");

		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			adminNoticeBoardService.noticeinsert(vo);
			return "redirect:/gongji.ado";
		}
		return "cannotAccess";	
	}
	
	//공지사항 상세보기
	@RequestMapping(value = "/gongjiview.ado", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int num, HttpSession session, MemberCommand memcom) throws Exception {

		memcom = (MemberCommand) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);

			mav.setViewName("gongjiview");
			mav.addObject("num", adminNoticeBoardService.noticeread(num));
			return mav;
		}
		mav.setViewName("cannotAccess");
		return mav;
	}

	//공지사항 수정
	@RequestMapping(value = "/gongjiupdate.ado", method = RequestMethod.POST)
	public String View(@ModelAttribute AdminNoticeBoardVO vo) throws Exception {
		adminNoticeBoardService.noticeupdate(vo);
		return "redirect:/gongji.ado";
	}

	//공지사항 삭제
	@RequestMapping(value = "/gongjidelete.ado", method = RequestMethod.GET)
	public String delete(@RequestParam int num, HttpSession session, MemberCommand memcom) throws Exception {
		memcom = (MemberCommand) session.getAttribute("member");

		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			adminNoticeBoardService.noticedelete(num);
			return "redirect:/gongji.ado";
		}
		return "cannotAccess";
	}
	
	//댓글목록
	@RequestMapping(value="/aGReplyList.ado", method=RequestMethod.GET)
	public @ResponseBody JSONObject aGReplyView(@RequestParam(value="num") int num, @RequestParam(defaultValue="1") int curPage,
												MemberCommand memcom, NoticeReplyVO gReplyVO,  HttpSession session) {
		gReplyVO.setNum(num);
			
		//페이징 처리
		int count = nReplyService.countnReply(num);
		int page_scale = 5; // 페이지당 게시물 수
		int block_sclae = 10; // 화면당 페이지 수
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
			
		List<NoticeReplyVO> nReplyList = nReplyService.nReplyList(num, start, end, session);
				
		JSONObject obj = new JSONObject();
		obj.put("nReplyList", nReplyList);
		obj.put("nReplyPage", boardPager);
		return obj;
		}
	 	
	 	//댓글 삭제
		@RequestMapping(value="/aGReplyDelete.ado", method=RequestMethod.POST)
		public @ResponseBody void aGnReplyDelete(NoticeReplyVO nReplyVO,HttpSession session, @RequestParam(value="rno", defaultValue="1") int rno) {
			nReplyVO.setRno(rno);
			nReplyService.nReplyDe(nReplyVO);
		}
}