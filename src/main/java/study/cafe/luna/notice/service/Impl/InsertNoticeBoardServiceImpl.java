package study.cafe.luna.notice.service.Impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import study.cafe.luna.notice.dao.NoticeBoardDAO;
import study.cafe.luna.notice.dto.NoticeBoardDTO;
import study.cafe.luna.notice.service.InsertNoticeBoardService;

@Service
public class InsertNoticeBoardServiceImpl implements InsertNoticeBoardService {
	
	@Inject
	NoticeBoardDAO noticeBoardDAO;
	
	@Override
	public void noticeinsert(NoticeBoardDTO vo) throws Exception {
		noticeBoardDAO.noticeinsert(vo);
	}
}
