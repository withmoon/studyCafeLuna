package study.cafe.luna.report.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import study.cafe.luna.report.dto.ReportDTO;
import study.cafe.luna.report.service.ReportService;

@Controller
public class InsertReportController {

	private String filePath = "C:\\myProject\\MainProject\\NewLuna\\Luna\\src\\main\\webapp\\resources\\report\\";

	@Autowired
	ReportService rpser;

	@RequestMapping(value = "/insertReport.do", method = RequestMethod.POST)
	public String insertreport(ReportDTO rpd, MultipartHttpServletRequest mpreq, HttpServletRequest req,
			HttpSession session) throws IllegalStateException, IOException {
		// MemberCommand memcom=(MemberCommand) session.getAttribute("id");
		// session.setAttribute("id", memcom.getId());
		Integer seq = rpser.getReportMaxSeq();
		String realPath = filePath + seq + "\\";
		File dir = new File(realPath);
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

		MultipartFile mf = mpreq.getFile("ffname");
		System.out.println("파일 추출 " + mf.getOriginalFilename());
		// 저장되는 파일 이름
		String reportxsls = mf.getOriginalFilename();

		String savePath = realPath + reportxsls; // 저장 될 파일 경로
		mf.transferTo(new File(savePath)); // 파일 저장
		rpd.setFname(reportxsls);
		rpd.setFpath(realPath);
		rpd.setId("brman3");
		rpd.setTitle((String) req.getParameter("title"));
		String content = (String) req.getParameter("content").replace("\r\n", "<br>");
		rpd.setContent(content);
		rpser.insertReport(rpd);

		return "redirect:/mgreport.mdo";
	}

}
