package study.cafe.luna.ReserveTime.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.ReserveTime.dao.ReserveTimeDAO;
import study.cafe.luna.ReserveTime.dto.ReserveTimeDTO;

@Repository
public class ReserveTimeDAOImpl implements ReserveTimeDAO {
 
	@Autowired
	private SqlSession SqlSession;
	  
	
	 
	@Override
	public List<ReserveTimeDTO> mgAgeList(String paid_at_start, String paid_at_end) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date1", paid_at_start);
		map.put("date2", paid_at_end);
		return SqlSession.selectList("mgReserveTime.mgAgeList",map);
	}

	@Override
	public List<ReserveTimeDTO> getreservcount(String paid_at_start, String paid_at_end, String branchName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date1", paid_at_start);
		map.put("date2", paid_at_end);
		map.put("branchName", branchName);
		return SqlSession.selectList("mgReserveTime.getreservcount",map);
	}

}
