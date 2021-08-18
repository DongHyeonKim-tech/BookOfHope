package com.itbook.controller.action.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.EventDAO;
import com.itbook.vo.Event.EventVO;

public class EventViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "event/eventView.jsp";
		String eventNo = request.getParameter("eventNo");

		// 중간에 조회수를 1증가시키기 // 조회수 증가시켜 놓고 db에 저장해 놓기
		EventDAO.getInstance().updateReadCount(eventNo);

		// 뷰페이지 가기전에 뷰페이지에 뿌려야 될 데이터 내용을 가져와서 request에 담아 놓은 다음 뷰 페이지로 가자
		EventVO eVo = EventDAO.getInstance().selectOneEvnetByNo(eventNo);
		
		System.out.println(eVo);

		request.setAttribute("event", eVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
