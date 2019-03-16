package study.cafe.luna.keeproom.dao;

import java.util.List;

import study.cafe.luna.keeproom.dto.KeepRoomDTO;
import study.cafe.luna.room.dto.RoomInfoDTO;

public interface KeepRoomDAO {
	//룸 찜 리스트 가져오기
		List<RoomInfoDTO> getKeeplist(int start, int end,String id);
		//안찜
		void deletekroom(KeepRoomDTO krd);
		//찜
		void keeproom(KeepRoomDTO krd);
		//현재 방을 찜했는지 여부
		Integer getKeepStatus(KeepRoomDTO krd);
		
		Integer getKeepCount(String id);
}
