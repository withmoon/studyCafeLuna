package study.cafe.luna.mailSending.service.Impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import study.cafe.luna.mailSending.dao.AdminManagerApproveDAO;
import study.cafe.luna.mailSending.service.DeleteApproveservice;

@Service
public class DeleteApproveserviceImpl implements DeleteApproveservice{
	@Inject
	AdminManagerApproveDAO approveDAO;
	
	@Override
	public void approvedelete(String id){
		approveDAO.approvedelete(id);
		
	}
}
