package study.cafe.luna.mailSending.dao;

import java.util.List;

import study.cafe.luna.mailSending.dto.AdminManagerApproveDTO;

public interface AdminManagerApproveDAO {
	public void approveupdate(String id);

	public void approvedelete(String id); 

	public List<String> AllMail(AdminManagerApproveDTO vo);
}
