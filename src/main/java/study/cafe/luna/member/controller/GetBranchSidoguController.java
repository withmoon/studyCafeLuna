package study.cafe.luna.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.room.service.RoomService;

@Controller
public class GetBranchSidoguController {
	
	@Autowired
	RoomService roomser;

	@RequestMapping(value="/getSidoGugun.do")
	public @ResponseBody List<String> getSidoGugung(@RequestParam(value="undefined",defaultValue="서울")String sido){
		List<String> list=roomser.getGugun(sido);
		return list;
	}
}
