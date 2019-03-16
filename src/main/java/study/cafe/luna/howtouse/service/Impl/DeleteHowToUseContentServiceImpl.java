package study.cafe.luna.howtouse.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.howtouse.dao.HowToUseDAO;
import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.DeleteHowToUseContentService;

@Service
public class DeleteHowToUseContentServiceImpl implements DeleteHowToUseContentService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public void deleteHowToUseContent(HowToUseDTO htu) {
		htuDAO.deleteHowToUseContent(htu);
	}

}
