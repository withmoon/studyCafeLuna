package study.cafe.luna.notice.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import study.cafe.luna.notice.dao.NoticeBoardDAO;
import study.cafe.luna.notice.dto.NoticeBoardDTO;

@Repository
public class NoticeBoardDAOImpl implements NoticeBoardDAO {

	@Inject
	SqlSessionTemplate sqlsession;

	@Override
	public void noticeinsert(NoticeBoardDTO vo) throws Exception {
		sqlsession.insert("noticeBoardDAO.noticeinsert", vo);
	}

	@Override
	public void noticeupdate(NoticeBoardDTO vo) throws Exception {
		sqlsession.update("noticeBoardDAO.noticeupdate",vo);
		
	}

	@Override
	public NoticeBoardDTO noticeread(int num) throws Exception {
		return sqlsession.selectOne("noticeBoardDAO.noticeread",num);
	}

	@Override
	public void noticedelete(int num) throws Exception {
		sqlsession.delete("noticeBoardDAO.noticedelete",num);
	}

	/*user_inform*/
	//공지사항 목록
	public List<NoticeBoardDTO> noticeAll(int start, int end) {	
		Map<String, Object> map = new HashMap<String, Object>();
     	map.put("start", start);
     	map.put("end", end);
    
		return sqlsession.selectList("noticeBoardDAO.noticeAll", map);
	}

	//글 갯수
	public int countNotice(String title) {
		return sqlsession.selectOne("noticeBoardDAO.countNotice", title);
	}

	//공지사항 상세보기
	public NoticeBoardDTO read(int num) {
		return sqlsession.selectOne("noticeBoardDAO.viewNotice", num);
	}
}
