package study.cafe.luna.notice.dao;

import java.util.List;

import study.cafe.luna.notice.dto.NoticeBoardDTO;

public interface NoticeBoardDAO {

	void noticeinsert(NoticeBoardDTO vo) throws Exception;

	void noticeupdate(NoticeBoardDTO vo) throws Exception;

	void noticedelete(int num) throws Exception;

	NoticeBoardDTO noticeread(int num) throws Exception;

	/* user_inform */
	List<NoticeBoardDTO> noticeAll(int start, int end); // 공지사항목록

	int countNotice(String title); // 글 갯수

	NoticeBoardDTO read(int num) throws Exception; // 공지사항 상세보기
}
