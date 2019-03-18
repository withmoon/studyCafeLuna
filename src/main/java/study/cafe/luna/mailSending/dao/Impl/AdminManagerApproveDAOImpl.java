package study.cafe.luna.mailSending.dao.Impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import study.cafe.luna.mailSending.dao.AdminManagerApproveDAO;
import study.cafe.luna.mailSending.dto.AdminManagerApproveDTO;

@Repository
public class AdminManagerApproveDAOImpl implements AdminManagerApproveDAO{

	@Inject
	SqlSession sqlsession;

	@Override
	public void approveupdate(String id){
			sqlsession.update("luna.admin.board.approveupdate", id);
	}

	@Override
	public void approvedelete(String id){
		sqlsession.delete("luna.admin.board.approvedelete",id);
		
	}

	@Override
	public List<String> AllMail(AdminManagerApproveDTO vo) {
		return sqlsession.selectList("luna.admin.board.AllMail",vo);
	}
	
}
