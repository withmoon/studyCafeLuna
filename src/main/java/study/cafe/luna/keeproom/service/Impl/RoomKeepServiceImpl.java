package study.cafe.luna.keeproom.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.keeproom.dao.KeepRoomDAO;
import study.cafe.luna.keeproom.dto.KeepRoomDTO;
import study.cafe.luna.keeproom.service.RoomKeepService;
import study.cafe.luna.room.dto.RoomInfoDTO;

@Service
public class RoomKeepServiceImpl implements RoomKeepService {
	
	@Autowired
	KeepRoomDAO keeproomd;
	@Override
	public List<RoomInfoDTO> getKeeplist(int start, int end,String id){
		return keeproomd.getKeeplist(start,end,id);
	}


	@Override
	public void deletekroom(KeepRoomDTO krd) {
		keeproomd.deletekroom(krd);
		
	}


	@Override
	public void keeproom(KeepRoomDTO krd) {
		keeproomd.keeproom(krd);
	}


	@Override
	public Integer getKeepStatus(KeepRoomDTO krd) {
		return keeproomd.getKeepStatus(krd);
	}


	@Override
	public Integer getKeepCount(String id) {
		return keeproomd.getKeepCount(id);
	}

}
