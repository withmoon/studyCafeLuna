package study.cafe.luna.user.view;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
//	@Autowired
//	private managerService managerService;

	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String mainView(HttpSession session,HttpServletRequest req) throws URISyntaxException{
		String param=req.getHeader("REFERER");
		String redirectUrl="";
		if(param==null) {
			redirectUrl="/home.udo";
		}else {
			String url=new URI(req.getHeader("referer")).getPath().substring(5);
			int paramStr=param.lastIndexOf("?")+1;
			redirectUrl=paramStr==0?url:url+param.substring(param.lastIndexOf("?"));
		}
		System.out.println("안냥 유알엘"+redirectUrl);
		
		session.setAttribute("rdUrl", redirectUrl);
//		managerService.logincount();
		return "/public/login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String mainViews(HttpSession session,HttpServletRequest req) throws URISyntaxException{
		String param=req.getHeader("REFERER");
		String redirectUrl="";
		if(param==null) {
			redirectUrl="/home.udo";
		}else {
			String url=new URI(req.getHeader("referer")).getPath().substring(5);
			int paramStr=param.lastIndexOf("?")+1;
			redirectUrl=paramStr==0?url:url+param.substring(param.lastIndexOf("?"));
		}
		System.out.println("안냥 유알엘"+redirectUrl);
		
		session.setAttribute("rdUrl", redirectUrl);
//		managerService.logincount();
		return "/public/login";
	}
}