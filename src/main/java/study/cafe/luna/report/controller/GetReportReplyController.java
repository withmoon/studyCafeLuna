package study.cafe.luna.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.report.dto.ReportReplyDTO;
import study.cafe.luna.report.service.ReportService;

@Controller
public class GetReportReplyController {
	@Autowired
	ReportService rpser;
	
	@RequestMapping(value="/getReportReply.do", method=RequestMethod.POST)
	public @ResponseBody List<ReportReplyDTO> getReportReply(@RequestParam("seq") int reportseq) {
		List<ReportReplyDTO> list=rpser.getReportReply(reportseq);
		return list;
	}
}
