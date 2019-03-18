package study.cafe.luna.notice.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import study.cafe.luna.notice.dao.NoticeBoardDAO;
import study.cafe.luna.notice.dto.NoticeBoardDTO;
import study.cafe.luna.notice.service.NoticeBoardService;
 
@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{

	@Inject
	NoticeBoardDAO noticeBoardDAO;
	
	/*user_inform*/
	//공지사항 이벤트 목록
	@Override
	public List<NoticeBoardDTO> noticeAll(int start, int end, HttpSession session) {
		return noticeBoardDAO.noticeAll(start, end);
	}

	//글 갯수
	@Override
	public int countNotice(String title) {
		return noticeBoardDAO.countNotice(title);
	}

	//공지사항 상세보기
	@Override
	public NoticeBoardDTO read(int num) throws Exception {
		return noticeBoardDAO.read(num);
	}
}
