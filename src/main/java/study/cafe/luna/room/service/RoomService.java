package study.cafe.luna.room.service;

import java.util.List;

import study.cafe.luna.room.dto.RoomFileDTO;
import study.cafe.luna.room.dto.RoomInfoDTO;

public interface RoomService {
	//--Home,LookOver--
	//시/도 ajax 처리 쿼리
	List<String> getSido();
	List<String> getGugun(String sido);
	//미 선택시 가져오는 쿼리
	List<RoomInfoDTO> getAllRoomInfo(RoomInfoDTO romin);
	//--LookOver --
	//방 스케줄 가져오기
	RoomInfoDTO getRoomSchedule(RoomInfoDTO romin);
	// 검색에서 제외할 방 가져옴
	List<RoomInfoDTO> getExcRoomNum(RoomInfoDTO romin);
	//--roomDetail--
	//방 상세 정보 가져오기
	RoomInfoDTO getDetailRoomInfo(RoomInfoDTO romin);
	//방 사진들 가져오기
	List<RoomFileDTO> getRoomAllimg(int roomnum);
}
