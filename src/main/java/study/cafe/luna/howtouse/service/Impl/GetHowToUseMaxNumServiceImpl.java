package study.cafe.luna.howtouse.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.howtouse.dao.HowToUseDAO;
import study.cafe.luna.howtouse.service.GetHowToUseMaxNumService;

@Service
public class GetHowToUseMaxNumServiceImpl implements GetHowToUseMaxNumService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public Integer getHowToUseMaxNum() {
		return htuDAO.getHowToUseMaxNum();
	}

}
