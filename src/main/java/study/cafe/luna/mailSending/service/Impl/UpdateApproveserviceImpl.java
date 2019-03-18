package study.cafe.luna.mailSending.service.Impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import study.cafe.luna.mailSending.dao.AdminManagerApproveDAO;
import study.cafe.luna.mailSending.service.UpdateApproveservice;

@Service
public class UpdateApproveserviceImpl implements UpdateApproveservice {
	@Inject
	AdminManagerApproveDAO approveDAO;
	
	@Override
	public void approveupdate(String id){
		approveDAO.approveupdate(id);

	}
}
