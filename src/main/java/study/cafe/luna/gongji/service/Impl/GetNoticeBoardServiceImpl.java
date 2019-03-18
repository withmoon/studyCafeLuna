package study.cafe.luna.gongji.service.Impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.gongji.dao.AdminGongjiBoardDAO;
import study.cafe.luna.gongji.dao.Impl.AdminNoticeBoardDAOImpl;
import study.cafe.luna.gongji.dto.AdminGongjiBoardDTO;
import study.cafe.luna.gongji.service.GetNoticeBoardService;

@Service
public class GetNoticeBoardServiceImpl implements GetNoticeBoardService{
	@Inject
	AdminGongjiBoardDAO adminNoticeBoardDAO;
	@Autowired
	AdminNoticeBoardDAOImpl noticeBoardDAOImpl;
	
	@Override
	public AdminGongjiBoardDTO noticeread(int num) throws Exception {
		// TODO Auto-generated method stub
		return adminNoticeBoardDAO.noticeread(num);
	}

}
