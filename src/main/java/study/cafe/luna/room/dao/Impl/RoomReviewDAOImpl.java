package study.cafe.luna.room.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.room.dao.RoomReviewDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;

@Repository
public class RoomReviewDAOImpl implements RoomReviewDAO{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void delReviewContent(RoomReviewDTO rrd) {
		sqlSession.delete("reviewDAO.delReviewContent",rrd);
	}
	@Override
	public Integer getReviewCount(int roomnum) {
		return sqlSession.selectOne("reviewDAO.getReviewCount",roomnum);
	}
	@Override
	public List<Integer> getReviewRank() {
		return sqlSession.selectList("reviewDAO.getReviewRank");
	}
	@Override
	public String getReviewStarAvg(int roomnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("reviewDAO.getReviewStarAvg",roomnum);
	}
	@Override
	public List<RoomReviewDTO> getRoomAllReview(int start,int end,int roomnum) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roomNum", roomnum);
		map.put("start",start);
		map.put("end", end);
		return sqlSession.selectList("reviewDAO.getRoomAllReview",map);
	}
	@Override
	public List<String> getUserReview(String id) {
		return sqlSession.selectList("reviewDAO.getUserReview",id);
	}
	@Override
	public void insertReview(RoomReviewDTO rrd) {
		sqlSession.insert("reviewDAO.insertReview",rrd);
	}
	@Override
	public void upReviewContent(RoomReviewDTO rrd) {
		sqlSession.update("reviewDAO.upReviewContent",rrd);
	}
}
