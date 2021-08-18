package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.dao.MetBoardDAO;
import com.itbook.dao.MetPostDAO;
import com.itbook.vo.Meeting.MeetingVO;
import com.itbook.vo.Meeting.MetBoardVO;

/**
 * 독서모임게시판 게시글 삭제하는 액션 클래스 
 * 
 * @author 김정민
 *
 */

public class MetBoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String metBrdNum = request.getParameter("metBrdNum");

		MetBoardDAO mDao = MetBoardDAO.getInstance();
		mDao.deleteMetBoard(metBrdNum);
		
		// metNum 가져오기
				String metNum = request.getParameter("metNum");
				System.out.println("metNum : " + metNum);

				MeetingDAO metDao = MeetingDAO.getInstance();
				
				MeetingVO meetingVo = metDao.selectOneMeetingByNum(metNum);
				List<MetBoardVO> metboardList = metDao.selectFiveMetBoard(metNum);

				
				request.setAttribute("meetingVo", meetingVo);
				request.setAttribute("metboardList", metboardList);
				// End metNum
		
		new metBoardListFormAction().execute(request, response);
	}

}
