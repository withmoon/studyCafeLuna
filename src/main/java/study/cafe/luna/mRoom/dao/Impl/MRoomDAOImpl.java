package study.cafe.luna.mRoom.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.cafe.luna.mRoom.dao.MRoomDAO;
import study.cafe.luna.mRoom.dto.MRoomDTO;

@Repository
public class MRoomDAOImpl implements MRoomDAO {
 
	@Autowired
	private SqlSession SqlSession;
  
	@Override //방 생성 테이블 읽어오기
	public List<MRoomDTO> mgRoomList(HttpSession session,int start,int end,MRoomDTO vo,String searchOption, String keyword) {
		System.out.println("roomList select");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", session.getAttribute("branchName"));
		//#start #end 에 입력될 값
		map.put("start",start);
		map.put("end", end);
		return SqlSession.selectList("mRoomDAO.RoomList",map);
	}
	
	@Override //방 리스트갯수 
	public int countArticle(String searchOption, String keyword, HttpSession session) {
		System.out.println("roomList select");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName",session.getAttribute("branchName"));
		return SqlSession.selectOne("mRoomDAO.countArticle",map);
	}
	@Override //방 최소번호 카운트
	public int roomcount() {  
		System.out.println("roomList roomcount");		
		return SqlSession.selectOne("mRoomDAO.roomcount");
	}
	@Override //방 주소 가져오기
	public String roomLocate(HttpSession session) {
		System.out.println("roomList roomLocate");	
		String branchName=(String) session.getAttribute("branchName");
		return SqlSession.selectOne("mRoomDAO.roomLocate",branchName);
	}
	
	@Override //룸 text db
	public int roomupload(MRoomDTO vo) {
		System.out.println("roomtext DB 수행");
		return SqlSession.insert("mRoomDAO.RoomText",vo);
	}
	@Override  //룸 file db
	public int uploadFile(HashMap<String, Object> hm) throws Exception {
		System.out.println("roomfile DB 수행");
		return SqlSession.insert("mRoomDAO.RoomFile",hm); 
	}
	//룸 상세보기 text
	@Override
	public MRoomDTO mgRoomRead(int roomnum) throws Exception {
		System.out.println("roomList text DAO");
		return SqlSession.selectOne("mRoomDAO.RoomSelect",roomnum);
	}
	//룸 상세보기 file
	@Override
	public List<MRoomDTO> mgRoomFile(int roomnum) {
		System.out.println("roomfile text DAO");
		return SqlSession.selectList("mRoomDAO.RoomFileSelect",roomnum);
	}
	
	//업데이트 수정하기
	@Override
	public void mgRoomTextupdate(MRoomDTO vo) {
		System.out.println("roomtext update DAO");
		SqlSession.update("mRoomDAO.RoomTextInsert",vo);
	}
	@Override //파일수정
	public void mgRoomFileupdate(HashMap<String, Object> hm) {
		System.out.println("roomfile update DAO");
		SqlSession.update("mRoomDAO.RoomFileInsert",hm);
	}
	
	//삭제하기
	@Override
	public void mgRoomDelete(int roomnum) {
		// TODO Auto-generated method stub
		System.out.println("room deleteDAO");
		SqlSession.delete("mRoomDAO.RoomDelete",roomnum);
	}
	@Override
	public void mgRoomFileDelete(int roomnum) {
		// TODO Auto-generated method stub
		System.out.println("roomfile delete DAO");
		SqlSession.delete("mRoomDAO.RoomFileDelete",roomnum);
	}

	

	


 
}
