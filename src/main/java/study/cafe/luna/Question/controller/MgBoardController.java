package study.cafe.luna.Question.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MgBoardController {
	/*
	 * 
	 * @Autowired private MgService MgService;
	 * 
	 * @Autowired private JavaMailSender mailSender;
	 * 
	 * @Autowired AdminNoticeBoardService noticeBoardService;
	 * 
	 * 
	 * // mailForm
	 * 
	 * @RequestMapping(value = "/mailForm.mdo") public String
	 * mailForm(QuestionBoardDTO vo) throws Exception { return "/body/mailForm"; }
	 * 
	 * @RequestMapping(value = "/mailView.mdo") public String mailView() { return
	 * "/body/mailView"; }
	 * 
	 * // mailSending 肄붾뱶
	 * 
	 * @RequestMapping(value = "/mailSending.do", method = RequestMethod.POST)
	 * public ModelAndView mailSending(HttpServletRequest request, QuestionBoardDTO
	 * vo, HttpSession session) throws Exception {
	 * 
	 * // String setfrom = "gur792816@gmail.com"; //蹂대궡�뒗�씠? String setfrom =
	 * "manager@gmail.com"; String tomail = request.getParameter("tomail"); // 諛쏅뒗
	 * �궗�엺 �씠硫붿씪 String title = "["+(String)
	 * session.getAttribute("branchName")+"]"+" 臾몄쓽�븯�떎 湲��뿉 �떟蹂��씠 �떖�졇�뒿�땲�떎" ;//
	 * �젣紐� String content =
	 * request.getParameter("content1")+"\r\n\r\n"+request.getParameter("content2");
	 * // �궡�슜 MimeMessage message = mailSender.createMimeMessage(); try {
	 * 
	 * MimeMessageHelper messageHelper = new MimeMessageHelper(message, true,
	 * "UTF-8");
	 * 
	 * messageHelper.setFrom(setfrom); // 蹂대궡�뒗�궗�엺 �깮�왂�븯嫄곕굹 �븯硫� �젙�긽�옉�룞�쓣 �븞�븿
	 * messageHelper.setTo(tomail); // 諛쏅뒗�궗�엺 �씠硫붿씪
	 * messageHelper.setSubject(title); // 硫붿씪�젣紐⑹� �깮�왂�씠 媛��뒫�븯�떎
	 * messageHelper.setText(content); // 硫붿씪 �궡�슜
	 * 
	 * mailSender.send(message); } catch (Exception e) { System.out.println(e); }
	 * vo.setSeq(Integer.parseInt(request.getParameter("seq")));
	 * vo.setEmail(request.getParameter("email")); vo.setEmailtitle(title);
	 * vo.setEmailcontent(request.getParameter("content1"));
	 * vo.setReply(request.getParameter("content2")); vo.setBranchName((String)
	 * session.getAttribute("branchName"));
	 * 
	 * MgService.mailstatus(vo);
	 * 
	 * // 由ы꽩�떆 �뒪�겕由쏀듃 �솕硫댁씠�룞�씠 留됲� 紐⑤뱺 湲곕뒫�쓣 �닔�뻾�썑 �뒳由� // 由ы꽩 �꼸�쓣 �븯硫� �뿉�윭
	 * 諛쒖깮 /�엫�떆議곗튂濡� 湲곕뒫�젙吏� - 湲곕뒫�젙吏��룞�븞 �뒪�겕由쏀듃�뿉�꽌 �솕硫댁쟾�솚 �닔�뻾�쑝濡� 而⑦듃濡ㅻ윭 醫낅즺
	 * Thread.sleep(20000); ModelAndView mv = new ModelAndView();
	 * mv.setViewName("/body/mailForm"); return mv;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/mgGong.mdo") public ModelAndView
	 * informView(@RequestParam(defaultValue = "title") String
	 * searchOption,@RequestParam(defaultValue = "") String keyword,
	 * 
	 * @RequestParam(defaultValue = "1") int curPage,AdminNoticeBoardVO
	 * noticeboardVO, HttpSession session) { //�럹�씠吏� 泥섎━ int count =
	 * noticeBoardService.countNotice(noticeboardVO.getTitle()); //int count =
	 * noticeBoardService.countNotice(mav);
	 * 
	 * int page_scale = 10; // �럹�씠吏��떦 寃뚯떆臾� �닔 int block_sclae = 5; // �솕硫대떦
	 * �럹�씠吏� �닔 // �럹�씠吏� �굹�늻湲곗쿂由� BoardPager boardPager = new BoardPager(count,
	 * curPage, page_scale, block_sclae);
	 * 
	 * int start = boardPager.getPageBegin(); int end = boardPager.getPageEnd();
	 * 
	 * //紐⑸줉 List<AdminNoticeBoardVO> noticeList =
	 * noticeBoardService.noticeAll(start, end, session);
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>(); map.put("count",
	 * count); map.put("boardPager", boardPager);
	 * 
	 * 
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.addObject("list",noticeList);
	 * mv.addObject("map",map); mv.setViewName("/body/board/mgNoticeBoard"); return
	 * mv; }
	 * 
	 * @RequestMapping(value = "/mgEvenet.mdo") public String
	 * eventView(MemberCommand memcom, HttpSession session, HttpServletRequest
	 * request) { Map<String, ?>
	 * flashMap=RequestContextUtils.getInputFlashMap(request); if(flashMap!=null) {
	 * memcom.setId(flashMap.get("id").toString()); session.setAttribute("member",
	 * memcom); }else { memcom=(MemberCommand)session.getAttribute("member"); }
	 * 
	 * return "/manager/body/board/mgEvent"; }
	 * 
	 * @RequestMapping(value = "/Event.mdo") public String event() { return
	 * "/body/mailView"; }
	 */

}
