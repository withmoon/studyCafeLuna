package study.cafe.luna.managerView;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerLoginCheckController {
	  // 매니저 인증 실패시
	  
	  @RequestMapping(value = "/loginX.do", method = RequestMethod.GET) 
	  public ModelAndView logincheck(HttpSession session) {
		  System.out.println("매니저 인증 실패 로그인화면으로 이동"); 
		  ModelAndView mv = new ModelAndView(); 
		  mv.addObject("session",session.getAttribute("id"));
		  mv.setViewName("/manager/body/loginX");
		  
		  return mv; 
	  }
	 
}
