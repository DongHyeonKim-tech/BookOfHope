package com.itbook.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;

public class SearchPwAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/searchPwView.jsp";
		
		String memName = request.getParameter("memName");
		String memId = request.getParameter("memId");
		String email = request.getParameter("email");
		
		System.out.println(memId);
		System.out.println(memName);
		System.out.println(email);
		
		String memPw = request.getParameter("memPw");
		request.setAttribute("memPw", memPw);
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.searchPw(memId, memName, email);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
