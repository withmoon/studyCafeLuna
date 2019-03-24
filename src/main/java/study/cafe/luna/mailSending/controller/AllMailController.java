package study.cafe.luna.mailSending.controller;

import java.io.File;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

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

import study.cafe.luna.mailSending.dto.AdminManagerApproveDTO;
import study.cafe.luna.mailSending.service.AdminManagerApproveService;

@Controller
public class AllMailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	AdminManagerApproveService adminManagerApproveService;

	String filePath = "C:\\myProject\\MainProject\\studyCafeLuna\\src\\main\\webapp\\resources\\mailFile\\";

	@RequestMapping(value = "AllMail.do", method = RequestMethod.POST)
	public String allmail(MultipartHttpServletRequest mpreq, @RequestParam("email") String email,
			@RequestParam(value = "content", required = false, defaultValue = "") String contents,
			@RequestParam(value = "title", required = false, defaultValue = "") String titles,
			HttpServletRequest request, AdminManagerApproveDTO vo) throws Exception {
		InternetAddress setfrom = new InternetAddress("moonLightAdmin <saeah5806@gmail.com>");
		String content = contents;
		String title = titles;

		// 회원/전체/지점장 메일 얻어오기
		List<String> list = adminManagerApproveService.AllMail(vo);

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
				}
			} else {
				if (!dir.isDirectory()) {
					dir.mkdirs();
				}
			}
			// 저장되는 파일 이름
			String reportxsls = mf.getOriginalFilename();

			String savePath = filePath + reportxsls; // 저장 될 파일 경로
			mf.transferTo(new File(savePath)); // 파일 저장

			for (int z = 0; z < list.size(); z++) {

				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				FileSystemResource image = new FileSystemResource(savePath);
				messageHelper.addAttachment(reportxsls, image);

				messageHelper.setFrom(setfrom); // 보내는사람 생략하면 안된다
				messageHelper.setTo(list.get(z)); // 받는사람 이메일
				messageHelper.setSubject(title); // 제목은 생략이 가능하다
				messageHelper.setText(content); // 메일 내용

				mailSender.send(message);
			}

		}
		return "redirect:/member.do";
	}
}
