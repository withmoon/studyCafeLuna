package study.cafe.luna.member.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.member.dao.MemberDAO;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.GetMemberPositionService;
@Service
public class GetMemberPositionServiceImpl implements GetMemberPositionService {
	
	@Autowired
	MemberDAO memd;

	@Override
	public MemberDTO getMemberPosition(String id) {
		return memd.getMemberPosition(id);
	}

}
