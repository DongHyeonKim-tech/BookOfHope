package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.Notice.NoticeVO;

public class AdminNoticeDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] noticeNum = request.getParameterValues("noticeNum");
		
		if(noticeNum != null) {
			
		for (int idx = 0; noticeNum.length > idx; idx++) {
			request.setAttribute("noticeNum", noticeNum[idx]);

			NoticeVO nVO = new NoticeVO();

			nVO.setNoticeNum(noticeNum[idx]);
			
			NoticeDAO nDao = NoticeDAO.getInstance();
			nDao.noticeDelete(nVO);
			
		}
		}
		
		request.setAttribute("msg", "������ �Ϸ�Ǿ����ϴ�.");
		
		new AdminNoticeListFormAction().execute(request, response);
	}

}
