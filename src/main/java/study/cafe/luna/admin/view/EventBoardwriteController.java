package study.cafe.luna.admin.view;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.event.dto.EventBoardDTO;
import study.cafe.luna.event.dto.EventReplyDTO;
import study.cafe.luna.event.service.EventBoardService;
import study.cafe.luna.event.service.EventReplyService;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.util.BoardPager;

@Controller
public class EventBoardwriteController {
	private String efilePath = "C:\\myProject\\MainProject\\studyCafeLuna\\src\\main\\webapp\\resources\\eventimg\\";
   
   @Autowired
   EventBoardService eboardService;
   @Autowired
   EventReplyService eventReplyService;
   
   @RequestMapping(value="/eventwrite.do", method=RequestMethod.GET)
   public ModelAndView eventwrite() {
	   ModelAndView mav = new ModelAndView();
	   mav.setViewName("/admin/eventwrite");
	   
	   return mav;
   }
   
   //이벤트 글쓰기
   @RequestMapping(value="/eventinsert.do", method=RequestMethod.POST)
   public String eventinsert(EventBoardDTO eboardVO, MultipartHttpServletRequest mpreq,
		   					HttpServletRequest req, HttpSession session) throws IllegalStateException, IOException {
	   /*MemberCommand memcom=(MemberCommand) session.getAttribute("id");
	   session.setAttribute("id", memcom.getId());*/
	   MemberDTO memcom = (MemberDTO) session.getAttribute("member");
	   
	   Integer seq = eboardService.eventSeq(); //최대 번호 가져오기
	   String filePath = efilePath + seq + "\\";
	   File file = new File(filePath);
	   if(file.exists()) {
		   if(file.isDirectory()) { //파일이 디렉토리인지 확인
			   File[] files = file.listFiles();
			   for(int i =0; i < files.length; i++) {
				   files[i].delete();
			   }
		   }
	   } else {
    	  if(!file.isDirectory()) {
    		  System.out.println("디렉토리 생성");
    		  file.mkdirs();
    	  }
	   }
      
      MultipartFile mf = mpreq.getFile("mfname");
      System.out.println("파일 추출 " + mf.getOriginalFilename());
      //저장되는 파일 이름
      String eventName = mf.getOriginalFilename();
      
      String savePath = filePath + eventName; //저장 될 파일 경로
      mf.transferTo(new File(savePath)); //파일저장
      
      eboardVO.setFiles(eventName);
      eboardVO.setImage(filePath);
      eboardVO.setTitle((String) req.getParameter("title"));
      
      String content = (String) req.getParameter("content").replace("\r\n", "<br>");
      eboardVO.setContent(content);
      eboardService.eventwrite(eboardVO);
      
	   return "redirect:/event.do";
  }
   
   //이벤트 보기
   @RequestMapping(value = "/eventview.do", method = RequestMethod.GET)
   public ModelAndView view(int seq, HttpSession session,MemberDTO memcom,HttpServletRequest request) throws Exception {
	   ModelAndView mav = new ModelAndView();
       mav.setViewName("/admin/eventview");
       mav.addObject("ebv", eboardService.read(seq));
       return mav;
   }
   
   //이벤트 수정
   @RequestMapping(value = "/updateevent.do" ,method=RequestMethod.POST)
   public String updateevent(EventBoardDTO eboardVO, MultipartHttpServletRequest mpreq,HttpSession session, @RequestParam(value="seq", defaultValue="1") int seq,
		   @RequestParam(value="title") String title, @RequestParam(value="content") String content) throws IllegalStateException, IOException {
	   Integer bseq = eboardService.event_Seq(); //최대 번호 가져오기
	   
	   
	   String filePath = efilePath + bseq + "\\";
	   File file = new File(filePath);
	   if(file.exists()) {
		   if(file.isDirectory()) { //파일이 디렉토리인지 확인
			   File[] files = file.listFiles();
			   for(int i =0; i < files.length; i++) {
				   files[i].delete();
			   }
		   }
	   } else {
    	  if(!file.isDirectory()) {
    		  file.mkdirs();
    	  }
	   }
      
      MultipartFile mf = mpreq.getFile("mfname");
      //저장되는 파일 이름
      String eventName = mf.getOriginalFilename();
      
      String savePath = filePath + eventName; //저장 될 파일 경로
      mf.transferTo(new File(savePath)); //파일저장
	   
	   eboardVO.setFiles(eventName);
	   eboardVO.setTitle(title);
	   eboardVO.setContent(content);
	   eboardVO.setSeq(seq);
	   
	   eboardService.update(eboardVO);
	   
	return "redirect:/event.do";
   }
   
   //삭제
   @RequestMapping(value="/deleteevent.do", method=RequestMethod.POST)
   public @ResponseBody void deleteevent(EventBoardDTO eboardVO,HttpSession session, @RequestParam(value="seq") int seq) {
	   eboardVO.setSeq(seq);
	   eboardService.delete(eboardVO);
 	}
   
   
   //댓글목록
   @RequestMapping(value="/aEReplyList.do", method=RequestMethod.GET)
	public @ResponseBody JSONObject aEReplyView(@RequestParam(value="seq") int seq, @RequestParam(defaultValue="1") int curPage,
			MemberDTO memcom, EventReplyDTO eReplyVO,  HttpSession session) {
		eReplyVO.setSeq(seq);
		
		//페이징 처리
		int count = eventReplyService.counteReply(seq);
		int page_scale = 5; // 페이지당 게시물 수
		int block_sclae = 10; // 화면당 페이지 수
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<EventReplyDTO> eReplyList = eventReplyService.eReplyList(seq, start, end, session);
			
		JSONObject obj = new JSONObject();
		obj.put("eReplyList", eReplyList);
		obj.put("eReplyPage", boardPager);
		return obj;
	}
 	
 	//댓글 삭제
 	@RequestMapping(value="/aEReplyDelete.do", method=RequestMethod.POST)
 	public @ResponseBody void aEReplyDelete(EventReplyDTO eReplyVO,HttpSession session, @RequestParam(value="rno", defaultValue="1") int rno) {
 		eReplyVO.setRno(rno);
 		eventReplyService.eReplyDe(eReplyVO);
 	}  
}