package study.cafe.luna.notice.service.Impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import study.cafe.luna.notice.dao.NoticeBoardDAO;
import study.cafe.luna.notice.service.DeleteNoticeBoardService;

@Service
public class DeleteNoticeBoardServiceImpl implements DeleteNoticeBoardService {
	
	@Inject
	NoticeBoardDAO noticeBoardDAO;
	
	@Override
	public void noticedelete(int num) throws Exception {
		// TODO Auto-generated method stub
		noticeBoardDAO.noticedelete(num);
	}
}
