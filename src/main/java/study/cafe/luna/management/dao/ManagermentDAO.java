package study.cafe.luna.management.dao;

import java.util.List;

import study.cafe.luna.management.dto.ManagementDTO;

public interface ManagermentDAO {

	//회원현황 
	public List<ManagementDTO> managermentList(int start, int end, String keyword, String searchOption) throws Exception;
	//테이블 카운트
	public int countArticle(String keyword);

}
