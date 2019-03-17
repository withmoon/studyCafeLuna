package study.cafe.luna.mRoom.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.mRoom.dto.MRoomDTO;
import study.cafe.luna.mRoom.service.MRoomDeleteService;
import study.cafe.luna.mRoom.service.MRoomService;

@Controller
public class MRoomDeleteController {
	@Autowired
	public MRoomDeleteService mRoomDeleteService;
	@Autowired
	public MRoomService mRoomService;
	
	//저장할 파일폴더
	String filePath = "C:\\myProject\\myMainProject\\NewLuna\\Luna\\src\\main\\webapp\\resources\\rooms\\";

	// 삭제하기
	@RequestMapping(value = "mRoomDelete.do")
	public ModelAndView roomupdateView(MRoomDTO vo, @RequestParam int roomnum) throws Exception {

		mRoomDeleteService.RoomDelete(roomnum);
		// 실제 파일 삭제작업 수행해야함
		List<MRoomDTO> list = new ArrayList<MRoomDTO>();
		list = mRoomService.RoomFile(roomnum);
		for (int i = 0; i < 5; i++) {
			// 파일 삭제
			File file = new File(filePath + list.get(i).getFname());
			if (file.exists() == true) {
				file.delete();
			}
		}
		mRoomDeleteService.filDelete(roomnum);// 파일 경로 삭제시 실제파일 삭제 서비스 구현해야함
		return new ModelAndView("redirect:/mRoom.do");
	}
}
