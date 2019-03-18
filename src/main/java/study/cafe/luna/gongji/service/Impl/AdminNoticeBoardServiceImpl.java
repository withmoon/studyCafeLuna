package study.cafe.luna.gongji.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.gongji.dao.AdminGongjiBoardDAO;
import study.cafe.luna.gongji.dao.Impl.AdminNoticeBoardDAOImpl;
import study.cafe.luna.gongji.dto.AdminGongjiBoardDTO;
import study.cafe.luna.gongji.service.AdminNoticeBoardService;
 
@Service
public class AdminNoticeBoardServiceImpl implements AdminNoticeBoardService{

	@Inject
	AdminGongjiBoardDAO adminNoticeBoardDAO;
	@Autowired
	AdminNoticeBoardDAOImpl noticeBoardDAOImpl;
	
	/*user_inform*/
	//공지사항 이벤트 목록
	@Override
	public List<AdminGongjiBoardDTO> noticeAll(int start, int end, HttpSession session) {
		return noticeBoardDAOImpl.noticeAll(start, end);
	}

	//글 갯수
	@Override
	public int countNotice(String title) {
		return noticeBoardDAOImpl.countNotice(title);
	}

	//공지사항 상세보기
	@Override
	public AdminGongjiBoardDTO read(int num) throws Exception {
		return noticeBoardDAOImpl.read(num);
	}
}
