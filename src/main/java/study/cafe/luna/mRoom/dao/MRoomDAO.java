package study.cafe.luna.mRoom.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import study.cafe.luna.mRoom.dto.MRoomDTO;

public interface MRoomDAO {

	//리스트 테이블가져오기 
	public List<MRoomDTO> mgRoomList(HttpSession session,int start, int end, MRoomDTO vo,String searchOption, String keyword);
	//리스트 카운트
	public int countArticle(String searchOption, String keyword, HttpSession session);
	//방 카운트
	public int roomcount();
	//방주소
	public String roomLocate(HttpSession session);
	 
	//insert
	public int uploadFile(HashMap<String, Object> hm)throws Exception;
	public int roomupload(MRoomDTO vo)throws Exception;
 
	//상세보기
	public MRoomDTO mgRoomRead(int roomnum)throws Exception;
	public List<MRoomDTO> mgRoomFile(int roomnum);

	//update
	public void mgRoomTextupdate(MRoomDTO vo);
	public void mgRoomFileupdate(HashMap<String, Object> hm);

	//delete
	public void mgRoomDelete(int roomnum);
	public void mgRoomFileDelete(int roomnum);
	
	

	

}
