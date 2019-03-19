package study.cafe.luna.mRoom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.mRoom.dao.MRoomDAO;
import study.cafe.luna.mRoom.dto.MRoomDTO;
import study.cafe.luna.mRoom.service.MRoomService;

@Controller
public class MRoomController {
	
	@Autowired
	public MRoomService mRoomService; 
	@Autowired
	public MRoomDAO MRoomDAO;
		

//	//방 상세보기
	@RequestMapping(value="mRoomView.do")
	public ModelAndView roomupdateView(@RequestParam int roomnum ,HttpSession session,@ModelAttribute(value="vo") MRoomDTO vo,@ModelAttribute(value="file") MRoomDTO file) throws Exception {
	    vo=	(MRoomDTO) mRoomService.RoomRead(roomnum); //�󼼺��� �� �� ����Ȯ��
	    
	  //지점장 아닐때 접근 불가
	  ModelAndView mv = new ModelAndView();
	  if (session.getAttribute("branchName") == null) {
	  		mv.setViewName("/manager/body/loginX");
	  		return mv;
	 }
	    
	  //줄내림 처리
	    System.out.println(vo.getRoomExplain());
	    System.out.println(vo.getRoomWarn());
	    if(vo.getRoomExplain()==null){
	    	System.out.println("상세내용 없음");
	    }else {
		String roomExplain = vo.getRoomExplain().replace( "<br>","\r\n");
		vo.setRoomExplain(roomExplain); 
	    }
	    if(vo.getRoomWarn()==null) {
	    	System.out.println("주의사항내용 없음");
	    }else {
		String roomWarn = vo.getRoomWarn().replace( "<br>","\r\n");
		vo.setRoomWarn(roomWarn);
	    } 
		List<MRoomDTO> list = new ArrayList<MRoomDTO>(/*Collections.nCopies(5 , file)*/);
		list= mRoomService.RoomFile(roomnum); 

		//화면이동 - text + file 
		mv.setViewName("/manager/body/room/roomupdate");
		mv.addObject("text",vo); 
		mv.addObject("file", list);
		return mv;
		
	}

}
