package study.cafe.luna.admin.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.cafe.luna.notice.dto.NoticeBoardDTO;
import study.cafe.luna.notice.service.UpdateNoticeBoardService;

@Controller
public class UpdateGongiListController {
	
	@Autowired
	UpdateNoticeBoardService updateNoticeBoardService;
	
	// 공지사항 수정
	@RequestMapping(value = "/gongjiupdate.do", method = RequestMethod.POST)
	public String View(@ModelAttribute NoticeBoardDTO vo) throws Exception {
		updateNoticeBoardService.noticeupdate(vo);
		return "redirect:/gongji.do";
	}
}
