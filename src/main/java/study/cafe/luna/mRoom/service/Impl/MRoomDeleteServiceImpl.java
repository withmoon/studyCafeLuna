package study.cafe.luna.mRoom.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.mRoom.dao.MRoomDAO;
import study.cafe.luna.mRoom.service.MRoomDeleteService;

@Service
public class MRoomDeleteServiceImpl implements MRoomDeleteService{
	@Autowired
	public MRoomDAO mRoomDAO;
	
	// �����ϱ�
		@Override
		public void RoomDelete(int roomnum) throws Exception {
			mRoomDAO.mgRoomDelete(roomnum);
		}

		@Override
		public void filDelete(int roomnum) throws Exception {
			// TODO Auto-generated method stub
			mRoomDAO.mgRoomFileDelete(roomnum);
		}
}
