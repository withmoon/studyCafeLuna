package study.cafe.luna.room.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.room.dao.RoomDAO;
import study.cafe.luna.room.dto.RoomFileDTO;
import study.cafe.luna.room.dto.RoomInfoDTO;
import study.cafe.luna.room.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	RoomDAO roomd;
	
	@Override
	public List<String> getSido() {
		return roomd.getSido();
	}

	@Override
	public List<String> getGugun(String sido) {
		return roomd.getGugun(sido);
	}

	@Override
	public List<RoomInfoDTO> getAllRoomInfo(RoomInfoDTO romin) {
		return roomd.getAllRoomInfo(romin);
	}

	@Override
	public RoomInfoDTO getRoomSchedule(RoomInfoDTO romin) {
		return roomd.getRoomSchedule(romin);
	}

	@Override
	public List<RoomInfoDTO> getExcRoomNum(RoomInfoDTO romin) {
		return roomd.getExcRoomNum(romin);
	}

	@Override
	public RoomInfoDTO getDetailRoomInfo(RoomInfoDTO romin) {
		return roomd.getDetailRoomInfo(romin);
	}

	@Override
	public List<RoomFileDTO> getRoomAllimg(int roomnum) {
		return roomd.getRoomAllimg(roomnum);
	}
}
