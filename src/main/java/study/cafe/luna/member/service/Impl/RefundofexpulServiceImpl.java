package study.cafe.luna.member.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.member.dao.MemberDAO;
import study.cafe.luna.member.service.RefundofexpulService;
@Service
public class RefundofexpulServiceImpl implements RefundofexpulService {
	
	@Autowired
	MemberDAO memDAO;

	@Override
	public void refundofexpul(String id) {
		memDAO.refundofexpul(id);
	}

}
