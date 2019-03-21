package study.cafe.luna.room.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.room.dto.RoomReviewDTO;

public interface RoomReviewDAO {
	// 전체 리뷰 가져오기
	List<RoomReviewDTO> getRoomAllReview(int start, int end, int roomnum);

	// 해당방의 리뷰 카운트
	Integer getReviewCount(int roomnum);

	// 방번호에대한 총점 가져옴
	String getReviewStarAvg(int roomnum);

	// 리뷰 작성
	void insertReview(RoomReviewDTO rrd);

	// 사용자의 리뷰를 가져옴
	List<String> getUserReview(String id);

	// 평점순 평점이 같으면 리뷰 순으로 해서 3등까지 가져옴
	List<Integer> getReviewRank();

	// 사용자 리뷰 업데이트
	void upReviewContent(RoomReviewDTO rrd);

	// 리뷰 삭제
	void delReviewContent(RoomReviewDTO rrd);

	//매니저 리뷰 5개
	List<RoomReviewDTO> getReview(HttpSession session);
}
