package study.cafe.luna.mRoom.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import study.cafe.luna.mRoom.dto.MRoomDTO;

public interface MRoomService {
	  

	//상세보기
	public Object RoomRead(int roomnum)throws Exception;
	public List<MRoomDTO> RoomFile(int roomnum)throws Exception;

	
	

}
 