package study.cafe.luna.roomrank.service;

import java.util.List;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.roomrank.dto.RoomRankDTO;

public interface RoomRankServicie {
	//평점과 리뷰순 방정보 구해오기
	List<RoomRankDTO> getRoomReviewRank();
	//예약순으로 방정보 구해오기
	List<RoomRankDTO> getRoomReserveRank();
	//최신 지점 가져오기
	List<MemberDTO> getNewBranch();
	//최신 리뷰 6개 가져오기
	List<RoomRankDTO> getNewReview();
}
