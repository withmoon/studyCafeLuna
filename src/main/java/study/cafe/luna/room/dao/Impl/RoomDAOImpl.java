package study.cafe.luna.room.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.room.dao.RoomDAO;
import study.cafe.luna.room.dto.RoomFileDTO;
import study.cafe.luna.room.dto.RoomInfoDTO;
@Repository
public class RoomDAOImpl implements RoomDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<RoomInfoDTO> getAllRoomInfo(RoomInfoDTO romin) {
		return sqlSession.selectList("roomDAO.getAllRoomInfo",romin);
	}
	@Override
	public RoomInfoDTO getDetailRoomInfo(RoomInfoDTO romin) {
		return sqlSession.selectOne("roomDAO.getDetailRoomInfo",romin);
	}
	@Override
	public List<RoomInfoDTO> getExcRoomNum(RoomInfoDTO romin) {
		return sqlSession.selectList("roomDAO.getExcRoomNum", romin);
	}
	@Override
	public List<String> getGugun(String sido) {
		return sqlSession.selectList("roomDAO.getGugun",sido);
	}
	@Override
	public List<RoomFileDTO> getRoomAllimg(int roomnum) {
		return sqlSession.selectList("roomDAO.getRoomAllimg",roomnum);
	}
	@Override
	public RoomInfoDTO getRoomSchedule(RoomInfoDTO romin) {
		return sqlSession.selectOne("roomDAO.getRoomSchedule", romin);
	}
	@Override
	public List<String> getSido() {
		return sqlSession.selectList("roomDAO.getSido");
	}
}
