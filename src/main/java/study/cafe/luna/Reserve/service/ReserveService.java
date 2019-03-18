package study.cafe.luna.Reserve.service;

import java.util.List;

import study.cafe.luna.Reserve.dto.ReserveDTO;
 
public interface ReserveService {
	// 예약현황 
	public List<ReserveDTO> mgReserveList(int start, int end, String searchOption, String keyword, String branchName);
	//예약현황 카운트
	public int ReserveCount(String searchOption, String keyword, String branchName);
	
}
