package study.cafe.luna.gongji.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.gongji.dao.AdminGongjiBoardDAO;
import study.cafe.luna.gongji.dto.AdminGongjiBoardDTO;

@Repository
public class AdminGongiBoardDAOImpl implements AdminGongjiBoardDAO {

	@Inject
	SqlSession sqlsession;
	@Autowired
	SqlSessionTemplate SqlSession;

	@Override
	public void noticeinsert(AdminGongjiBoardDTO vo) throws Exception {
		sqlsession.insert("luna.admin.board.noticeinsert", vo);
	}

	@Override
	public void noticeupdate(AdminGongjiBoardDTO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update("luna.admin.board.noticeupdate",vo);
		
	}

	@Override
	public AdminGongjiBoardDTO noticeread(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("luna.admin.board.noticeread",num);
	}

	@Override
	public void noticedelete(int num) throws Exception {
		// TODO Auto-generated method stub
		
		sqlsession.delete("luna.admin.board.noticedelete",num);
	}

	/*user_inform*/
	//공지사항 목록
	public List<AdminGongjiBoardDTO> noticeAll(int start, int end) {
		System.out.println("===> 공지사항 목록");
		
		Map<String, Object> map = new HashMap<String, Object>();
     	map.put("start", start);
     	map.put("end", end);
    
		return SqlSession.selectList("noticeBoardDAO.noticeAll", map);
	}

	//글 갯수
	public int countNotice(String title) {
		return SqlSession.selectOne("noticeBoardDAO.countNotice", title);
	}

	//공지사항 상세보기
	public AdminGongjiBoardDTO read(int num) {
		System.out.println("===> 공지사항 상세보기");
		return SqlSession.selectOne("noticeBoardDAO.viewNotice", num);
	}
}
