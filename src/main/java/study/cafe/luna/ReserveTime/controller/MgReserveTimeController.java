package study.cafe.luna.ReserveTime.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.ReserveTime.dto.ReserveTimeDTO;
import study.cafe.luna.ReserveTime.service.mgReserveTimeService;
import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.manager.dao.ManagerDAO;
import study.cafe.luna.payandreserve.service.PayAndReserveService;
import study.cafe.luna.payment.dto.RoomPaymentDTO;
import study.cafe.luna.room.dao.RoomReviewDAO;
import study.cafe.luna.room.dto.RoomReviewDTO;

@Controller
public class MgReserveTimeController {

	@Autowired
	mgReserveTimeService mgReserveTimeService;
	@Autowired
	PayAndReserveService prser;
	@Autowired
	ManagerDAO managerDAO;
	@Autowired
	RoomReviewDAO roomReviewDAO;

	@RequestMapping(value = "/Timechart.do")
	public ModelAndView mgAgeView(ReserveTimeDTO vo,
			@RequestParam(value = "paid_at_start", defaultValue = "") String paid_at_start,
			@RequestParam(value = "paid_at_end", defaultValue = "") String paid_at_end, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("branchName") == null) {
			mv.setViewName("/manager/body/loginX");
			return mv;
		}
		if (paid_at_start == null || paid_at_start.equals("")) {
			paid_at_start = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		if (paid_at_end == null || paid_at_end.equals("")) {
			paid_at_end = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}

		// 예약수 가져오기
		List<ReserveTimeDTO> list = mgReserveTimeService.mgAgeList(paid_at_start, paid_at_end);
		// 고객의소리 최신 5개 가져오기
		List<InquiryBoardDTO> qlist = managerDAO.board();
		List<RoomReviewDTO> roomreview = roomReviewDAO.getReview(session); // 리뷰가져오기
		map.put("qlist", qlist);
		map.put("roomreview", roomreview);
		// 통계계산
		mgReserveTimeService.mgsu(list, vo);

		mv.addObject("map", map);
		mv.addObject("vo", vo);
		mv.setViewName("/manager/body/reserveTime/mgTime");

		return mv;
	}

	@RequestMapping(value = "/mgTime2.do")
	@ResponseBody
	public ReserveTimeDTO mgAgeView2(ReserveTimeDTO vo,
			@RequestParam(value = "paid_at_start", defaultValue = "") String paid_at_start,
			@RequestParam(value = "paid_at_end", defaultValue = "") String paid_at_end,
			@RequestParam Map<String, Object> paramMap) {

		if (paid_at_start == null || paid_at_start.equals("")) {
			paid_at_start = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		if (paid_at_end == null || paid_at_end.equals("")) {
			paid_at_end = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}

		List<ReserveTimeDTO> list = mgReserveTimeService.mgAgeList(paid_at_start, paid_at_end);

		mgReserveTimeService.mgsu(list, vo);
		return vo;

	}

	@RequestMapping(value = "/mgchart2.do", method = RequestMethod.POST)
	public @ResponseBody List<ReserveTimeDTO> getTermSales2(
			@RequestParam(value = "paid_at_start", defaultValue = "") String paid_at_start,
			@RequestParam(value = "paid_at_end", defaultValue = "") String paid_at_end, ReserveTimeDTO vo,
			HttpSession session) {
		Calendar mon = Calendar.getInstance();
		mon.add(Calendar.MONTH, -1);
		// 한달전
		String beforeMonth = new java.text.SimpleDateFormat("yy/MM/dd").format(mon.getTime());

		if (paid_at_start == null || paid_at_start.equals("")) {
			paid_at_start = beforeMonth;
		}
		if (paid_at_end == null || paid_at_end.equals("")) {
			paid_at_end = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}

		// 李⑦듃 �뜲�씠�꽣
		String branchName = (String) session.getAttribute("branchName");
		// List<RoomPaymentDTO> termSaleslist = prser.getTermSales(paid_at_start,
		// paid_at_end);
		List<ReserveTimeDTO> list2 = mgReserveTimeService.getreservcount(paid_at_start, paid_at_end, branchName);
		// List<ReserveTimeDTO> list = mgReserveTimeService.getchart(paid_at_start,
		// paid_at_end);
		return list2;

	}

	@RequestMapping(value = "/mgchart.do", method = RequestMethod.POST)
	public @ResponseBody List<ReserveTimeDTO> getTermSales(@RequestParam(value = "paid_at_start") String paid_at_start,
			@RequestParam(value = "paid_at_end") String paid_at_end, ReserveTimeDTO vo, HttpSession session) {

		// 한달전
		Calendar mon = Calendar.getInstance();
		mon.add(Calendar.MONTH, -1);
		String beforeMonth = new java.text.SimpleDateFormat("yy/MM/dd").format(mon.getTime());

		if (paid_at_start == null || paid_at_start.equals("")) {
			paid_at_start = beforeMonth;
		}
		if (paid_at_end == null || paid_at_end.equals("")) {
			paid_at_end = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}

		String branchName = (String) session.getAttribute("branchName");
		List<RoomPaymentDTO> termSaleslist = prser.getTermSales(paid_at_start, paid_at_end);
		List<ReserveTimeDTO> list = mgReserveTimeService.getreservcount(paid_at_start, paid_at_end, branchName);
		return list;

	}

	@RequestMapping(value = "/report.do", method = RequestMethod.GET)
	public ModelAndView mgReportView(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		// 고객의소리 최신 5개 가져오기
		List<InquiryBoardDTO> qlist = managerDAO.board();
		List<RoomReviewDTO> roomreview = roomReviewDAO.getReview(session); // 리뷰가져오기
		map.put("qlist", qlist);
		map.put("roomreview", roomreview);
		mav.addObject("map", map);
		mav.setViewName("/manager/body/reserveTime/report");

		return mav;
	}

}
