package study.cafe.luna.mRoom.service.Impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.mRoom.dao.MRoomDAO;
import study.cafe.luna.mRoom.dto.MRoomDTO;
import study.cafe.luna.mRoom.service.MRoomUpdateService;

@Service
public class MRoomUpdateServiceImpl implements MRoomUpdateService{
	@Autowired
	public MRoomDAO mRoomDAO; 
	
	// 수정하기 글 / file update 하기
	@Override
	public void mgRoomUpdate(MRoomDTO vo) throws Exception {
		System.out.println("roomTextupdate 서비스");
		mRoomDAO.mgRoomTextupdate(vo);
	}

	@Override // file update
	public void fileUpdate(String originalfileName, String saveFileName, MRoomDTO vo, String savePath) throws Exception {
		System.out.println("roomFileupdate 서비스");
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("originalfileName", originalfileName);
		hm.put("saveFileName", saveFileName);
		hm.put("filenum", vo.getFilenum());
		hm.put("roomnum", vo.getRoomnum());
		hm.put("savePath", savePath);
		System.out.println("파일 이름 맵저장 서비스로직");
		mRoomDAO.mgRoomFileupdate(hm);
	}

}
