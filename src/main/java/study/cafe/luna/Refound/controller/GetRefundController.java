package study.cafe.luna.Refound.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import study.cafe.luna.Refound.dto.RefundDTO;
import study.cafe.luna.Refound.service.RefundService;
import study.cafe.luna.util.BoardPager;

@Controller
public class GetRefundController {
	//�쁽�솴

	@Autowired
	private RefundService refundService;

	//환불리스트
	@RequestMapping(value = "/Refund.do")
	public ModelAndView Reserve(@RequestParam(defaultValue = "id") String searchOption,HttpServletRequest request,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 System.out.println("移댁뭅�삤 濡쒓렇�씤 �떎�뙣");
			 mv.setViewName("loginX.mdo");
	         return mv;
		}

		if(request.getParameter("id")!=null) {
			keyword = request.getParameter("id");
		}
		
	String branchName = (String)session.getAttribute("branchName");
	int count = refundService.RefundCount(searchOption, keyword,branchName);
	
	int page_scale = 20;
	int block_sclae = 4;
	// �럹�씠吏� �굹�늻湲곗쿂由�  
	BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
	int start = boardPager.getPageBegin();
	int end = boardPager.getPageEnd();
	Date nowdate = new Date();
	System.out.println(nowdate);
	
	List<RefundDTO> list = refundService.mgRefund(start, end, searchOption, keyword,branchName);

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("list", list);
	map.put("count", count);
	map.put("searchOption", searchOption);
	map.put("keyword", keyword);
	map.put("boardPager", boardPager);
	map.put("nowdate",nowdate);
	 
	mv.addObject("map", map);
	//MgPCService.mgReserve(vo);
	mv.setViewName("/manager/body/presentCondition/mgRefund");

	return mv;
	}
	
	@RequestMapping(value="fund.do")   
	@ResponseBody
	public String Refund(int seq,int roomnum,String reservdate) throws InterruptedException {
		
		//�솚遺덉“移�
		refundService.Refund(seq,roomnum,reservdate);
	
		return "success";
	}

	
}
