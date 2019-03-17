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
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/room/roomupdate");
		mv.addObject("text",vo);
		mv.addObject("file", list);
		return mv;
		
	}
//
//	// 수정하기
//	@RequestMapping(value = "updateRoom.mdo")
//	public ModelAndView updateRoom(HttpServletRequest req, @RequestParam int roomnum,
//			MultipartHttpServletRequest mrequest, @ModelAttribute("vo") RoomDTO vo)
//			throws Exception, IllegalStateException {
//		System.out.println("룸 업데이트 컨트롤러 시작");
//		vo.setRoomnum(Integer.parseInt(req.getParameter("text1")));
//		vo.setBranchName(req.getParameter("text2"));
//		vo.setRoomName(req.getParameter("roomName"));
//		vo.setRoomPrice(Integer.parseInt( req.getParameter("roomPrice")));
//		vo.setRoomLocate(req.getParameter("roomLocate"));
//		vo.setRoomEx1(req.getParameter("text6"));
//		vo.setRoomEx2(req.getParameter("text7"));
//		vo.setRoomEx3(req.getParameter("text8"));
//		vo.setRoomEx4(req.getParameter("text9"));
//		vo.setRoomExplain(req.getParameter("area1"));
//		vo.setRoomWarn(req.getParameter("area2"));
//		
//		// textarea 줄내림 db인식 처리
//		if (vo.getRoomExplain() == null) {
//			System.out.println("상세내용 없음");
//		} else {
//			String roomExplain = vo.getRoomExplain().replace("\r\n", "<br>");
//			vo.setRoomExplain(roomExplain);
//		}
//		if (vo.getRoomWarn() == null) {
//			System.out.println("주의사항내용 없음");
//		} else {
//			String roomWarn = vo.getRoomWarn().replace("\r\n", "<br>");
//			vo.setRoomWarn(roomWarn);
//		}
//		vo.setRoomnum(roomnum); 
//		mgRoomService.mgRoomUpdate(vo);
//
//		HttpSession session = req.getSession();
//		vo.setId((String) session.getAttribute("id"));
//		File dir = new File(filePath);
//		if (!dir.isDirectory()) {
//			dir.mkdirs();
//		}
//		// 수정할시 기존 파일 삭제작업 수행해야함
//		List<uploadfileVO> list = new ArrayList<uploadfileVO>();
//		list = mgRoomService.RoomFile(roomnum);
//		// 넘어온 파일을 리스트로 저장
//		List<MultipartFile> mf = mrequest.getFiles("input_img");
//		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
//			System.out.println("������ ����");
//		} else {
//			System.out.println("���� ����");
//			System.out.println(mf.size());
//			for (int i = 0; i < mf.size(); i++) {
//				vo.setFilenum(i + 1);// 저장할 파일넘버
//				if (!mf.get(i).getOriginalFilename().equals("")) {
//					System.out.println("포문" + i);
//					System.out.println("수정할 기존 파일 삭제작업수행");
//
//					//파일 삭제
//					File file = new File(filePath + list.get(i).getFname());
//					if (file.exists() == true) {
//						file.delete();
//					}
//					
//					// 파일 중복명 처리
//					String genId = UUID.randomUUID().toString();
//					// 본래 파일명
//					String originalfileName = mf.get(i).getOriginalFilename();
//					String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName); // Ȯ����
//					// 저장되는 파일 이름
//					String savePath = filePath + saveFileName; // 저장 될 파일 경로
//					// long fileSize = mf.get(i).getSize(); // 파일 사이즈
//					mf.get(i).transferTo(new File(savePath)); // 파일 저장
//
//					System.out.println("오리지널이름 " + originalfileName);
//					System.out.println("파일사이즈 " + saveFileName);
//					// System.out.println("콘텐츠타입 " + fileSize);
//					mgRoomService.fileUpdate(originalfileName, saveFileName, vo, savePath);
//				}
//			}
//		}
//
//		return new ModelAndView("redirect:mgRoom.mdo");
//	}
//

}
