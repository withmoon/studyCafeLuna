package study.cafe.luna.payandreserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.payandreserve.service.PayAndReserveService;
import study.cafe.luna.payment.dto.RoomPaymentDTO;

@Controller
public class GetTermSalesController {

	@Autowired
	PayAndReserveService prser;

	@RequestMapping(value = "/getTermSales.do", method = RequestMethod.GET)
	public @ResponseBody List<RoomPaymentDTO> getTermSales(
			@RequestParam(value = "paid_at_start", defaultValue = "") String paid_at_start,
			@RequestParam(value = "paid_at_end", defaultValue = "") String paid_at_end) {
		List<RoomPaymentDTO> termSaleslist = prser.getTermSales(paid_at_start, paid_at_end);

		return termSaleslist;
	}

	@RequestMapping(value="/setBaseLine.do",method=RequestMethod.POST)
	public @ResponseBody void setBaseLine(RoomPaymentDTO dto,@RequestParam("baseline")String baseline) {
		dto.setBaseline(baseline);
		prser.setBaseLine(dto);
	}

}
