package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Meeting.MeetingVO;
import com.itbook.vo.Meeting.MetBoardVO;

public class ManageHomeAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "/meeting/manageHome.jsp";
		
		// metNum 가져오기
		String metNum = request.getParameter("metNum");
		System.out.println("metNum : " + metNum);

		MeetingDAO metDao = MeetingDAO.getInstance();
		
		MeetingVO meetingVo = metDao.selectOneMeetingByNum(metNum);
		List<MetBoardVO> metboardList = metDao.selectFiveMetBoard(metNum);

		
		request.setAttribute("meetingVo", meetingVo);
		request.setAttribute("metboardList", metboardList);
		// End metNum
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
