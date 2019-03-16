package study.cafe.luna.roomrank.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.roomrank.dao.RoomRankDAO;
import study.cafe.luna.roomrank.dto.RoomRankDTO;
import study.cafe.luna.roomrank.service.RoomRankServicie;
@Service
public class RoomRankServiceImpl implements RoomRankServicie {
	
	@Autowired
	RoomRankDAO roomrankd;

	@Override
	public List<RoomRankDTO> getRoomReviewRank() {
		return roomrankd.getRoomReviewRank();
	}

	@Override
	public List<RoomRankDTO> getRoomReserveRank() {
		return roomrankd.getRoomReserveRank();
	}

	@Override
	public List<MemberDTO> getNewBranch() {
		return roomrankd.getNewBranch();
	}

	@Override
	public List<RoomRankDTO> getNewReview() {
		return roomrankd.getNewReview();
	}

}
