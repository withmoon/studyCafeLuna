package study.cafe.luna.howtouse.dao;

import java.util.List;

import study.cafe.luna.howtouse.dto.HowToUseDTO;

public interface HowToUseDAO {
	//글쓰기
	void insertHowToUse(HowToUseDTO htu);
	//전체 리스트 받아오기
	List<HowToUseDTO> getHowToUseList();
	//num 최대 번호
	Integer getHowToUseMaxNum();
	//cnum 최대 번호
	Integer getHowToUseMaxCnum(int num);
	//글 받아오기
	List<HowToUseDTO> getHowToUseContent(int num);
	//중간 글 삭제
	void deleteHowToUseContent(HowToUseDTO htu);
	//제목으로 삭제
	void deleteHowToUse(int num);
	//업뎃
	void updateHowToUseContent(HowToUseDTO htu);
	//이미지 있떤거 가져오기
	String getDefaultImg(HowToUseDTO htu);
}
