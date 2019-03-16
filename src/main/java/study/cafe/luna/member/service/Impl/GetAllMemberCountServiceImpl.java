package study.cafe.luna.member.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.member.dao.MemberDAO;
import study.cafe.luna.member.service.GetAllMemberCountService;
@Service
public class GetAllMemberCountServiceImpl implements GetAllMemberCountService {
	@Autowired
	MemberDAO memd;
	
	@Override
	public Integer getAllMemberCount(String searchOption, String keyword) {
		return memd.getAllMemberCount(searchOption, keyword);
	}

}
