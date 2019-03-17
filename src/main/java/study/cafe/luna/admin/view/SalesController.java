package study.cafe.luna.admin.view;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.member.service.GetMemberPositionService;

@Controller
public class SalesController {
	
	@Autowired
	GetMemberPositionService getMemberPositionService;
	
	@RequestMapping(value = "/admin.do", method = RequestMethod.GET)
	public String mainView( HttpServletRequest request, HttpSession session,
			HttpServletResponse response,MemberDTO memcom) throws IOException {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) {
			String id=flashMap.get("id").toString();
			memcom.setId(id);
			memcom=getMemberPositionService.getMemberPosition(memcom.getId());
			if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
				session.setAttribute("member", memcom);
				return "/admin/admin";
			} else {
				return "/admin/cannotAccess";
			}
		} else if (session.getAttribute("member")!= null) {
			memcom = (MemberDTO) session.getAttribute("member");
			if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
				session.setAttribute("member", memcom);
				return "/admin/admin";
			} else {
				return "/admin/cannotAccess";
			}
		}
		return "/admin/cannotAccess";
	}

}