package study.cafe.luna.roomrank.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.roomrank.dao.RoomRankDAO;
import study.cafe.luna.roomrank.dto.RoomRankDTO;
@Repository
public class RoomRankDAOImpl implements RoomRankDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberDTO> getNewBranch() {
		return sqlSession.selectList("rankDAO.getNewBranch");
	}
	@Override
	public List<RoomRankDTO> getNewReview() {
		return sqlSession.selectList("rankDAO.getNewReview");
	}
	@Override
	public List<RoomRankDTO> getRoomReserveRank() {
		return sqlSession.selectList("rankDAO.getRoomReserveRank");
	}
	@Override
	public List<RoomRankDTO> getRoomReviewRank() {
		return sqlSession.selectList("rankDAO.getRoomReviewRank");
	}
}
