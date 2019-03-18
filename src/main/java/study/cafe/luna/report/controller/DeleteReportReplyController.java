package study.cafe.luna.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.report.service.ReportService;

@Controller
public class DeleteReportReplyController {
	@Autowired
	ReportService rpser;
	
	@RequestMapping(value="/deleteReportReply.do", method=RequestMethod.POST)
	public @ResponseBody void deleteReportReply(@RequestParam("seq") int seq) {
		rpser.deleteReportReply(seq);
	}
}
