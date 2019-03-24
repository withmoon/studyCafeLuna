package study.cafe.luna.user.view;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.GetMemberPositionService;
import study.cafe.luna.member.service.MemberService;
import study.cafe.luna.payandreserve.service.PayAndReserveService;
import study.cafe.luna.room.service.RoomService;
import study.cafe.luna.roomrank.dto.RoomRankDTO;
import study.cafe.luna.roomrank.service.RoomRankServicie;
import study.cafe.luna.util.SHA256;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memser;
	@Autowired
	RoomService roomser;
	@Autowired
	PayAndReserveService parser;
	@Autowired
	RoomRankServicie rrkser;
	@Autowired
	GetMemberPositionService getMemberPositionService;
	
	String filePath = "C:\\myProject\\MainProject\\studyCafeLuna\\src\\main\\webapp\\resources\\report\\";

	//카카오로그인
	@RequestMapping(value="kakao/home.do", method=RequestMethod.GET)
	public ModelAndView homeViewtget(RedirectAttributes rdab,MemberDTO memcom,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		memcom.setId(flashMap.get("id").toString());
		
		rdab.addFlashAttribute("id", memcom.getId());
		
		mav.setViewName("redirect:/home.do");
		return mav;
	}
	
	//회원가입 로그인
	@RequestMapping(value="/join/home.do", method=RequestMethod.POST)
	public ModelAndView homeloginView(MultipartHttpServletRequest mpreq,HttpServletResponse response,RedirectAttributes rdab,MemberDTO memcom,@RequestParam(value="kid",required=false,defaultValue="") String kid, @RequestParam(value="knic",required=false,defaultValue="") String knic) throws Exception {
		ModelAndView mav=new ModelAndView();
		int result =0;
		if(kid.equals("")) {
			result= memser.idCheck(memcom);
		}
		if (result == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			out.println("<script>alert('중복된 아이디 입니다. 아이디 입력후 중복체크를 해주세요'); history.go(-1);</script>");
			out.flush();
			return null;
		}
		
		if(!kid.equals("")) { //카카오 로그인시
			memcom.setKid(kid);
			memcom.setPw(knic);
		}
		//지점장 설정
		memcom.setBranchAddr2(memcom.getBranchAddr2()+"#"+memcom.getBranchAddr3());
		MultipartFile mf = mpreq.getFile("branchimgf");
		if (mf!=null) {
			System.out.println("파일 추출");
			// 저장되는 파일 이름
			String branchimg=mf.getOriginalFilename();
			String savePath = filePath + branchimg; // 저장 될 파일 경로
			memcom.setBranchoriginimg(savePath);
			mf.transferTo(new File(savePath)); // 파일 저장
			memcom.setBranchimg(branchimg);
		}
		
		//비번 암호화
		SHA256 sha=SHA256.getInsatnce();
		String shaPass=sha.getSha256(memcom.getPw().getBytes());
		memcom.setPw(shaPass);
		
		//회원가입
		memser.insertMember(memcom);
		
		String branchName=memcom.getBranchName();
		if(kid.equals("")) {
			rdab.addFlashAttribute("id", memcom.getId());
		}else {
			rdab.addFlashAttribute("id", memcom.getKid());
		}
		//회원은 회원으로 
		if(branchName==null) {
			mav.setViewName("redirect:/home.do");
			return mav;
		}else{ //지점장 회원가입시 alert띄우고 메인으로 돌아옴
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			out.println("<script>alert('지점장 등록이 완료되셨습니다. 승인이 완료되면 이메일로 알려드리겠습니다.'); window.location='/luna/main.do'; </script>");
			out.flush();
		}
		return null;
	}
	
	//홈
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public ModelAndView homeView(MemberDTO memcom,HttpServletRequest request,HttpSession session) throws Exception {
		ModelAndView mav=new ModelAndView();
		memcom=(MemberDTO)session.getAttribute("member");
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);	
		
		if(flashMap!=null) {
			String id=flashMap.get("id").toString();
			memcom=getMemberPositionService.getMemberPosition(id);
		}
		if(memcom!=null){
			memcom=getMemberPositionService.getMemberPosition(memcom.getId());
		}
		session.setAttribute("member", memcom);
		
		List<String> sido=roomser.getSido();
		Integer allBranchCount=memser.allBranchCount();
		Integer allMemberCount=memser.allMemberCount();
		Integer preYearReserveCount=parser.getPreYearReserveCount();
		Integer thisYearReserveCount=parser.getThisYearReserveCount();
		Integer preDayReserveCount=parser.getPreDayReserveCount();
		Integer preMonthReserveCount=parser.getPreMonthReserveCount();
		
		List<RoomRankDTO> reviewranklist=rrkser.getRoomReviewRank();
		List<RoomRankDTO> reserveranklist=rrkser.getRoomReserveRank();
		List<MemberDTO> newBranchList=rrkser.getNewBranch();
		List<RoomRankDTO> newReviewList=rrkser.getNewReview(); 
		
		mav.addObject("sido",sido);
		
		mav.addObject("allMemberCount",allMemberCount);
		mav.addObject("allBranchCount",allBranchCount);
		
		mav.addObject("preYearReserveCount",preYearReserveCount);
		mav.addObject("thisYearReserveCount",thisYearReserveCount);
		mav.addObject("preDayReserveCount",preDayReserveCount);
		mav.addObject("preMonthReserveCount",preMonthReserveCount);
		
		mav.addObject("reviewRankList",reviewranklist);
		mav.addObject("reserveRankList",reserveranklist);
		mav.addObject("newBranchList",newBranchList);
		mav.addObject("newReviewList",newReviewList);
		
		mav.addObject("member",memcom);

		mav.setViewName("/user/home");
		return mav;
	}
}