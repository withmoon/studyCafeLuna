package study.cafe.luna.management.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.management.dao.ManagermentDAO;
import study.cafe.luna.management.dto.ManagementDTO;
import study.cafe.luna.management.service.GetManagermentService;
 
@Service
public class GetManagermentServiceImpl implements GetManagermentService {
 
	@Autowired
	private ManagermentDAO managermentDAO;
	
	/*회원관리 리스트 DB*/  
	@Override
	public List<ManagementDTO> managermentList(int start, int end, String keyword,String searchOption) throws Exception {
		System.out.println("SalesList 서비스");
		return managermentDAO.managermentList(start,end,keyword,searchOption); 
	}
	@Override
	public int countArticle(String keyword ) {
		System.out.println("countArticle 서비스");
		return managermentDAO.countArticle(keyword);
	}
	
	
}
