package study.cafe.luna.ReserveTime.dao;

import java.util.List;

import study.cafe.luna.ReserveTime.dto.ReserveTimeDTO;

public interface ReserveTimeDAO {
	//시간대 통계 
	List<ReserveTimeDTO> mgAgeList(String paid_at_start, String paid_at_end);

	//차트 리스트값
	List<ReserveTimeDTO> getreservcount(String paid_at_start, String paid_at_end, String branchName);

} 
 