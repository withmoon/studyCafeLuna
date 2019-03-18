package study.cafe.luna.mailSending.service.Impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import study.cafe.luna.mailSending.dao.AdminManagerApproveDAO;
import study.cafe.luna.mailSending.dto.AdminManagerApproveDTO;
import study.cafe.luna.mailSending.service.AdminManagerApproveService;

@Service
public class AdminManagerApproveServiceImpl implements AdminManagerApproveService{

	@Inject
	AdminManagerApproveDAO approveDAO;

	@Override
	public List<String> AllMail(AdminManagerApproveDTO vo) {
		return approveDAO.AllMail(vo);
	}

	
}
