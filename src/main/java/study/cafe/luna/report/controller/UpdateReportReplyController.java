package study.cafe.luna.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.report.dto.ReportReplyDTO;
import study.cafe.luna.report.service.ReportService;

@Controller
public class UpdateReportReplyController {
	@Autowired
	ReportService rpser;
	
	@RequestMapping(value="/updateReportReply.do", method=RequestMethod.POST)
	public @ResponseBody void updateReportReply(ReportReplyDTO rrd,@RequestParam("seq") int seq,@RequestParam("reply") String reply) {
		rrd.setReply(reply);
		rrd.setSeq(seq);
		rpser.updateReportReply(rrd);
	}
}
