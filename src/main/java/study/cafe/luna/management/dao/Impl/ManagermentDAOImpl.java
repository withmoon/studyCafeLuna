package study.cafe.luna.management.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.management.dao.ManagermentDAO;
import study.cafe.luna.management.dto.ManagementDTO;

@Repository
public class ManagermentDAOImpl implements ManagermentDAO {

	@Autowired
	private SqlSession sqlSession;
 
	/*회원현황 DB데이터 가져오기*/
	@Override
	public List<ManagementDTO> managermentList(int start, int end,String keyword,String searchOption) throws Exception {
		System.out.println("SalesList DAO 수행");
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("keyword", keyword);
		map.put("searchOption", searchOption);
		//#start #end  에 입력될 값
		map.put("start",start);
		map.put("end", end); 
		
		return sqlSession.selectList("managermentDAO.listAll",map);
	}
	
	@Override
	public int countArticle(String keyword) {
		System.out.println("countArticle DAO 수행");
		return sqlSession.selectOne("managermentDAO.countArticle",keyword);
	}
	
	

	
}
