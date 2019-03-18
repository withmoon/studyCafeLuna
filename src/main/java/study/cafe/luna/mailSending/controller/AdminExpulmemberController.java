package study.cafe.luna.mailSending.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.mailSending.service.AdminManagerApproveService;
import study.cafe.luna.member.service.MemberService;
@Controller
public class AdminExpulmemberController {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	MemberService memser;
	@Autowired
	AdminManagerApproveService adminManagerApproveService;
	
	@RequestMapping(value = "expulmember.do")
	public @ResponseBody void expulmember(@RequestParam("id") String id, @RequestParam("email") String email,
			@RequestParam(value="content", required = false, defaultValue = "") String contents,
			@RequestParam(value = "title", required = false, defaultValue = "") String titles)
			throws MessagingException {
		
		String setfrom = "kmh214900@gmail.com";// 보낼 관리자 gmail 계정
		String tomail = email;
		String title = ((titles.equals("")&&!contents.equals(""))?"[달빛 스터디카페] 고객님께서 제명처리되셨습니다. 이유는 아래와 같습니다.":(contents.equals(""))?"[달빛 스터디카페] 회원님의 제명이 취소되었습니다.":titles);
		String content = contents;
		//제명 처리
		if(titles.equals("")) {
			memser.expulmember(id);
		}
		//제명 취소
		if(contents.equals("")) {
			memser.cancleExpulmember(id);
			content+=id+"님의 제명이 취소되었습니다.\r\n  http://localhost:8080/luna/main.do ";
		}

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

		messageHelper.setFrom(setfrom); // 보내는사람 생략하면 안된다
		messageHelper.setTo(tomail); // 받는사람 이메일
		messageHelper.setSubject(title); // 제목은 생략이 가능하다
		messageHelper.setText(content); // 메일 내용

		mailSender.send(message);
		
	}// 
	 
}
