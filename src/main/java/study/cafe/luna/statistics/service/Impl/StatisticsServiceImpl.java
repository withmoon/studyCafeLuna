package study.cafe.luna.statistics.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.statistics.dao.StatisticsDAO;
import study.cafe.luna.statistics.dto.StatisticsDTO;
import study.cafe.luna.statistics.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService{
  
	@Autowired
	private StatisticsDAO DAO;
	
	@Override
	public int countArticle(String searchOption, String keyword) {
		System.out.println("월매출 카운트 서비스");
		return DAO.countArticle(searchOption,keyword);
	}
 
	@Override
	public List<StatisticsDTO> SalesReserveList(int start, int end, String date1, String date2) {
		System.out.println("일매출 리스트 서비스");
		return DAO.SalesReserveList(start,end,date1,date2);
	}

	@Override
	public List<StatisticsDTO> SalesReservemonth(int start, int end, String searchOption, String keyword) {
		System.out.println("월매출 리스트 서비스");
		return DAO.SalesReservemonth(start,end,searchOption,keyword);
	}

	@Override
	public int count(String date1, String date2, String branchName) {
		System.out.println("count 서비스");
		return DAO.count(date1,date2,branchName);
	}

	
}
