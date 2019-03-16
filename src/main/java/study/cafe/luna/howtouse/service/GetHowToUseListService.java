package study.cafe.luna.howtouse.service;

import java.util.List;

import study.cafe.luna.howtouse.dto.HowToUseDTO;

public interface GetHowToUseListService {
	//전체 리스트 받아오기
	List<HowToUseDTO> getHowToUseList();
}
