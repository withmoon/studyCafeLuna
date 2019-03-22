package study.cafe.luna.Refound.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.Refound.dao.RefundDAO;
import study.cafe.luna.Refound.dto.RefundDTO;

@Repository
public class RefundDAOImpl implements RefundDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//환불현황 카운트
	@Override
	public int RefundCount(String searchOption, String keyword, String branchName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", branchName);
		return sqlSession.selectOne("refundDAO.RefundCount", map);
	}
	@Override
	public void Refund(int seq, int roomnum, String reservdate) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq",seq); 
		map.put("roomnum",roomnum);
		map.put("reservdate",reservdate);
		System.out.println(seq);
		System.out.println(roomnum);
		System.out.println(reservdate);
		
		sqlSession.update("refundDAO.Refund",map);
	}
	//환불 현황
		@Override
		public List<RefundDTO> mgRefund(int start, int end, String searchOption, String keyword, String branchName) {
			System.out.println("mgRefund DAO 수행");
			//검색옵션 , 키워드 맵에 저장
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("searchOption", searchOption);
			map.put("keyword", keyword);
			map.put("branchName", branchName);
			//#start #end 에 입력될 값
			map.put("start",start);
			map.put("end", end);
			
			return sqlSession.selectList("refundDAO.mgRefund",map);
		}
	
}
