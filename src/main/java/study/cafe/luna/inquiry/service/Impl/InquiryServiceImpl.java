package study.cafe.luna.inquiry.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.Question.dto.QuestionBoardDTO;
import study.cafe.luna.inquiry.dao.InquiryDAO;
import study.cafe.luna.inquiry.service.InquiryService;

@Service
public class InquiryServiceImpl implements InquiryService{
	@Autowired
	InquiryDAO iqd;
	@Override
	public Integer getUserQnCount(String id) {
		return iqd.getUserQnCount(id);
	}
	@Override
	public List<QuestionBoardDTO> getUserQnAll(int start,int end,String id) {
		return iqd.getUserQnAll(start,end,id);
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
	//고객의 소리 insert
	@Override
	public void create(QuestionBoardDTO vo) {
		iqd.create(vo);
	}
	
}
