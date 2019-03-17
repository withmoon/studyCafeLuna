package study.cafe.luna.management.service;

import java.util.List;

import study.cafe.luna.management.dto.ManagementDTO;
 
public interface GetManagermentService {
	// 회원리스트 검색 페이징
	public List<ManagementDTO> managermentList(int start, int end, String keyword, String searchOption) throws Exception;
	// 게시글 카운트
	public int countArticle(String keyword);

	
}
