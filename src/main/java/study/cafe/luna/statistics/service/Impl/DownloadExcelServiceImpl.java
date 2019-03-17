package study.cafe.luna.statistics.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.Reserve.dto.ReserveDTO;
import study.cafe.luna.statistics.dao.StatisticsDAO;
import study.cafe.luna.statistics.service.DownloadExcelService;

@Service
public class DownloadExcelServiceImpl implements DownloadExcelService {
	
	@Autowired
	private StatisticsDAO statisticsDAO;
	
	@Override
	public List<Object> excelList(ReserveDTO vo) {
		System.out.println("SalesExcel 서비스");
		return statisticsDAO.getSales(vo); 
	}
	
	/*매출현황 엑셀*/
	@Override
	public List<Object> getExcelObject(Map<String, Object> searchMap) {
		return null;
		/*	System.out.println("SalesExcel 서비스");
		//컨트롤러에서 넘어온 target에 따라 dao 실행구분
		System.out.println("Mg_sales DB 엑셀");
		return SalesDAO.getSales(searchMap);
		
		if("Mg_sales") {//DB�̸�
			System.out.println("Mg_sales DB 엑셀");
			return SalesDAO.getSales(searchMap);
		}
		if(target.equals("booksDetail")) {
			System.out.println("Mg_sales DB엑셀 조건식");
			return SalesDAO.getSalesDetail(searchMap);
		}*/
	}

	@Override
	public List<ReserveDTO> excelList(int count, String date1, String date2,String branchName) {
		System.out.println("count 서비스");
		return statisticsDAO.excelList(date1,date2,branchName,count);
	}
	@Override
	public int count(String date1, String date2, String branchName) {
		System.out.println("count 서비스");
		return statisticsDAO.count(date1,date2,branchName);
	}

	
}
