package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.dao.MetBoardDAO;
import com.itbook.dao.MetPostDAO;
import com.itbook.vo.Meeting.MeetingVO;
import com.itbook.vo.Meeting.MetBoardVO;
import com.itbook.vo.Meeting.MetPostVO;

/**
 * 독서모임게시판 게시글 수정 폼으로 이동하는 액션 클래스 
 * 
 * @author 김정민
 *
 */

public class MetBoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/meeting/metBoardUpdateForm.jsp";

		// 페이지 번호와 글 번호를 가져온다.
		String pageNum = request.getParameter("page");
		String metBrdNum = request.getParameter("metBrdNum");
		
		
		// metNum 가져오기
		String metNum = request.getParameter("metNum");
		System.out.println("metNum : " + metNum);

		MeetingDAO metDao = MeetingDAO.getInstance();
		
		MeetingVO meetingVo = metDao.selectOneMeetingByNum(metNum);
		List<MetBoardVO> metboardList = metDao.selectFiveMetBoard(metNum);

		
		request.setAttribute("meetingVo", meetingVo);
		request.setAttribute("metboardList", metboardList);
		// End metNum
		
		
		MetBoardDAO mDao = MetBoardDAO.getInstance();
		MetBoardVO metpost = mDao.selectOneMetBoardByNum(metBrdNum);

		request.setAttribute("metbrd", metpost);
		request.setAttribute("pageNum", pageNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
