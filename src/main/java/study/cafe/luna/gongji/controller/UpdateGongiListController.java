package study.cafe.luna.gongji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.cafe.luna.gongji.dto.AdminNoticeBoardDTO;
import study.cafe.luna.gongji.service.UpdateNoticeBoardService;

@Controller
public class UpdateGongiListController {
	
	@Autowired
	UpdateNoticeBoardService updateNoticeBoardService;
	
	// 공지사항 수정
	@RequestMapping(value = "/gongjiupdate.ado", method = RequestMethod.POST)
	public String View(@ModelAttribute AdminNoticeBoardDTO vo) throws Exception {
		updateNoticeBoardService.noticeupdate(vo);
		return "redirect:/gongji.ado";
	}
}
