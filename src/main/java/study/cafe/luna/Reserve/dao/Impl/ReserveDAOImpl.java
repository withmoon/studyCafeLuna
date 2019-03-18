package study.cafe.luna.Reserve.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.Reserve.dao.ReserveDAO;
import study.cafe.luna.Reserve.dto.ReserveDTO;

@Repository
public class ReserveDAOImpl implements ReserveDAO {

	@Autowired
	private SqlSession sqlSession;

	//예약현황 카운트
	@Override
	public int ReserveCount(String searchOption, String keyword, String branchName) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", branchName);
		return sqlSession.selectOne("mgSalesDAO.ReserveCount", map);
	}

	// 예약현황
	@Override
	public List<ReserveDTO> mgReserveList(int start, int end, String searchOption, String keyword, String branchName) {
		System.out.println("mgReserveList DAO 수행");
		// 검색옵션 , 키워드 맵에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", branchName);
		// #start #end 에 입력될 값
		map.put("start", start);
		map.put("end", end);

		return sqlSession.selectList("mgSalesDAO.ReserveList", map);
	}

}
