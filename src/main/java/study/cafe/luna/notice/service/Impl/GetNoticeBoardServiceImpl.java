package study.cafe.luna.notice.service.Impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import study.cafe.luna.notice.dao.NoticeBoardDAO;
import study.cafe.luna.notice.dto.NoticeBoardDTO;
import study.cafe.luna.notice.service.GetNoticeBoardService;

@Service
public class GetNoticeBoardServiceImpl implements GetNoticeBoardService{
	@Inject
	NoticeBoardDAO noticeBoardDAO;
	
	@Override
	public NoticeBoardDTO noticeread(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeBoardDAO.noticeread(num);
	}

}
