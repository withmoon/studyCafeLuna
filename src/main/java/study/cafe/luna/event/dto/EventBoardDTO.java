package study.cafe.luna.event.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class EventBoardDTO{
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date startdate;
	private Date enddate;
	private String image; //이미지
	private String files; //파일명
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "AdminEventBoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", image=" + image + ", files=" + files + "]";
	}
	
	
	
	
}