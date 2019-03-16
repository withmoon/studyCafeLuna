package study.cafe.luna.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class RoomReserveDTO {
	int roomNum;
    String reservstate;
    String startdate;
    int reservNumber;
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getReservstate() {
		return reservstate;
	}
	public void setReservstate(String reservstate) {
		this.reservstate = reservstate;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public int getReservNumber() {
		return reservNumber;
	}
	public void setReservNumber(int reservNumber) {
		this.reservNumber = reservNumber;
	}
    
}
