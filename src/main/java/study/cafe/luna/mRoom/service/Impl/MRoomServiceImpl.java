package study.cafe.luna.mRoom.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.mRoom.dao.MRoomDAO;
import study.cafe.luna.mRoom.dto.MRoomDTO;
import study.cafe.luna.mRoom.service.MRoomService;
 
@Service
public class MRoomServiceImpl implements MRoomService {
  
	@Autowired
	public MRoomDAO mRoomDAO;
	// 상세보기 글/file 읽어오기
	@Override
	public Object RoomRead(int roomnum) throws Exception {
		System.out.println("roomRead 서비스");
		return mRoomDAO.mgRoomRead(roomnum);
	}

	@Override // file
	public List<MRoomDTO> RoomFile(int roomnum) throws Exception {
		System.out.println("roomfile 서비스");
		return mRoomDAO.mgRoomFile(roomnum);
	}

}
