package com.itbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itbook.dao.BookDAO;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.main.MainDTO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MainServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String command = request.getParameter("command");
		System.out.println("MainServlet : " + command);

		// 硫붿씤�솕硫댁뿉�꽌 紐⑥엫 蹂댁뿬二쇨린
		MeetingDAO mDao = MeetingDAO.getInstance();
		List<MainDTO> meetingMainList = mDao.selectMainMeetings();
		request.setAttribute("meetingMainList", meetingMainList);
		
		// 硫붿씤�솕硫댁뿉�꽌 �씠�떖�쓽 梨� 蹂댁뿬二쇨린
		BookDAO bDao = BookDAO.getInstance();
		List<MainDTO> maintodayBookList = bDao.selectMainTodayBooks();
		request.setAttribute("maintodayBookList", maintodayBookList);

		if (command == null) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("loginForm")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("notLogin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
