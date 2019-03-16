package study.cafe.luna.howtouse.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.howtouse.dao.HowToUseDAO;
import study.cafe.luna.howtouse.service.DeleteHowToUseService;
@Service
public class DeleteHowToUseServiceImpl implements DeleteHowToUseService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public void deleteHowToUse(int num) {
		htuDAO.deleteHowToUse(num);
	}

}
