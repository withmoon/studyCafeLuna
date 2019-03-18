package study.cafe.luna.managerView;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import study.cafe.luna.member.dto.MemberDTO;

@Controller
public class EventViewController {

	@RequestMapping(value = "/Event.do")
	public String eventView(MemberDTO memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		} else {
			memcom = (MemberDTO) session.getAttribute("member");
		}
		return "/manager/body/board/mgEvent";
	}

}
