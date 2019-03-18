package study.cafe.luna.gongji.service.Impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.gongji.dao.AdminGongjiBoardDAO;
import study.cafe.luna.gongji.dao.Impl.AdminNoticeBoardDAOImpl;
import study.cafe.luna.gongji.service.DeleteNoticeBoardService;

@Service
public class DeleteNoticeBoardServiceImpl implements DeleteNoticeBoardService {
	
	@Inject
	AdminGongjiBoardDAO adminNoticeBoardDAO;
	@Autowired 
	AdminNoticeBoardDAOImpl noticeBoardDAOImpl;
	
	@Override
	public void noticedelete(int num) throws Exception {
		// TODO Auto-generated method stub
		adminNoticeBoardDAO.noticedelete(num);
	}
}
