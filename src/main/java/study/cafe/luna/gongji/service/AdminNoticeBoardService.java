package study.cafe.luna.gongji.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.gongji.dto.AdminGongjiBoardDTO;

public interface AdminNoticeBoardService {
	/*user_inform*/
	public List<AdminGongjiBoardDTO> noticeAll(int start, int end, HttpSession session); //공지사항목록
	public int countNotice(String title); //글 갯수
	public AdminGongjiBoardDTO read(int num) throws Exception; //공지사항 상세보기
}
