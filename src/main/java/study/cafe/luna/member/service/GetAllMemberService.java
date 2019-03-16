package study.cafe.luna.member.service;

import java.util.List;

import study.cafe.luna.member.dto.MemberDTO;

public interface GetAllMemberService {
	List<MemberDTO> getAllMember(int start,int end,String searchOption,String keyword);
}
