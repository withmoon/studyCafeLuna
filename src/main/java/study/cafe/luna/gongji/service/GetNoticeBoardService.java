package study.cafe.luna.gongji.service;

import study.cafe.luna.gongji.dto.AdminGongjiBoardDTO;

public interface GetNoticeBoardService {
	public AdminGongjiBoardDTO noticeread(int num)throws Exception;
}
