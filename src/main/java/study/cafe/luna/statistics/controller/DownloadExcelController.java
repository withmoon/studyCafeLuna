package study.cafe.luna.statistics.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import study.cafe.luna.Reserve.dto.ReserveDTO;
import study.cafe.luna.statistics.service.DownloadExcelService;
import study.cafe.luna.statistics.service.StatisticsService;
import study.cafe.luna.util.listExcelDownload;

@Controller
public class DownloadExcelController {
	@Autowired
	public DownloadExcelService downloadExcelService;

	//엑셀다운로드
	@RequestMapping(value = "/ExcelDownload.do")
	public View excelDownload(@RequestParam(defaultValue = "1") int curPage, HttpSession session, Model model)
			throws Exception {
		String date1 = (String) session.getAttribute("date1");
		String date2 = (String) session.getAttribute("date2");
		String branchName = (String) session.getAttribute("branchName");

		//카운트
		int count = downloadExcelService.count(date1, date2, branchName);
		System.out.println(count + "媛�");

		List<ReserveDTO> list = downloadExcelService.excelList(count, date1, date2, branchName);
		model.addAttribute("list", list);
		model.addAttribute("branchName", branchName);
		return new listExcelDownload();
	}

}
