package study.cafe.luna.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.report.service.ReportService;

@Controller
public class DeleteReportController {
	@Autowired
	ReportService rpser;
	
	@RequestMapping(value="/deleteReport.do", method=RequestMethod.POST)
	public @ResponseBody void deleteReport(@RequestParam("seq") String seq) {
		//StringBuilder sb=new StringBuilder(seq);
		String [] seqs=seq.split(",");
		
		for(String temp:seqs) {
			rpser.deleteReport(temp);
		}
	}
			
}
