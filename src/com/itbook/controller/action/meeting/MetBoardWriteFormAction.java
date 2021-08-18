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

/**
 * 독서모임게시판 게시글 등록폼으로 이동하는 액션 클래스 
 * 
 * @author 김정민
 *
 */

public class MetBoardWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "meeting/metBoardWriteForm.jsp";
		
		// metNum 가져오기
		String metNum = request.getParameter("metNum");

		MeetingDAO mDao = MeetingDAO.getInstance();
		
		MeetingVO meetingVo = mDao.selectOneMeetingByNum(metNum);
		List<MetBoardVO> metboardList = mDao.selectFiveMetBoard(metNum);

		
		request.setAttribute("meetingVo", meetingVo);
		request.setAttribute("metboardList", metboardList);
		// End metNum
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
