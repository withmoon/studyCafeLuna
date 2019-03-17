package study.cafe.luna.statistics.service;

import java.util.List;
import java.util.Map;

import study.cafe.luna.Reserve.dto.ReserveDTO;

public interface DownloadExcelService {
	// 엑셀
	public List<Object> getExcelObject(Map<String, Object> paramMap);

	public List<Object> excelList(ReserveDTO vo);
	//엑셀 리스트
	List<ReserveDTO> excelList(int count, String date1, String date2,String branchName);
	//기간별 카운트
	int count(String date1, String date2, String branchName);
		
}
