package study.cafe.luna.inquiry.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.inquiry.dao.InquiryDAO;
import study.cafe.luna.inquiry.dto.InquiryBoardDTO;
import study.cafe.luna.inquiry.service.InquiryService;

@Service
public class InquiryServiceImpl implements InquiryService {
	@Autowired
	InquiryDAO iqd;

	@Override
	public Integer getUserQnCount(String id) {
		return iqd.getUserQnCount(id);
	}

	@Override
	public List<InquiryBoardDTO> getUserQnAll(int start, int end, String id) {
		return iqd.getUserQnAll(start, end, id);
	}

	@Override
	public void deleteUserQna(int seq) {
		iqd.deleteUserQna(seq);

	}

	@Override
	public void upUserQnaContent(int seq, String content) {
		iqd.upUserQnaContent(seq, content);

	}

	@Override
	public void upUserQnaReadst(int seq) {
		iqd.upUserQnaReadst(seq);
	}

	// 고객의 소리 insert
	@Override
	public void create(InquiryBoardDTO vo) {
		iqd.create(vo);
	}

	@Override
	public List<InquiryBoardDTO> QuestionList(int start, int end, String searchOption, String keyword,
			String branchName) {
		return iqd.QuestionList(start, end, searchOption, keyword, branchName);
	}

	// 레코드계산
	@Override
	public int countArticle(String searchOption, String keyword, String branchName) throws Exception {
		return iqd.countArticle(searchOption, keyword, branchName);
	}

	// admin 문의목록
	@Override
	public List<InquiryBoardDTO> inquireList(int start, int end, String searchOption, String keyword) {
		return iqd.inquireList(start, end, searchOption, keyword);
	}

	@Override
	public int countInqure(String searchOption, String keyword) {
		return iqd.countInqure(searchOption, keyword);
	}
	@Override
	public InquiryBoardDTO QbaordRead(InquiryBoardDTO vo) throws Exception {
		return iqd.QbaordRead(vo);
	}
	
	@Override
	public InquiryBoardDTO inquireread(Integer seq) throws Exception {
		return iqd.inquireread(seq);
	}

	@Override
	public void inquiredelete(Integer seq) throws Exception {
		iqd.inquiredelete(seq);
		
	}	
	@Override
	public int mailstatus(InquiryBoardDTO vo) {
		return iqd.mailstatus(vo);
	}
}
