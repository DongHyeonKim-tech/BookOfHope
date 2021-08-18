package com.itbook.controller.action.readBook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReadBookDAO;
import com.itbook.vo.MemberVO;


public class ReadBookDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String readBookNo = request.getParameter("readBookNo");

		ReadBookDAO rbDao = ReadBookDAO.getInstance();
		
		try {
	         HttpSession session = request.getSession();
	         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
	         System.out.println(member.getAuthority());
	         
	         if (member.getAuthority().equals("3")) {
	            rbDao.deleteReadBook(readBookNo);
	         }
	         
	      } catch (Exception e) {
	         System.out.println("session doesn't exist.");
	      }

		new ReadBookListAction().execute(request, response);
	}
}
