package study.cafe.luna.howtouse.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.howtouse.dao.HowToUseDAO;
import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.GetHowToUseListService;
@Service
public class GetHowToUseListServiceImpl implements GetHowToUseListService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public List<HowToUseDTO> getHowToUseList() {
		return htuDAO.getHowToUseList();
	}

}
