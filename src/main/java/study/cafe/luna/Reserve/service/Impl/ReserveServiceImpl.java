package study.cafe.luna.Reserve.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.Reserve.dao.ReserveDAO;
import study.cafe.luna.Reserve.dto.ReserveDTO;
import study.cafe.luna.Reserve.service.ReserveService;

@Service
public class ReserveServiceImpl implements ReserveService {
	
	@Autowired
	private ReserveDAO reserveDAO;
	
	//예약현황 리스트
	@Override
	public List<ReserveDTO> mgReserveList(int start, int end, String searchOption, String keyword,String branchName) {
		System.out.println("mgReserveList 서비스");
		return reserveDAO.mgReserveList(start,end, searchOption,keyword,branchName);
	}
	//예약현황 카운트
	@Override
	public int ReserveCount(String searchOption, String keyword, String branchName) {
		System.out.println("ReserveCount 서비스");
		return reserveDAO.ReserveCount(searchOption,keyword,branchName);
	}
}
