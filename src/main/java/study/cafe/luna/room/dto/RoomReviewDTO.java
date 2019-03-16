package study.cafe.luna.room.dto;

public class RoomReviewDTO {
	 int roomNum;
     String reviewContent;
     String name;
     String id;
     String writedate;
     int starCt;
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public int getStarCt() {
		return starCt;
	}
	public void setStarCt(int starCt) {
		this.starCt = starCt;
	}
     
}
