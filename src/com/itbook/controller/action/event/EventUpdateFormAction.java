package com.itbook.controller.action.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.EventDAO;
import com.itbook.vo.Event.EventVO;


public class EventUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/event/eventUpdate.jsp";

		// 페이지 번호와 글 번호를 가져온다.
		String pageNum = request.getParameter("page");
		String eventNo = request.getParameter("eventNo");

		EventDAO eDao = EventDAO.getInstance();
		EventVO event = eDao.selectOneEvnetByNo(eventNo);

		request.setAttribute("event", event);
		request.setAttribute("pageNum", pageNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
