package study.cafe.luna.member.service;

import java.util.List;

import study.cafe.luna.member.dto.MemberCommand;

public interface GetAllMemberService {
	List<MemberCommand> getAllMember(int start,int end,String searchOption,String keyword);
}
