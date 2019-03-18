package study.cafe.luna.Refound.dao;

import java.util.List;

import study.cafe.luna.Refound.dto.RefundDTO;

public interface RefundDAO {
	//환불리스트
	public List<RefundDTO> mgRefund(int start, int end, String searchOption, String keyword, String branchName);
	//환불현황 카운트
	public int RefundCount(String searchOption, String keyword, String branchName);
	//환불처리
	public void Refund(int seq, int roomnum, String reservdate);

}
