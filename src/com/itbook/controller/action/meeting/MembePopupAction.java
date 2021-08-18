package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemListVO;
import com.itbook.vo.Meeting.MeetingVO;

public class MembePopupAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/meeting/memberPopup.jsp";
		
		String metNum = request.getParameter("metNum"); 
		
		MeetingDAO mDao = MeetingDAO.getInstance();
		MemberDAO mlDao = MemberDAO.getInstance();
		
		MeetingVO meetingVo = mDao.selectOneMeetingByNum(metNum);
		List<MemListVO> memList = mlDao.meetingMemberList(metNum);

		
		request.setAttribute("meetingVo", meetingVo);
		request.setAttribute("memList", memList);
		
		
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}

}
