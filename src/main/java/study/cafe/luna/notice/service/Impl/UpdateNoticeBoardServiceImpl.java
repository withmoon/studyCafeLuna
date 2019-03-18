package study.cafe.luna.notice.service.Impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import study.cafe.luna.notice.dao.NoticeBoardDAO;
import study.cafe.luna.notice.dto.NoticeBoardDTO;
import study.cafe.luna.notice.service.UpdateNoticeBoardService;

@Service
public class UpdateNoticeBoardServiceImpl implements UpdateNoticeBoardService {
	
	@Inject
	NoticeBoardDAO nGongjiBoardDAO;
	
	@Override
	public void noticeupdate(NoticeBoardDTO vo) throws Exception {
		nGongjiBoardDAO.noticeupdate(vo);
		
	}
}
