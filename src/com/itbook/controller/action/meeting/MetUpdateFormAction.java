package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
//import com.itbook.dao.MemberDAO;
import com.itbook.vo.Meeting.MeetingVO;

public class MetUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/meeting/meetingUpdateForm.jsp";
		
		//�α��� ���ǰ��� �޾ƿ´�.
		// session = request.getSession();
		
		//�������ӹ�ȣ�� �����´�.
		String metNum = request.getParameter("metNum");
		
		//ȸ������ �����´�.
		//String memName = request.getParameter("metName");
		
		MeetingDAO mDao = MeetingDAO.getInstance();
		
		//metNum�� �������� ���������� �����ϴ� DAO�� sql�� ->MeetingUpdateAction���� �ű��
		//mDao.updateMeeting(metNum);
		
		MeetingVO metVo = mDao.selectOneMeetingByNum(metNum);
		
		request.setAttribute("meeting", metVo);
		//request.setAttribute("LoginUser", memVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
