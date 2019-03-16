package study.cafe.luna.report.dto;


public class ReportReplyDTO {
	int seq;
	String reply;
	int reportseq;
	String branchname;
	String regdate;
	int replyseq;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getReportseq() {
		return reportseq;
	}
	public void setReportseq(int reportseq) {
		this.reportseq = reportseq;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReplyseq() {
		return replyseq;
	}
	public void setReplyseq(int replyseq) {
		this.replyseq = replyseq;
	}
	
}
