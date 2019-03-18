package study.cafe.luna.gongji.service.Impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.gongji.dao.AdminGongjiBoardDAO;
import study.cafe.luna.gongji.dao.Impl.AdminGongiBoardDAOImpl;
import study.cafe.luna.gongji.dto.AdminGongjiBoardDTO;
import study.cafe.luna.gongji.service.InsertGongiBoardService;

@Service
public class InsertGongjiBoardServiceImpl implements InsertGongiBoardService {
	
	@Inject
	AdminGongjiBoardDAO adminNoticeBoardDAO;
	@Autowired
	AdminGongiBoardDAOImpl noticeBoardDAOImpl;
	
	@Override
	public void noticeinsert(AdminGongjiBoardDTO vo) throws Exception {
		adminNoticeBoardDAO.noticeinsert(vo);
	}
}
