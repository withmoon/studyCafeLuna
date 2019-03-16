package study.cafe.luna.member.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.member.dao.MemberDAO;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.GetAllMemberService;
@Service
public class GetAllMemberServiceImpl implements GetAllMemberService {
	
	@Autowired
	MemberDAO memd;

	@Override
	public List<MemberDTO> getAllMember(int start,int end,String searchOption, String keyword) {
		return memd.getAllMember(start,end,searchOption, keyword);
	}

}
