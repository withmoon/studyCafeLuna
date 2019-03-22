package study.cafe.luna.payandreserve.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.payandreserve.dao.PayAndReserveDAO;
import study.cafe.luna.payment.dto.RoomPaymentDTO;
import study.cafe.luna.payment.dto.RoomReserveDTO;
import study.cafe.luna.room.dto.MyPageInfoDTO;
@Repository
public class PayAndReserveDAOImpl implements PayAndReserveDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void cancleReserve(MyPageInfoDTO mpif) {
		sqlSession.update("payAndReservDAO.cancleReserve",mpif);
	}
	@Override
	public Integer checkReservStartdate(RoomReserveDTO romre) {
		return sqlSession.selectOne("payAndReservDAO.checkReservStartdate",romre);
	}
	@Override
	public Integer getPreDayReserveCount() {
		return sqlSession.selectOne("payAndReservDAO.getPreDayReserveCount");
	}
	@Override
	public Integer getPreMonthReserveCount() {
		return sqlSession.selectOne("payAndReservDAO.getPreMonthReserveCount");
	}
	@Override
	public Integer getPreYearReserveCount() {
		return sqlSession.selectOne("payAndReservDAO.getPreYearReserveCount");
	}
	@Override
	public List<RoomPaymentDTO> getTermSales(String paid_at_start, String paid_at_end) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("paid_at_start", paid_at_start);
		map.put("paid_at_end", paid_at_end);
		return sqlSession.selectList("payAndReservDAO.getTermSales",map);
	}
	@Override
	public Integer getThisYearReserveCount() {
		return sqlSession.selectOne("payAndReservDAO.getThisYearReserveCount");
	}
	@Override
	public Integer getUserPayCount(String status, String id,String startdate,String enddate) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", status);
		map.put("id", id);
		map.put("startdate", startdate);
		map.put("enddate", enddate);
		return sqlSession.selectOne("payAndReservDAO.getUserPayCount",map);
	}
	@Override
	public List<MyPageInfoDTO> getUserPayInfo(int start,int end,String status,String id,String startdate,String enddate) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", status);
		map.put("id", id);
		map.put("start",start);
		map.put("end", end);
		map.put("startdate",startdate);
		map.put("enddate", enddate);
		return sqlSession.selectList("payAndReservDAO.getUserPayInfo",map);
	}
	@Override
	public List<MyPageInfoDTO> getUserReservedInfo(MemberDTO memcom) {
		return sqlSession.selectList("payAndReservDAO.getUserReservedInfo",memcom);
	}

	public void inReserveRoom(RoomReserveDTO romre) {
		sqlSession.insert("payAndReservDAO.inReserveRoom",romre);
	}
	@Override
	public void inRoomPayment(RoomPaymentDTO rompay) {
		sqlSession.insert("payAndReservDAO.inRoomPayment",rompay);
	}
	@Override
	public void setBaseLine(RoomPaymentDTO dto) {
		sqlSession.update("payAndReservDAO.setBaseLine",dto);
	}
	@Override
	public void upReserveRoom(RoomReserveDTO romre) {
		sqlSession.update("payAndReservDAO.upReserveRoom",romre);
	}
	@Override
	public Integer checkIsPayed(RoomReserveDTO romre) {
		return sqlSession.selectOne("payAndReservDAO.checkIsPayed",romre);
	}
}
