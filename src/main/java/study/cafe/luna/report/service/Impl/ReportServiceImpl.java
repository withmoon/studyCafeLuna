package study.cafe.luna.report.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.report.dao.ReportDAO;
import study.cafe.luna.report.dto.ReportDTO;
import study.cafe.luna.report.dto.ReportReplyDTO;
import study.cafe.luna.report.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportDAO reportd;
	
	@Override
	public void insertReport(ReportDTO rpd) {
		reportd.insertReport(rpd);
	}

	@Override
	public List<ReportDTO> getReportlist(int start, int end,ReportDTO rpd) {
		return reportd.getReportlist(start, end, rpd);
	}

	@Override
	public Integer getReportCount(ReportDTO rpd) {
		return reportd.getReportCount(rpd);
	}

	@Override
	public void updateReport(ReportDTO rpd) {
		reportd.updateReport(rpd);
	}

	@Override
	public void deleteReport(String seq) {
		reportd.deleteReport(seq);
	}

	@Override
	public List<ReportReplyDTO> getReportReply(int reportseq) {
		return reportd.getReportReply(reportseq);
	}

	@Override
	public void insertReportReply(ReportReplyDTO rry) {
		reportd.insertReportReply(rry);
	}

	@Override
	public void updateReportReply(ReportReplyDTO rry) {
		reportd.updateReportReply(rry);
	}

	@Override
	public void deleteReportReply(Integer seq) {
		reportd.deleteReportReply(seq);
	}

	@Override
	public Integer getReportMaxSeq() {
		return reportd.getReportMaxSeq();
	}

}
