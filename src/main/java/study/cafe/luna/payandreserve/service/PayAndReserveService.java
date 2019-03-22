package study.cafe.luna.payandreserve.service;

import java.util.List;

import study.cafe.luna.payment.dto.RoomPaymentDTO;
import study.cafe.luna.payment.dto.RoomReserveDTO;
import study.cafe.luna.room.dto.MyPageInfoDTO;

public interface PayAndReserveService {
	//payAndReservDAO
	//예약테이블에 오늘날짜를 가진 예약 row가 있나 확인
	Integer checkReservStartdate(RoomReserveDTO romre);
	//예약테이블 insert
	void inReserveRoom(RoomReserveDTO romre);
	//예약테이블 update
	void upReserveRoom(RoomReserveDTO romre);
	//예약&결제 테이블 insert
	void inRoomPayment(RoomPaymentDTO rompay);
	// 예약&결제 테이블 가져옴
	List<MyPageInfoDTO> getUserPayInfo(int start,int end,String status,String id,String startdate,String enddate);
	//카운팅
	Integer getUserPayCount(String status,String id,String startdate,String enddate);
	//사용자측에서 환불요청
	void cancleReserve(MyPageInfoDTO mpif);
	//작년 예약수
	Integer getPreYearReserveCount();
	//올해 예약수
	Integer getThisYearReserveCount();
	//전일 예약수
	Integer getPreDayReserveCount();
	//전월 예약수
	Integer getPreMonthReserveCount(); 
	//기간 매출
	List<RoomPaymentDTO> getTermSales(String paid_at_start, String paid_at_end);
	//baseLine 설정
	 void setBaseLine(RoomPaymentDTO dto);
	 //결제 전 확인
	 Integer checkIsPayed(RoomReserveDTO romre);
}
