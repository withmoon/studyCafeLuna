package study.cafe.luna.mRoom.service;

import org.springframework.stereotype.Service;

import study.cafe.luna.mRoom.dto.MRoomDTO;

public interface MRoomUpdateService {
	//수정하기
	public void mgRoomUpdate(MRoomDTO vo)throws Exception;
	public void fileUpdate(String originalfileName, String saveFileName, MRoomDTO vo, String savePath)throws Exception;

}
