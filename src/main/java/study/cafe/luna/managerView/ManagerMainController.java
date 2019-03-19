package study.cafe.luna.managerView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.manager.dao.ManagerDAO;
import study.cafe.luna.manager.service.ManagerService;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.room.dto.RoomReviewDTO;

@Controller
public class ManagerMainController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private ManagerDAO managerDAO;

	@RequestMapping(value = "/manager.do", method = RequestMethod.GET)
   public ModelAndView mainView(HttpServletRequest request, Map<String, ?> flashMap, HttpSession session,InquiryBoardDTO vo,MemberDTO memberDTO)
         throws Exception {
		ModelAndView mv = new ModelAndView();
		 String bn = ""; //지점 검색
	 	 System.out.println("로그인 아이디  받아오기");
	   	 System.out.println("test 세션아이디 :"+session.getAttribute("id"));
	   	 System.out.println("test 세션지점명 :"+session.getAttribute("branchName"));
	   	 System.out.println("test 맵 :"+flashMap.get("id"));
	   	 
	   	 
      if ((flashMap.get("id") == null || flashMap.get("id").equals("")) && session.getAttribute("id") == null) {
         System.out.println("카카오 로그인 실패");
         mv.addObject(session);
         mv.setViewName("redirect:/loginX.do");
         return  mv;

      }else if(session.getAttribute("id") != null && session.getAttribute("branchName")==null) {
         System.out.println("회원확인");
         mv.setViewName("redirect:/loginX.do");
         return mv;
      }else if(session.getAttribute("branchName")!= null && !(session.getAttribute("branchName")).equals("") ){    
         System.out.println("세션에서 매니저ID 확인");

         String id=(String) session.getAttribute("id");
         MemberDTO member= managerService.branchname(id); //지점 검색
         bn=member.getBranchName();
         
         session.setAttribute("branchName",bn);
         System.out.println("세션:" +session.getAttribute("branchName"));
      }else { 
         flashMap = RequestContextUtils.getInputFlashMap(request);
         System.out.println("카카오 로그인 ==>" + flashMap.get("id"));
         session.setAttribute("id", flashMap.get("id"));
          
         String id=(String) session.getAttribute("id");

         MemberDTO member= managerService.branchname(id); //지점 검색
         
         session.setAttribute("branchaddr1", member.getBranchAddr1());
         session.setAttribute("branchaddr2", member.getBranchAddr2());
         session.setAttribute("branchName",member.getBranchName());
         
      }
      
      Calendar calendar = Calendar.getInstance();    
      //이번달 구하기
      int year = calendar.get( Calendar.YEAR );
      int month  = calendar.get(calendar.MONTH) + 1;
      String days = year+"/"+month;
      System.out.println(days);
 
      //고객의소리 최신 5개 가져오기
      List<InquiryBoardDTO> list = managerDAO.board();
     
      List<RoomReviewDTO> review = managerDAO.review(); //최신댓글 가져오기 //리뷰
      int member = managerService.member(); //회원수 가져오기 
      int reroom = managerDAO.reroom();//환불수 가져오기
      int login= managerService.login(); //방문자 수 가져오기 (로그인만 - 로그인컨트롤러에서 처리할것들)
      int roomcount= managerService.roomcount(session,days);  //예약수
      int joincount =managerService.join();  //회원가입수
     
      Map<String, Object> map = new HashMap<>();
      map.put("login", login);
      map.put("room", roomcount);
      map.put("joincount", joincount);
      map.put("member", member);
      map.put("reroom", reroom);
      map.put("review",review); //화면작업해야함
      map.put("list", list);

      mv.addObject("map", map);
      mv.setViewName("/manager/manager");


      return mv;
   }

	
	

}