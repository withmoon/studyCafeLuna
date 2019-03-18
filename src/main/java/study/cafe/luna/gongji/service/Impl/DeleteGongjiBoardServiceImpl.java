package study.cafe.luna.gongji.service.Impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.gongji.dao.AdminGongjiBoardDAO;
import study.cafe.luna.gongji.dao.Impl.AdminGongiBoardDAOImpl;
import study.cafe.luna.gongji.service.DeleteGongiBoardService;

@Service
public class DeleteGongjiBoardServiceImpl implements DeleteGongiBoardService {
	
	@Inject
	AdminGongjiBoardDAO adminNoticeBoardDAO;
	@Autowired 
	AdminGongiBoardDAOImpl noticeBoardDAOImpl;
	
	@Override
	public void noticedelete(int num) throws Exception {
		// TODO Auto-generated method stub
		adminNoticeBoardDAO.noticedelete(num);
	}
}
