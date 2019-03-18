package study.cafe.luna.payandreserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.payandreserve.service.PayAndReserveService;
import study.cafe.luna.room.dto.MyPageInfoDTO;

@Controller
public class CancleReserveController {
	
	@Autowired 
	PayAndReserveService parser;
	
	@RequestMapping(value="/cancleReserve.do", method=RequestMethod.POST)
	public @ResponseBody void cancleReserve(MyPageInfoDTO mpif,@RequestParam("imp_uid")String imp_uid){
		mpif.setImp_uid(imp_uid);
		parser.cancleReserve(mpif);
	}
}
