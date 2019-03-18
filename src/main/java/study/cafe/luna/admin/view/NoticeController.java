package study.cafe.luna.admin.view;

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

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.notice.dto.NoticeBoardDTO;
import study.cafe.luna.notice.dto.NoticeReplyDTO;
import study.cafe.luna.notice.service.NoticeBoardService;
import study.cafe.luna.notice.service.NoticeReplyService;
import study.cafe.luna.util.BoardPager;

@Controller
public class NoticeController {

	@Autowired
	NoticeBoardService adminNoticeBoardService;
	@Autowired
	NoticeReplyService nReplyService;

	@RequestMapping(value = "/gongji.do", method = RequestMethod.GET)
	public String goingjiView(HttpSession session, MemberDTO memcom) {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			return "/admin/gongji";
		}
		return "/admin/cannotAccess";

	}

	// 공지사항 목록
	@RequestMapping(value = "gongjiboardList.do", method = RequestMethod.GET)
	public @ResponseBody JSONObject gongjiboardList(@RequestParam(defaultValue = "1") int curPage,
			NoticeBoardDTO noticeboardVO, HttpSession session) {
		// 페이징 처리
		int count = adminNoticeBoardService.countNotice(noticeboardVO.getTitle());

		int page_scale = 10; // 페이지당 게시물 수
		int block_sclae = 5; // 화면당 페이지 수
		// 페이지 나누기처리
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		// 목록
		List<NoticeBoardDTO> noticeList = adminNoticeBoardService.noticeAll(start, end, session);

		JSONObject obj = new JSONObject();

		obj.put("noticeList", noticeList);
		obj.put("noticePage", boardPager);
		return obj;
	}
	
	//공지사항 입력
	@RequestMapping(value = "/gongjiwrite.do", method = RequestMethod.GET)
	public String View(HttpSession session, MemberDTO memcom) {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			return "/admin/gongjiwrite";
		}
		return "/admin/cannotAccess";	
	}
	
	@RequestMapping(value = "/noticeinsert.do", method = RequestMethod.GET)
	public String insert(@ModelAttribute NoticeBoardDTO vo, HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			adminNoticeBoardService.noticeinsert(vo);
			return "redirect:/gongji.do";
		}
		return "/admin/cannotAccess";	
	}
	
	//공지사항 상세보기
	@RequestMapping(value = "/gongjiview.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int num, HttpSession session, MemberDTO memcom) throws Exception {

		memcom = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("member")==null) {
			mav.setViewName("/admin/cannotAccess");
			return mav;
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);

			mav.setViewName("/admin/gongjiview");
			mav.addObject("num", adminNoticeBoardService.noticeread(num));
			return mav;
		}
		mav.setViewName("/admin/cannotAccess");
		return mav;
	}

	//공지사항 수정
	@RequestMapping(value = "/gongjiupdate.do", method = RequestMethod.POST)
	public String View(@ModelAttribute NoticeBoardDTO vo) throws Exception {
		adminNoticeBoardService.noticeupdate(vo);
		return "redirect:/gongji.do";
	}

	//공지사항 삭제
	@RequestMapping(value = "/gongjidelete.do", method = RequestMethod.GET)
	public String delete(@RequestParam int num, HttpSession session, MemberDTO memcom) throws Exception {
		memcom = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member")==null) {
    		return "/admin/cannotAccess";
    	}
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberDTO) session.getAttribute("member");
			session.setAttribute("member", memcom);
			adminNoticeBoardService.noticedelete(num);
			return "redirect:/gongji.do";
		}
		return "/admin/cannotAccess";
	}
	
	//댓글목록
	@RequestMapping(value="/aGReplyList.do", method=RequestMethod.GET)
	public @ResponseBody JSONObject aGReplyView(@RequestParam(value="num") int num, @RequestParam(defaultValue="1") int curPage,
												MemberDTO memcom, NoticeReplyDTO gReplyVO,  HttpSession session) {
		gReplyVO.setNum(num);
			
		//페이징 처리
		int count = nReplyService.countnReply(num);
		int page_scale = 5; // 페이지당 게시물 수
		int block_sclae = 10; // 화면당 페이지 수
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
			
		List<NoticeReplyDTO> nReplyList = nReplyService.nReplyList(num, start, end, session);
				
		JSONObject obj = new JSONObject();
		obj.put("nReplyList", nReplyList);
		obj.put("nReplyPage", boardPager);
		return obj;
		}
	 	
	 	//댓글 삭제
		@RequestMapping(value="/aGReplyDelete.do", method=RequestMethod.POST)
		public @ResponseBody void aGnReplyDelete(NoticeReplyDTO nReplyVO,HttpSession session, @RequestParam(value="rno", defaultValue="1") int rno) {
			nReplyVO.setRno(rno);
			nReplyService.nReplyDe(nReplyVO);
		}
}