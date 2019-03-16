package study.cafe.luna.manager.service.Impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.manager.dao.ManagerDAO;
import study.cafe.luna.manager.service.ManagerService;
  
@Service
public class ManagerServiceImpl implements ManagerService{
	

	@Autowired 
	private ManagerDAO managerDAO;

	// 로그인수 +1
	@Override
	public void logincount() {
		System.out.println("logincount+1 더하기"); 
		managerDAO.logincount();
	}
 
	// 로그인 수 가져오기
	@Override
	public int login() {
		System.out.println("logincount 가져오기");
		return managerDAO.login();
	}

	@Override
	public String branchname(String id) {
		System.out.println("branchname 가져오기");
		return managerDAO.branchname(id);
		
	}

	@Override
	public int roomcount(HttpSession session, String days) {
		System.out.println("roomcount 가져오기");
		return managerDAO.roomcount(session,days);
		
	}

	@Override
	public int join() {
		System.out.println("join 가져오기");
		return managerDAO.join();
	}

	@Override
	public int member() {
		System.out.println("member 가져오기");
		return managerDAO.member();
	}

	
}
