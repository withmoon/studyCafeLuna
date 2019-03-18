package study.cafe.luna.member.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.member.dao.MemberDAO;
import study.cafe.luna.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Integer allBranchCount() {
		return sqlSession.selectOne("memberDAO.allBranchCount");
	}
	@Override
	public Integer allMemberCount() {
		return sqlSession.selectOne("memberDAO.allMemberCount");
	}
	@Override
	public void cancleExpulmember(String id) {
		sqlSession.update("memberDAO.cancleExpulmember",id);
	}
	@Override
	public void deleteAdmin(String id) {
		sqlSession.delete("memberDAO.deleteAdmin",id);
	}
	@Override
	public List<MemberDTO> getAdminList() {
		return sqlSession.selectList("memberDAO.getAdminList");
	}

	@Override
	public List<String> branchList(String gugun) {
		return sqlSession.selectList("memberDAO.branchList", gugun);
	}
	@Override
	public String getBrName(String id) {
		return sqlSession.selectOne("memberDAO.getBrName",id);
	}
	@Override
	public MemberDTO getMyPageInfo(MemberDTO memcom) {
		return (MemberDTO) sqlSession.selectOne("memberDAO.getMyPageInfo",memcom);
	}
	@Override
	public int getStatus(MemberDTO memcom) {
		return sqlSession.selectOne("memberDAO.getStatus",memcom);
	}
	@Override
	public Integer idCheck(MemberDTO memcom) {	
		return sqlSession.selectOne("memberDAO.idCheck", memcom);
	}

	@Override
	public void insertAdmin(MemberDTO memcom) {
		sqlSession.insert("memberDAO.insertAdmin",memcom);
	}
	@Override
	public void insertMember(MemberDTO memcom) {
		sqlSession.insert("memberDAO.insertMember",memcom);
	}

	// 회원갯수
	@Override
	public List<MemberDTO> memberList(int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("memberDAO.memberList", map);
	}

	// 회원정보 갯수
	@Override
	public int countMember(String id) {
		return sqlSession.selectOne("memberDAO.countMember", id);
	}

	// 지점장 목록
	@Override
	public List<MemberDTO> infoList(int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("memberDAO.infoList", map);
	}

	// 지점장 갯수
	@Override
	public int countinfo(String id) {
		return sqlSession.selectOne("memberDAO.countinfo", id);
	}

	// 지점장승인
	@Override
	public List<MemberDTO> approveList(int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);

		return sqlSession.selectList("memberDAO.approveList", map);
	}

	// 지점장승인 갯수
	@Override
	public int countApprove(String id) {
		return sqlSession.selectOne("memberDAO.countApprove", id);
	}
	//회원전체 검색용
	@Override
	public List<MemberDTO> getAllMember(int start,int end,String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("memberDAO.getAllMember",map);
	}
	//회원전체검색 카운트 
	@Override
	public Integer getAllMemberCount(String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return  sqlSession.selectOne("memberDAO.getAllMemberCount",map);
	}
	//아이디에대한 포지션 가져오기
	@Override
	public MemberDTO getMemberPosition(String id) {
		return sqlSession.selectOne("memberDAO.getMemberPosition",id);
	}

	@Override
	public void refundofexpul(String id) {
		sqlSession.update("memberDAO.refundofexpul",id);
	}

	@Override
	public String findId(MemberDTO memcom) {
		return sqlSession.selectOne("memberDAO.findId",memcom);
	}

	@Override
	public String findpw(MemberDTO memcom) {
		return sqlSession.selectOne("memberDAO.findpw",memcom);
	}

	@Override
	public void changePW(MemberDTO memcom) {
		sqlSession.update("memberDAO.changePW",memcom);
	}
	@Override
	public void expulmember(String id) {
		sqlSession.update("memberDAO.expulmember",id);
	}
	@Override
	public String getPass(String id) {
		return sqlSession.selectOne("memberDAO.getPass",id);
	}
	@Override
	public void updateAdmin(MemberDTO memcom) {
		sqlSession.update("memberDAO.updateAdmin",memcom);
	}
	@Override
	public void upUserInfo(MemberDTO memcom) {
		sqlSession.update("memberDAO.upMyPageInfo",memcom);
	}
	@Override
	public boolean passCheck(String id, String pass) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}

