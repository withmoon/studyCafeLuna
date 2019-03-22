package study.cafe.luna.payandreserve.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.payandreserve.dao.PayAndReserveDAO;
import study.cafe.luna.payandreserve.service.PayAndReserveService;
import study.cafe.luna.payment.dto.RoomPaymentDTO;
import study.cafe.luna.payment.dto.RoomReserveDTO;
import study.cafe.luna.room.dto.MyPageInfoDTO;

@Service
public class PayAndReserveServiceImpl implements PayAndReserveService{
	@Autowired
	PayAndReserveDAO pard;
	
	@Override
	public Integer checkReservStartdate(RoomReserveDTO romre) {
		return pard.checkReservStartdate(romre);
	}
	@Override
	public void inReserveRoom(RoomReserveDTO romre) {
		pard.inReserveRoom(romre);
	}
	@Override
	public void upReserveRoom(RoomReserveDTO romre) {
		pard.upReserveRoom(romre);
	}
	@Override
	public void inRoomPayment(RoomPaymentDTO rompay) {
		pard.inRoomPayment(rompay);
	}
	@Override
	public List<MyPageInfoDTO> getUserPayInfo(int start,int end,String status,String id,String startdate,String enddate) {
		return pard.getUserPayInfo(start,end,status,id,startdate,enddate);
	}
	@Override
	public void cancleReserve(MyPageInfoDTO mpif) {
		pard.cancleReserve(mpif);
	}
	@Override
	public Integer getUserPayCount(String status, String id,String startdate,String enddate) {
		return pard.getUserPayCount(status, id,startdate,enddate);
	}
	@Override
	public Integer getPreYearReserveCount() {
		return pard.getPreYearReserveCount();
	}
	@Override
	public Integer getThisYearReserveCount() {
		return pard.getThisYearReserveCount();
	}
	@Override
	public Integer getPreDayReserveCount() {
		return pard.getPreDayReserveCount();
	}
	@Override
	public Integer getPreMonthReserveCount() {
		return pard.getPreMonthReserveCount();
	}
	@Override
	public List<RoomPaymentDTO> getTermSales(String paid_at_start, String paid_at_end) {
		return pard.getTermSales(paid_at_start, paid_at_end);
	}
	@Override
	public void setBaseLine(RoomPaymentDTO dto) {
		pard.setBaseLine(dto);
	}
	@Override
	public Integer checkIsPayed(RoomReserveDTO romre) {
		return pard.checkIsPayed(romre);
	}
}
