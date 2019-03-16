package study.cafe.luna.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.member.dto.MemberDTO;

public interface MemberService {
	// 아이디 중복확인
	Integer idCheck(MemberDTO memcom);

	// 회원가입
	void insertMember(MemberDTO memcom);

	// 비밀번호 체크
	boolean passCheck(String id, String pass) throws Exception;

	String getBrName(String id);

	int getStatus(MemberDTO memcom);

	// 마이페이지에서 정보 가져옴
	MemberDTO getMyPageInfo(MemberDTO memcom);

	// 마이페이지 정보 수정
	void upUserInfo(MemberDTO memcom);

	// 전체 지점수 가져오기
	Integer allBranchCount();

	// 전체 유저수
	Integer allMemberCount();

	// 회원제명
	public void expulmember(String id);

	// 회원 제명 취소
	void cancleExpulmember(String id);

	public List<String> branchList(String gugun); // 고객의 소리 지점선택

	public List<MemberDTO> memberList(int start, int end, HttpSession session); // 회원정보

	public int countMember(String id); // 회원정보 갯수

	public List<MemberDTO> infoList(int start, int end, HttpSession session); // 지점장목록

	public int countinfo(String id); // 지점장 갯수

	public List<MemberDTO> approveList(int start, int end, HttpSession session); // 지점장 승인 목록

	public int countApprove(String id); // 지점장승인갯수
	
	List<MemberDTO> getAdminList();//어드민 리스트
	
	void insertAdmin(MemberDTO memcom); //어드민 추가
	
	void updateAdmin(MemberDTO memcom);//어드민 수정
	
	void deleteAdmin(String id);//어드민 삭제
  
}
