package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.ArrayList;
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
import com.itbook.vo.Meeting.MetBoardVO;

public class MeetingHomeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/meeting/meetingHome.jsp";

		String metNum = request.getParameter("metNum");
		String memNum = request.getParameter("memNum");
		
		System.out.println(metNum);
		System.out.println(memNum);

		MeetingDAO mDao = MeetingDAO.getInstance();
//		MemberDAO mlDao = MemberDAO.getInstance();

		// 독서모임에 대한 객체
		MeetingVO meetingVo = mDao.selectOneMeetingByNum(metNum);
		// 등록된 게시글 5개 선택
		List<MetBoardVO> metboardList = mDao.selectFiveMetBoard(metNum);
		
		// 멤버가 독서모임 회원인지 확인 후 객체 선택
		MemListVO memListVo = mDao.checkMeetingMember(memNum, metNum);

		// mem_list 의 모든 정보를 선택
		// ArrayList<MemListVO> memList = mlDao.meetingMemList(metNum);

		System.out.println(meetingVo);

		request.setAttribute("memNum", memNum);
		request.setAttribute("memListVo", memListVo);
		// request.setAttribute("memList", memList);
		request.setAttribute("meetingVo", meetingVo);
		request.setAttribute("metboardList", metboardList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
