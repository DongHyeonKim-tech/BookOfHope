package com.itbook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;


@WebServlet("/bookTalk")
public class BookTalkServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	public BookTalkServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String command = request.getParameter("command");
		System.out.println("BookTalkServlet에서 요청을 받음을 확인 : " + command);

		BookTalkActionFactory af = BookTalkActionFactory.getInstance();
		Action action = af.getAction(command);

		if (action != null) {
			action.execute(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	

}
