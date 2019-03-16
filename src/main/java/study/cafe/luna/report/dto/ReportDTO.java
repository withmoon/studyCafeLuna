package study.cafe.luna.report.dto;

import org.springframework.web.multipart.MultipartFile;

public class ReportDTO {
	//reportDAO
	int seq;
	String seqs;
	int num;
	String title;
	String content;
	String fname;
	MultipartFile ffname;
	String id;
	String regdate;
	int isreply;
	String fpath;
	String searchOption;
	String keyword;
	
	String branchName;
	String name;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getSeqs() {
		return seqs;
	}
	public void setSeqs(String seqs) {
		this.seqs = seqs;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public MultipartFile getFfname() {
		return ffname;
	}
	public void setFfname(MultipartFile ffname) {
		this.ffname = ffname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getIsreply() {
		return isreply;
	}
	public void setIsreply(int isreply) {
		this.isreply = isreply;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
