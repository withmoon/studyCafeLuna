package study.cafe.luna.howtouse.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.howtouse.dao.HowToUseDAO;
import study.cafe.luna.howtouse.dto.HowToUseDTO;
@Repository
public class HowToUseDAOImpl implements HowToUseDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertHowToUse(HowToUseDTO htu) {
		sqlSession.insert("htuDAO.insertHowToUse",htu);
	}

	@Override
	public List<HowToUseDTO> getHowToUseList() {
		return sqlSession.selectList("htuDAO.getHowToUseList");
	}

	@Override
	public Integer getHowToUseMaxNum() {
		return sqlSession.selectOne("htuDAO.getHowToUseMaxNum");
	}

	@Override
	public Integer getHowToUseMaxCnum(int num) {
		return sqlSession.selectOne("htuDAO.getHowToUseMaxCnum",num);
	}

	@Override
	public List<HowToUseDTO> getHowToUseContent(int num) {
		return sqlSession.selectList("htuDAO.getHowToUseContent",num);
	}

	@Override
	public void deleteHowToUseContent(HowToUseDTO htu) {
		sqlSession.delete("htuDAO.deleteHowToUseContent",htu);
	}

	@Override
	public void deleteHowToUse(int num) {
		sqlSession.delete("htuDAO.deleteHowToUse",num);
	}

	@Override
	public void updateHowToUseContent(HowToUseDTO htu) {
		sqlSession.update("htuDAO.updateHowToUseContent",htu);
	}

	@Override
	public String getDefaultImg(HowToUseDTO htu) {
		return sqlSession.selectOne("htuDAO.getDefaultImg",htu);
	}

}
