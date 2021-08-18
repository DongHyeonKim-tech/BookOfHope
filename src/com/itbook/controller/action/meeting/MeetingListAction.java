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

public class MeetingListAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/meeting/meetingList.jsp";
		String memNum = request.getParameter("memNum");
		MeetingDAO mDao = MeetingDAO.getInstance();
		MemberDAO mlDao = MemberDAO.getInstance();
		List<MeetingVO> meetingList = mDao.selectAllMeetings();
		
		request.setAttribute("meetingList", meetingList);
		MemListVO memListVo = mlDao.selectMemNum(memNum);
		request.setAttribute("memListVo", memListVo);
		
		System.out.println(meetingList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
