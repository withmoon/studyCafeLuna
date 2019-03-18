package study.cafe.luna.Refound.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.Refound.dao.RefundDAO;
import study.cafe.luna.Refound.dto.RefundDTO;
import study.cafe.luna.Refound.service.RefundService;

@Service  
public class RefundServiceImpl implements RefundService {
		
		@Autowired
		private RefundDAO refundDAO;
	
		//환불하기
		@Override
		public List<RefundDTO> mgRefund(int start, int end, String searchOption, String keyword, String branchName) {
			System.out.println("mgRefund 서비스");
			return refundDAO.mgRefund(start,end, searchOption,keyword,branchName);
		}
		@Override //환불하기 리스트 카운트
		public int RefundCount(String searchOption, String keyword, String branchName) {
			System.out.println("RefundCount 서비스");
			return refundDAO.RefundCount(searchOption,keyword,branchName); 
		}
		@Override //환불하기 
		public void Refund(int seq, int roomnum, String reservdate) {
			System.out.println("Refund 서비스");
			refundDAO.Refund(seq,roomnum,reservdate);
		}
}
