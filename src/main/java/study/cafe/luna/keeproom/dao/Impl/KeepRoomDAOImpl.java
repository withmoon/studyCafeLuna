package study.cafe.luna.keeproom.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.keeproom.dao.KeepRoomDAO;
import study.cafe.luna.keeproom.dto.KeepRoomDTO;
import study.cafe.luna.room.dto.RoomInfoDTO;

@Repository
public class KeepRoomDAOImpl implements KeepRoomDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void deletekroom(KeepRoomDTO krd) {
		sqlSession.delete("keepRoomDAO.deletekroom",krd);
	}
	
	@Override
	public Integer getKeepCount(String id) {
		return sqlSession.selectOne("keepRoomDAO.getKeepCount",id);
	}
	@Override
	public List<RoomInfoDTO> getKeeplist(int start, int end,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("start",start);
		map.put("end", end);
		return sqlSession.selectList("keepRoomDAO.getKeeplist",map);
	}
	@Override
	public Integer getKeepStatus(KeepRoomDTO krd) {
		return sqlSession.selectOne("keepRoomDAO.getKeepStatus",krd);
	}@Override
	public void keeproom(KeepRoomDTO krd) {
		sqlSession.insert("keepRoomDAO.keeproom",krd);
	}

}
