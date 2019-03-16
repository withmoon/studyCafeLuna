package study.cafe.luna.member.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.member.dao.MemberDAO;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.MemberService;
import study.cafe.luna.util.SHA256;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO memd;
	
	@Override
	public Integer idCheck(MemberDTO memcom) {		
		return memd.idCheck(memcom);
	}

	@Override
	public void insertMember(MemberDTO memcom) {
		memd.insertMember(memcom);
	}

	@Override
	public boolean passCheck(String id,String pass) throws Exception {
		String realpass=memd.getPass(id);
		
		SHA256 sha=SHA256.getInsatnce();
		String shaPass=sha.getSha256(pass.getBytes());
		
		boolean result=realpass.equals(shaPass)? true :false;
		
		return result;
	}

	@Override
	public String getBrName(String id) {
		return memd.getBrName(id);
	}

	@Override
	public int getStatus(MemberDTO memcom) {
		return memd.getStatus(memcom);
	}
	@Override
	public MemberDTO getMyPageInfo(MemberDTO memcom) {
		return memd.getMyPageInfo(memcom);
	}

	@Override
	public void upUserInfo(MemberDTO memcom) {
		memd.upUserInfo(memcom);
	}

	@Override
	public Integer allBranchCount() {
		return memd.allBranchCount();
	}
	@Override
	public Integer allMemberCount() {
		return memd.allMemberCount();
	}
	 
	//고객의 소리 지점 선택
	@Override
	public List<String> branchList(String gugun) {
		return memd.branchList(gugun);
	}

	//회원정보
	@Override
	public List<MemberDTO> memberList(int start, int end, HttpSession session) {
		return memd.memberList(start, end);
	}

	//회원정보 갯수
	@Override
	public int countMember(String id) {
		return memd.countMember(id);
	}

	//지점장 목록
	@Override
	public List<MemberDTO> infoList(int start, int end, HttpSession session) {
		return memd.infoList(start, end);
	}

	//지점장 갯수
	@Override
	public int countinfo(String id) {
		return memd.countinfo(id);
	}

	//지점장 승인
	@Override
	public List<MemberDTO> approveList(int start, int end, HttpSession session) {
		return memd.approveList(start, end);
	}

	//지점장 승인 갯수
	@Override
	public int countApprove(String id) {
		return memd.countApprove(id);
	}
	@Override
	public void expulmember(String id) {
		memd.expulmember(id);
	}
	@Override
	public void cancleExpulmember(String id) {
		memd.cancleExpulmember(id);
	}

	@Override
	public List<MemberDTO> getAdminList() {
		return memd.getAdminList();
	}

	@Override
	public void insertAdmin(MemberDTO memcom) {
		memd.insertAdmin(memcom);
	}

	@Override
	public void updateAdmin(MemberDTO memcom) {
		memd.updateAdmin(memcom);
	}

	@Override
	public void deleteAdmin(String id) {
		memd.deleteAdmin(id);
	} 


}
