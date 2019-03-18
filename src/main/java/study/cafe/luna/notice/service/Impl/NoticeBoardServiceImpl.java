package study.cafe.luna.notice.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.notice.dao.NoticeBoardDAO;
import study.cafe.luna.notice.dto.NoticeBoardDTO;
import study.cafe.luna.notice.service.NoticeBoardService;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {

	@Autowired
	NoticeBoardDAO ntbd;
	
	@Override
	public void noticeinsert(NoticeBoardDTO vo) throws Exception {
		ntbd.noticeinsert(vo);
	}


	@Override
	public void noticeupdate(NoticeBoardDTO vo) throws Exception {
		ntbd.noticeupdate(vo);
		
	}


	@Override
	public NoticeBoardDTO noticeread(int num) throws Exception {
		// TODO Auto-generated method stub
		return ntbd.noticeread(num);
	}


	@Override
	public void noticedelete(int num) throws Exception {
		// TODO Auto-generated method stub
		ntbd.noticedelete(num);
	}

	/*user_inform*/
	//공지사항 이벤트 목록
	@Override
	public List<NoticeBoardDTO> noticeAll(int start, int end, HttpSession session) {
		return ntbd.noticeAll(start, end);
	}

	//글 갯수
	@Override
	public int countNotice(String title) {
		return ntbd.countNotice(title);
	}

	//공지사항 상세보기
	@Override
	public NoticeBoardDTO read(int num) throws Exception {
		return ntbd.read(num);
	}

}
