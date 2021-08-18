package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Meeting.MeetingVO;

public class AdminMeetingRefuseAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] metNum = request.getParameterValues("metNum");
		if(metNum != null) {
			
		for (int idx = 0; metNum.length > idx; idx++) {
			request.setAttribute("metNum", metNum[idx]);

			System.out.println("metNum : " + metNum[idx]);

			MeetingVO mVO = new MeetingVO();

			mVO.setMetNum(metNum[idx]);
			
			MeetingDAO mDao = MeetingDAO.getInstance();
			mDao.deleteMeeting(mVO);
			
		}
		}
		new AdminMeetingAcceptListAction().execute(request, response);
		
	}

}
