package study.cafe.luna.mailSending.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.inquiry.service.InquiryService;
import study.cafe.luna.mailSending.service.AdminManagerApproveService;
import study.cafe.luna.member.service.MemberService;
@Controller
public class AdminMailController {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private InquiryService inquiryService;
	@Autowired
	MemberService memser;
	@Autowired
	AdminManagerApproveService adminManagerApproveService;
	
	String filePath="C:\\Users\\진혁\\git\\studyCafeLuna\\src\\main\\webapp\\resources\\rooms\\";
	
	  @RequestMapping(value = "/mailSending.do", method = RequestMethod.POST)
	  public ModelAndView mailSending(HttpServletRequest request, InquiryBoardDTO
	  vo, HttpSession session) throws Exception {
	  
	  // String setfrom = "gur792816@gmail.com"; //蹂대궡�뒗�씠?
	  String setfrom ="manager@gmail.com"; String tomail = request.getParameter("tomail"); // 諛쏅뒗
	  String title = "["+(String)
	  session.getAttribute("branchName")+"]"+"달빛스터디카페 - 문의하신 내역에 대한 답변이 등록되었습니다" ;//
	  String content =
	  request.getParameter("content1")+"\r\n\r\n"+request.getParameter("content2");
	  MimeMessage message = mailSender.createMimeMessage(); try {
	  
	  MimeMessageHelper messageHelper = new MimeMessageHelper(message, true,
	  "UTF-8");
	  
	  messageHelper.setFrom(setfrom); 
	  messageHelper.setTo(tomail);
	  messageHelper.setSubject(title);
	  messageHelper.setText(content);
	  
	  mailSender.send(message); } catch (Exception e) { System.out.println(e); }
	  vo.setSeq(Integer.parseInt(request.getParameter("seq")));
	  vo.setEmail(request.getParameter("email")); vo.setEmailtitle(title);
	  vo.setEmailcontent(request.getParameter("content1"));
	  vo.setReply(request.getParameter("content2")); vo.setBranchName((String)
	  session.getAttribute("branchName"));
	  
	  inquiryService.mailstatus(vo);
	  
	  
	  Thread.sleep(20000); ModelAndView mv = new ModelAndView();
	  mv.setViewName("/body/mailForm"); return mv;
	  
	  }
	
	
}
