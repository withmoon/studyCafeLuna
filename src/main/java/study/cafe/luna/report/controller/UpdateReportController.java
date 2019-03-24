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
public class UpdateReportController {

	private String filePath = "C:\\myProject\\MainProject\\studyCafeLuna\\src\\main\\webapp\\resources\\report\\";
	@Autowired
	ReportService rpser;

	@RequestMapping(value = "/updateReport.do", method = RequestMethod.POST)
	public String updateReport(ReportDTO rpd, MultipartHttpServletRequest mpreq, HttpServletRequest req,
			HttpSession session) throws IllegalStateException, IOException {
		// MemberCommand memcom=(MemberCommand) session.getAttribute("id");
		// session.setAttribute("id", memcom.getId());
		String seqs = (String) req.getParameter("seq");
		int seq = Integer.parseInt(seqs);
		rpd.setSeq(seq);
		
	
		MultipartFile mf = mpreq.getFile("ffname");
		if (mf != null) {
			filePath+=seq;
			File dir = new File(filePath);
			
			if (dir.exists()) {
				File[] deleteFolderList = dir.listFiles();
				for (int j = 0; j < deleteFolderList.length; j++) {
					deleteFolderList[j].delete();
				}
			}else{
				dir.mkdir();
			}
			filePath +="\\";
			String reportxsls = mf.getOriginalFilename();
			String savePath = filePath + reportxsls; // 저장 될 파일 경로
			mf.transferTo(new File(savePath)); // 파일 저장
			rpd.setFname(reportxsls);
		}
	
		rpd.setTitle((String) req.getParameter("title"));
		String content = (String) req.getParameter("content").replace("\r\n", "<br>");
		rpd.setContent(content);
		rpser.updateReport(rpd);
		return "redirect:/mgreport.mdo";
	}

}
