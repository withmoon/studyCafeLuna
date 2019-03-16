package study.cafe.luna.howtouse.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.howtouse.dao.HowToUseDAO;
import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.InsertHowToUseService;
@Service
public class InsertHowToUseServiceImpl implements InsertHowToUseService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public void insertHowToUse(HowToUseDTO htu) {
		htuDAO.insertHowToUse(htu);
	}
}
