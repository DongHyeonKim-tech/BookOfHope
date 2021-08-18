package com.itbook.controller.action.program;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.readBook.ReadBookListAction;
import com.itbook.dao.ProgramDAO;
import com.itbook.vo.MemberVO;


public class ProgramDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proNo = request.getParameter("proNo");

		ProgramDAO pDao = ProgramDAO.getInstance();
		
		try {
	         HttpSession session = request.getSession();
	         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
	         System.out.println(member.getAuthority());
	         
	         if (member.getAuthority().equals("3")) {
	            pDao.deleteProgram(proNo);
	         }
	         
	      } catch (Exception e) {
	         System.out.println("session doesn't exist.");
	      }

		new ReadBookListAction().execute(request, response);
	}
}
