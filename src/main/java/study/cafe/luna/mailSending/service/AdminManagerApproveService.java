package study.cafe.luna.mailSending.service;

import java.util.List;

import study.cafe.luna.mailSending.dto.AdminManagerApproveDTO;

public interface AdminManagerApproveService {
	public List<String> AllMail(AdminManagerApproveDTO vo);
}
