package com.itbook.controller.action.admin; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.MemListVO;
import com.itbook.vo.Meeting.MeetingVO;

public class AdminMeetingUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] metNum = request.getParameterValues("metNum");
		String memNum = request.getParameter("memNum");
		request.setAttribute("memNum", memNum);
		String memName = request.getParameter("memName");
		request.setAttribute("memName", memName);
		String memId = request.getParameter("memId");
		request.setAttribute("memId", memId);
		if(metNum != null) {
			for(int i = 0; i < metNum.length; i++) {
				request.setAttribute("metNum", metNum);
				System.out.println("metNum : " + metNum);
				
				MeetingVO mVO = new MeetingVO();
				MemListVO mlVo = new MemListVO();
				
				mVO.setMetNum(metNum[i]);
				mlVo.setMetNum(metNum[i]);
				mlVo.setMemNum(memNum);
				mlVo.setMemName(memName);
				mlVo.setMemId(memId);
				
				MeetingDAO mDao = MeetingDAO.getInstance();
				mDao.acceptMeeting(mVO);
				mDao.meetingManagerInsert(mlVo);
				mDao.meetingManagerUpdate(mlVo);
				
			}
		}

		new AdminMeetingAcceptListAction().execute(request, response);
	}

}
