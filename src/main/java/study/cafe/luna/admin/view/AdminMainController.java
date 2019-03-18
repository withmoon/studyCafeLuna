package com.study.luna.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainController {

	
	@RequestMapping("moveUserMode.ado")
	public String moveUserMode(){
		return "../public/mainpage";
	}
	@RequestMapping("moveAdminMode.ado")
	public String moveAdminMode() {
		return "../admin/admin";
	}
	
}
