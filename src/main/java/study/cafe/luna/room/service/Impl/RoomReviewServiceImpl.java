package study.cafe.luna.room.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.room.dao.RoomReviewDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;
import study.cafe.luna.room.service.RoomReviewService;

@Service
public class RoomReviewServiceImpl implements RoomReviewService{
	@Autowired
	RoomReviewDAO rrvd;

	@Override
	public List<RoomReviewDTO> getRoomAllReview(int start,int end,int roomnum) {
		return rrvd.getRoomAllReview(start,end,roomnum);
	}

	@Override
	public Integer getReviewCount(int roomnum) {
		return rrvd.getReviewCount(roomnum);
	}

	@Override
	public String getReviewStarAvg(int roomnum) {
		return rrvd.getReviewStarAvg(roomnum);
	}

	@Override
	public void insertReview(RoomReviewDTO rrd) {
		rrvd.insertReview(rrd);
	}

	@Override
	public List<String> getUserReview(String id) {
		return rrvd.getUserReview(id);
	}

	@Override
	public List<Integer> getReviewRank() {
		return rrvd.getReviewRank();
	}

	@Override
	public void upReviewContent(RoomReviewDTO rrd) {
		rrvd.upReviewContent(rrd);
	}

	@Override
	public void delReviewContent(RoomReviewDTO rrd) {
		rrvd.delReviewContent(rrd);
	}
}
