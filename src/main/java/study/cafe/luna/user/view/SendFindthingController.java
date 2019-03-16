package study.cafe.luna.user.view;

import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.cafe.luna.member.dao.MemberDAO;
import study.cafe.luna.member.dto.MemberDTO;
import study.cafe.luna.util.SHA256;

@Controller
public class SendFindthingController {
	@Autowired
	MemberDAO memDAO;

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/sendFindthing.do",method=RequestMethod.POST) 
	public @ResponseBody JSONObject sendFindthing(@RequestParam(value="name",required=false,defaultValue="")String name,
			@RequestParam(value="email",required=false,defaultValue="")String email,
			@RequestParam(value="id",required=false,defaultValue="")String id,MemberDTO memcom) throws Exception {
		memcom.setName(name);
		memcom.setEmail(email);
		memcom.setId(id);
		JSONObject obj = new JSONObject();
		String setfrom = "kmh214900@gmail.com";// 보낼 관리자 gmail 계정
		String tomail = memcom.getEmail();
		String title ="";
		String content ="";
		if(memcom.getId().equals("")) {
			if(memDAO.findId(memcom).equals("")||memDAO.findId(memcom).equals(null)) {
				obj.put("fail", "true");
				return obj;
			}else{
				title = "[스터디카페 달빛] 아이디가 도착하였습니다.  이용에 감사드립니다.";
				content ="고객님의 아이디는 [ "+ memDAO.findId(memcom)+" ] 입니다.";
			}
		}else {
			if(memDAO.findpw(memcom).equals("")||memDAO.findpw(memcom).equals(null)) {
				obj.put("fail", "true");
				return obj;
			}else{
				title = "[스터디카페 달빛] 비밀번호가 도착하였습니다. ";
				
				int i1= (int) (Math.random() * 10);
				int i2= (int) (Math.random() * 10);
				int i3= (int) (Math.random() * 10);
				int i4= (int) (Math.random() * 10);
				int i5= (int) (Math.random() * 10);
				int i6= (int) (Math.random() * 10);
				String rePw=i1+""+i2+""+i3+""+i4+""+i5+""+i6;
				content ="고객님의 비밀번호 [ "+ rePw+" ] 입니다. 수정을 원하신다면 마이페이지의 [정보수정] 버튼을 통해 수정해주세요^^ 이용에 감사드립니다.";
				//비번 암호화
				SHA256 sha=SHA256.getInsatnce();
				String shaPass=sha.getSha256(rePw.getBytes());
				memcom.setPw(shaPass);
				memDAO.changePW(memcom);
			}
		}
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 안된다
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용
			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		obj.put("success", "success");
		return obj;
	}

}
