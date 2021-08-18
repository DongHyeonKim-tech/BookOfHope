package com.itbook.controller.action.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.EventDAO;
import com.itbook.vo.MemberVO;

public class EventDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String eventNo = request.getParameter("eventNo");

		EventDAO eDao = EventDAO.getInstance();
		
		try {
	         HttpSession session = request.getSession();
	         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
	         System.out.println(member.getAuthority());
	         
	         if (member.getAuthority().equals("3")) {
	            eDao.deleteEvent(eventNo);
	         }
	         
	      } catch (Exception e) {
	         System.out.println("session doesn't exist.");
	      }
		

		new EventListAction().execute(request, response);
	}

}
