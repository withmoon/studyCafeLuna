package study.cafe.luna.notice.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.notice.dto.NoticeBoardDTO;


public interface NoticeBoardService {

	public void noticeinsert(NoticeBoardDTO vo)throws Exception;
	
	public void noticedelete(int num)throws Exception;
	
	public void noticeupdate(NoticeBoardDTO vo)throws Exception;
	
	public NoticeBoardDTO noticeread(int num)throws Exception;

	/*user_inform*/
	public List<NoticeBoardDTO> noticeAll(int start, int end, HttpSession session); //공지사항목록
	public int countNotice(String title); //글 갯수
	public NoticeBoardDTO read(int num) throws Exception; //공지사항 상세보기
}
