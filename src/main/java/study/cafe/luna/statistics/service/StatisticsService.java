package study.cafe.luna.statistics.service;

import java.util.List;

import study.cafe.luna.statistics.dto.StatisticsDTO;

  
public interface StatisticsService {

	//게시글 카운트
	int countArticle(String searchOption, String keyword);
	//일별 매출 리스트
	List<StatisticsDTO> SalesReserveList(int start, int end, String date1, String date2);
	//기간별 카운트
	int count(String date1, String date2, String branchName);
	//월별 리스트
	List<StatisticsDTO> SalesReservemonth(int start, int end, String searchOption, String keyword);
	

} 
