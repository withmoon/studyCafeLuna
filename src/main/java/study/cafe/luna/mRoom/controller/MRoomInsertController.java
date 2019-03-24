package study.cafe.luna.mRoom.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.mRoom.dto.MRoomDTO;
import study.cafe.luna.mRoom.service.MRoomInsertService;
import study.cafe.luna.mRoom.service.MRoomService;

@Controller
public class MRoomInsertController {
	
	@Autowired
	public MRoomInsertService insertService;
	
	//저장할 파일폴더
	String filePath = "C:\\myProject\\MainProject\\studyCafeLuna\\src\\main\\webapp\\resources\\rooms\\";

	// 방생성 insert
	@RequestMapping(value = "/mRoomInsert.do", method = RequestMethod.POST)
	public ModelAndView mginsertRoom(HttpServletRequest req, MultipartHttpServletRequest mrequest,
			@ModelAttribute("room") MRoomDTO vo,HttpSession session) throws Exception, IllegalStateException {
		
		//지점장 아닐때 접근 불가
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("branchName") == null) {
			mv.setViewName("/manager/body/loginX");
			return mv;
		}

		System.out.println("룸 업로드 컨트롤러 시작");
		System.out.println("파일업로드 테스트");
		vo.setRoomnum(Integer.parseInt(req.getParameter("roomnum")));
		vo.setBranchName(req.getParameter("branchName"));
		vo.setRoomLocate(req.getParameter("roomLocate"));
		vo.setComeRoute(req.getParameter("comeRoute"));

		// textarea 줄내림 db 인식 처리
		if (vo.getRoomExplain() == null) {
			System.out.println("상세내용 없음");
		} else {
			String roomExplain = vo.getRoomExplain().replace("\r\n", "<br>");
			vo.setRoomExplain(roomExplain); 
		}
		if (vo.getRoomWarn() == null) {
			System.out.println("주의사항내용 없음");
		} else {
			String roomWarn = vo.getRoomWarn().replace("\r\n", "<br>");
			vo.setRoomWarn(roomWarn);
		}
		vo.setRoomPrice(Integer.parseInt(vo.getPrice()));
		insertService.mgRoomUpload(vo);

		session = req.getSession();
		vo.setId((String) session.getAttribute("id"));

		File dir = new File(filePath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		// 방file insert 하기
		List<MultipartFile> mf = mrequest.getFiles("input_img");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
			System.out.println("파일이 없음");
		} else {
			System.out.println("파일 추출");
			System.out.println(mf.size());
			for (int i = 0; i < mf.size(); i++) {
				vo.setFilenum(i + 1); // 파일넘버
				if (!mf.get(i).getOriginalFilename().equals("")) {
					System.out.println("포문" + i);
					// 파일 중복명 처리
					String genId = UUID.randomUUID().toString();
					// 본래 파일명
					String originalfileName = mf.get(i).getOriginalFilename();
					String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName); // Ȯ����
					// 저장되는 파일 이름
					String savePath = filePath + saveFileName; // 저장 될 파일 경로
					// long fileSize = mf.get(i).getSize(); // 파일 사이즈
					mf.get(i).transferTo(new File(savePath)); // 파일 저장

					System.out.println("오리지널이름" + originalfileName);
					System.out.println("파일사이즈 " + saveFileName);
					// System.out.println("콘텐트타입 " + fileSize);
					insertService.fileUpload(originalfileName, saveFileName, vo, savePath);
				} else {
					// 파일이없을때 공간확보만<jsp에서 읽어들일때 index=null 문제를 막기위한 임시예외처리>
					String originalfileName = "X", saveFileName = "X", savePath = "X";
					insertService.fileUpload(originalfileName, saveFileName, vo, savePath);
				}
			}
		}
		return new ModelAndView("redirect:/mRoom.do");
	}
}
