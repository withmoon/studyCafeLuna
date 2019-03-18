package study.cafe.luna.gongji.dao;

import java.util.List;

import study.cafe.luna.gongji.dto.AdminGongjiBoardDTO;


public interface AdminGongjiBoardDAO {

	public void noticeinsert(AdminGongjiBoardDTO vo) throws Exception;

	public void noticeupdate(AdminGongjiBoardDTO vo)throws Exception;
	
	public void noticedelete(int num)throws Exception;
	
	public AdminGongjiBoardDTO noticeread(int num) throws Exception;
	
	/*user_inform*/
	public List<AdminGongjiBoardDTO> noticeAll(int start, int end); //공지사항목록
	public int countNotice(String title); //글 갯수
	public AdminGongjiBoardDTO read(int num) throws Exception; //공지사항 상세보기
}
