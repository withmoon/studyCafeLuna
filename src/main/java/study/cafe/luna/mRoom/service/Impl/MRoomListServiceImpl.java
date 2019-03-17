package study.cafe.luna.mRoom.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.mRoom.dao.MRoomDAO;
import study.cafe.luna.mRoom.dto.MRoomDTO;
import study.cafe.luna.mRoom.service.MRoomListService;

@Service
public class MRoomListServiceImpl implements MRoomListService {
	@Autowired
	public MRoomDAO mRoomDAO;
	
	// 화면 게시판 읽어오기
		@Override
		public List<MRoomDTO> RoomList( HttpSession session,int start, int end,MRoomDTO vo, String searchOption, String keyword) throws Exception {
			System.out.println("roomlist 서비스");
			return mRoomDAO.mgRoomList(session,start,end,vo, searchOption, keyword);
		}

}
