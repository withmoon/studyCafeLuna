package study.cafe.luna.mRoom.service;

import study.cafe.luna.mRoom.dto.MRoomDTO;


public interface MRoomInsertService {
	//방업로드 
	public void mgRoomUpload(MRoomDTO vo) throws Exception;
	public void fileUpload(String originalfileName, String saveFileName,MRoomDTO vo,String savePath ) throws Exception,IllegalStateException;
}
