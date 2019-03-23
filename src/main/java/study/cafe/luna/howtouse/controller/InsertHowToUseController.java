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

import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.GetHowToUseMaxNumService;
import study.cafe.luna.howtouse.service.InsertHowToUseService;

@Controller
public class InsertHowToUseController {

	@Autowired
	GetHowToUseMaxNumService getHowToUseMaxNumService;
	@Autowired
	InsertHowToUseService insertHowToUseService;

	private String filePath = "C:\\Users\\진혁\\git\\studyCafeLuna\\src\\main\\webapp\\resources\\rooms\\";

	@RequestMapping(value = "/insertHowToUse.do", method = RequestMethod.POST)
	public String mainss(HowToUseDTO htu, MultipartHttpServletRequest mpreq, HttpServletRequest req)
			throws IllegalStateException, IOException {

		Integer seq = getHowToUseMaxNumService.getHowToUseMaxNum();
		Integer formSize = Integer.parseInt(req.getParameter("maxCnum"));
		List<MultipartFile> mf = mpreq.getFiles("file");
		// 저장되는 파일 이름
		for (int i = 0; i < formSize + 1; i++) {
			String realPath = filePath + seq + "\\" + i + "\\";
			File dir = new File(realPath);
			if (dir.exists()) { // 파일존재여부확인
				if (dir.isDirectory()) { // 파일이 디렉토리인지 확인
					File[] files = dir.listFiles();
					for(int j=0; j<files.length; j++) {
						files[j].delete();
					}
				}
				dir.mkdirs();
			} else {
				if (!dir.isDirectory()) {
					dir.mkdirs();
				}
			}

			String filename = mf.get(i).getOriginalFilename();
			String savePath = realPath + filename; // 저장 될 파일 경로
			mf.get(i).transferTo(new File(savePath)); // 파일 저장
			htu.setNum(seq);
			htu.setFname(filename);
			htu.setFpath(realPath);
			htu.setTitle((String) req.getParameter("title"));
			String content = (String) req.getParameter("content" + i).replace("\r\n", "<br>");
			htu.setContent(content);
			insertHowToUseService.insertHowToUse(htu);
		}

		return "redirect:/howtouseboard.do";
	}
}