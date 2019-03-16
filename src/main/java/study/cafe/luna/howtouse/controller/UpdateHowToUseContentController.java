package study.cafe.luna.howtouse.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import study.cafe.luna.howtouse.dao.HowToUseDAO;
import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.InsertHowToUseService;
import study.cafe.luna.howtouse.service.UpdateHowToUseContentService;

@Controller
public class UpdateHowToUseContentController {
	@Autowired
	UpdateHowToUseContentService updateHowToUseContentService;
	@Autowired
	HowToUseDAO howToUseDAO;
	@Autowired
	InsertHowToUseService insertHowToUseService;
	
	private String filePath = "C:\\myProject\\myMainProject\\NewLuna\\Luna\\src\\main\\webapp\\resources\\howtouseImg\\";

	@RequestMapping(value = "/updateHowToUse.do", method = RequestMethod.POST)
	public String updateHowToUse(HowToUseDTO htu, MultipartHttpServletRequest mpreq, HttpServletRequest req)
			throws IllegalStateException, IOException {
		Integer formSize = Integer.parseInt(req.getParameter("maxCnum"));
		List<MultipartFile> mf = mpreq.getFiles("file");
		int num = htu.getNum();
		int maxCnum=howToUseDAO.getHowToUseMaxCnum(num)-1;
		htu.setTitle((String) req.getParameter("title"));
		for (int i = 0; i < formSize; i++) {
			String realPath = filePath + htu.getNum() + "\\" + i + "\\";
			File dir = new File(realPath);

			String filename = mf.get(i).getOriginalFilename();
			if(!filename.equals("")&&!filename.equals(null)) {
				if (dir.exists()) { // 파일존재여부확인
					File[] folder_list = dir.listFiles(); //파일리스트 얻어오기
					for(int j = 0 ; j < folder_list.length ; j++){
						File file = folder_list[j]; 
						if(file.isFile()){
							file.delete();
						}
					}
					dir.mkdirs();
				}else {
					System.out.println("디렉토리생성");
					dir.mkdirs();
				}
				
				String savePath = realPath + filename; // 저장 될 파일 경로
				mf.get(i).transferTo(new File(savePath)); // 파일 저장;
				htu.setFname(filename);
			}
			
			htu.setNum(num);
			htu.setCnum((i+1));
		
			htu.setFpath(realPath);
			htu.setContent(req.getParameter("content" + (i+1)).replace("\r\n", "<br>"));
			if(i<maxCnum) {
				updateHowToUseContentService.updateHowToUseContent(htu);
			}else {
				insertHowToUseService.insertHowToUse(htu);
			}
			htu.setFname("");
		}

		return "redirect:/howtouseboard.ado";
	}
}
