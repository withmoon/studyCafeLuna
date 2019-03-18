package study.cafe.luna.ReserveTime.service;

import java.util.List;

import study.cafe.luna.ReserveTime.dto.ReserveTimeDTO;

public interface mgReserveTimeService {
	 
	//나이? 시간대별통계
	List<ReserveTimeDTO> mgAgeList(String paid_at_start, String paid_at_end);
	//시간 비교
//	List<ReserveTimeVO> mgsu(List<ReserveTimeVO> list, ReserveTimeVO vo);
	ReserveTimeDTO mgsu(List<ReserveTimeDTO> list, ReserveTimeDTO vo);

	//기간통계
	List<ReserveTimeDTO> getreservcount(String paid_at_start, String paid_at_end, String branchName);

} 
