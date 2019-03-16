package study.cafe.luna.howtouse.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.howtouse.dao.HowToUseDAO;
import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.UpdateHowToUseContentService;
@Service
public class UpdateHowToUseContentServiceImpl implements UpdateHowToUseContentService {
	
	@Autowired
	HowToUseDAO howToUseDAO;

	@Override
	public void updateHowToUseContent(HowToUseDTO htu) {
		howToUseDAO.updateHowToUseContent(htu);
	}

}
