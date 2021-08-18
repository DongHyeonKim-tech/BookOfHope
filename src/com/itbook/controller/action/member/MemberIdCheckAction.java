package com.itbook.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;

public class MemberIdCheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "popup.jsp";
			
			String memId = request.getParameter("memId");
		    request.setAttribute("memId", memId); 
			
			System.out.println("memid : " + memId);
			
			MemberDAO memDao = MemberDAO.getInstance();
		    int result = memDao.idCheck(memId); 
		    request.setAttribute("result", result);
		  
		    System.out.println("result : " + result);
		 
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}

}
