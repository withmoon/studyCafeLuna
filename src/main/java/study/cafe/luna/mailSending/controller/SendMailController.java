package study.cafe.luna.mailSending.controller;

import java.io.File;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import study.cafe.luna.mailSending.service.UpdateApproveservice;
import study.cafe.luna.member.service.MemberService;

@Controller
public class SendMailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	MemberService memser;
	@Autowired
	UpdateApproveservice updateApproveservice;

	String filePath = "C:\\Users\\진혁\\git\\studyCafeLuna\\src\\main\\webapp\\resources\\rooms\\";

	@RequestMapping(value = "sendemail.do", method = RequestMethod.POST)
	public String sendemail(MultipartHttpServletRequest mpreq,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam("email") String email,
			@RequestParam(value = "content", required = false, defaultValue = "") String contents,
			@RequestParam(value = "title", required = false, defaultValue = "") String titles,
			@RequestParam(value = "jspname", required = false, defaultValue = "") String jspname,
			@RequestParam(value = "type", required = false, defaultValue = "") String type) throws Exception {
		InternetAddress setfrom = new InternetAddress("moonLightAdmin <saeah5806@gmail.com>");
		String content = contents;
		String title = titles;

		if (type.equals("approve")) {
			updateApproveservice.approveupdate(id);
		}
		String tomail[] = email.split(";");
		MultipartFile mf = mpreq.getFile("filename");
		if (!mf.getOriginalFilename().equals("")) {
			File dir = new File(filePath);
			if (dir.exists()) { // 파일존재여부확인
				if (dir.isDirectory()) { // 파일이 디렉토리인지 확인
					File[] files = dir.listFiles();
					for (int i = 0; i < files.length; i++) {
						files[i].delete();
					}
					dir.mkdirs();
				}
			} else {
				if (!dir.isDirectory()) {
					System.out.println("디렉토리생성");
					dir.mkdirs();
				}
			}
			// 저장되는 파일 이름
			String reportxsls = mf.getOriginalFilename();

			String savePath = filePath + reportxsls; // 저장 될 파일 경로
			mf.transferTo(new File(savePath)); // 파일 저장
			
			for (String emails : tomail) {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				FileSystemResource image = new FileSystemResource(savePath);
				messageHelper.addAttachment(reportxsls, image);

				messageHelper.setFrom(setfrom); // 보내는사람 생략하면 안된다
				messageHelper.setTo(emails); // 받는사람 이메일
				messageHelper.setSubject(title); // 제목은 생략이 가능하다
				messageHelper.setText(content); // 메일 내용
				mailSender.send(message);
			}
		}else {
			for (String emails : tomail) {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom(setfrom); // 보내는사람 생략하면 안된다
				messageHelper.setTo(emails); // 받는사람 이메일
				messageHelper.setSubject(title); // 제목은 생략이 가능하다
				messageHelper.setText(content); // 메일 내용
				mailSender.send(message);
				
			}
		}

	
		
		if (!jspname.equals("")) {
			return "redirect:/" + jspname + ".do";
		}
		return "redirect:/member.do";
	}
}
