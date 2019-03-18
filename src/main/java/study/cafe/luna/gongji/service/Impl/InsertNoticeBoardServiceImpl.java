package study.cafe.luna.gongji.service.Impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.gongji.dao.AdminGongjiBoardDAO;
import study.cafe.luna.gongji.dao.Impl.AdminNoticeBoardDAOImpl;
import study.cafe.luna.gongji.dto.AdminGongjiBoardDTO;
import study.cafe.luna.gongji.service.InsertNoticeBoardService;

@Service
public class InsertNoticeBoardServiceImpl implements InsertNoticeBoardService {
	
	@Inject
	AdminGongjiBoardDAO adminNoticeBoardDAO;
	@Autowired
	AdminNoticeBoardDAOImpl noticeBoardDAOImpl;
	
	@Override
	public void noticeinsert(AdminGongjiBoardDTO vo) throws Exception {
		adminNoticeBoardDAO.noticeinsert(vo);
	}
}
