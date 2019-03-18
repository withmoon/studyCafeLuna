package study.cafe.luna.notice.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.notice.dto.NoticeBoardDTO;

public interface NoticeBoardService {
	/*user_inform*/
	public List<NoticeBoardDTO> noticeAll(int start, int end, HttpSession session); //공지사항목록
	public int countNotice(String title); //글 갯수
	public NoticeBoardDTO read(int num) throws Exception; //공지사항 상세보기
}
 