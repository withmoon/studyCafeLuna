package study.cafe.luna.report.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.report.dao.ReportDAO;
import study.cafe.luna.report.dto.ReportDTO;
import study.cafe.luna.report.dto.ReportReplyDTO;

@Repository
public class ReportDAOImpl implements ReportDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void deleteReport(String seq) {
		sqlSession.delete("reportDAO.deleteReport",seq);
	}
	@Override
	public void deleteReportReply(Integer seq) {
		sqlSession.delete("reportDAO.deleteReportReply",seq);
	}
	@Override
	public Integer getReportCount(ReportDTO rpd) {
		if(rpd.getId().equals("")) {
			return sqlSession.selectOne("reportDAO.getReportCount",rpd);
		}else {
			return sqlSession.selectOne("reportDAO.getBranchReportCount",rpd);
		}
	}
	@Override
	public List<ReportDTO> getReportlist(int start, int end,ReportDTO rpd) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start",start);
		map.put("end", end);
		map.put("rpd",rpd);
		if(rpd.getId().equals("")) {
			return sqlSession.selectList("reportDAO.getReportlist",map);
		}else {
			return sqlSession.selectList("reportDAO.getBranchReportlist",map);
		}
	}
	@Override
	public Integer getReportMaxSeq() {
		return sqlSession.selectOne("reportDAO.getReportMaxSeq");
	}
	@Override
	public List<ReportReplyDTO> getReportReply(int reportseq) {
		return sqlSession.selectList("reportDAO.getReportReply",reportseq);
	}
	@Override
	public void insertReport(ReportDTO rpd) {
		sqlSession.insert("reportDAO.insertreport",rpd);
	}
	@Override
	public void insertReportReply(ReportReplyDTO rry) {
		sqlSession.insert("reportDAO.insertReportReply",rry);
	}
	@Override
	public void updateReport(ReportDTO rpd) {
		sqlSession.update("reportDAO.updateReport",rpd);
	}
	@Override
	public void updateReportReply(ReportReplyDTO rry) {
		sqlSession.update("reportDAO.updateReportReply",rry);
	}
}
