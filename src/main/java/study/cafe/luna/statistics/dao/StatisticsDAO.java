package study.cafe.luna.statistics.dao;

import java.util.List;
import study.cafe.luna.Reserve.dto.ReserveDTO;
import study.cafe.luna.statistics.dto.StatisticsDTO;

public interface StatisticsDAO {
  
	// 월매출 일별 리스트
	List<StatisticsDTO> SalesReserveList(int start, int end, String date1, String date2);
	// 월매출 월별 리스트
	List<StatisticsDTO> SalesReservemonth(int start, int end, String searchOption, String keyword);

	// 월매출 글 카운트
	int countArticle(String searchOption, String keyword);
	//기간별 매출 카운트
	int count(String date1, String date2, String branchName);
	//엑셀 리시튼
	List<ReserveDTO> excelList(String date1, String date2, String branchName, int count);
	List<Object> getSales(ReserveDTO vo);

} 
