package study.cafe.luna.mRoom.service.Impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.mRoom.dao.MRoomDAO;
import study.cafe.luna.mRoom.dto.MRoomDTO;
import study.cafe.luna.mRoom.service.MRoomInsertService;

@Service
public class MRoomInsertServiceImpl implements MRoomInsertService {
	@Autowired
	public MRoomDAO mRoomDAO;
	
	@Override
	public void mgRoomUpload(MRoomDTO vo) throws Exception {
		mRoomDAO.roomupload(vo);
	}

	@Override
	public void fileUpload(String originalfileName, String saveFileName, MRoomDTO vo, String savePath)
			throws Exception, IllegalStateException {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("originalfileName", originalfileName);
		hm.put("saveFileName", saveFileName);
		hm.put("filenum", vo.getFilenum());
		hm.put("roomnum", vo.getRoomnum());
		hm.put("savePath", savePath);
		System.out.println("파일 이름 맵저장 서비스로직");
		mRoomDAO.uploadFile(hm);
	}
}
