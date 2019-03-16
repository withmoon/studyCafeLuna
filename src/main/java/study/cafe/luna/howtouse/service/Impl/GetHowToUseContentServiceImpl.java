package study.cafe.luna.howtouse.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.howtouse.dao.HowToUseDAO;
import study.cafe.luna.howtouse.dto.HowToUseDTO;
import study.cafe.luna.howtouse.service.GetHowToUseContentService;
@Service
public class GetHowToUseContentServiceImpl implements GetHowToUseContentService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public List<HowToUseDTO> getHowToUseContent(int num) {
		return htuDAO.getHowToUseContent(num);
	}

}
