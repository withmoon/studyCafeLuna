package study.cafe.luna.mRoom.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.mRoom.dto.MRoomDTO;

public interface MRoomListService {
	//방탭
	public List<MRoomDTO> RoomList(HttpSession session,int start, int end, MRoomDTO vo, String searchOption, String keyword) throws Exception;

}
