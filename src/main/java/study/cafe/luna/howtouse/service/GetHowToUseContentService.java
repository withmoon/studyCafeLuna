package study.cafe.luna.howtouse.service;

import java.util.List;

import study.cafe.luna.howtouse.dto.HowToUseDTO;

public interface GetHowToUseContentService {
	List<HowToUseDTO> getHowToUseContent(int num);
}
