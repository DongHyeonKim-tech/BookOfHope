package com.itbook.controller.action.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.LibraryDAO;
import com.itbook.vo.MemberVO;

/**
 * @author 수아
 */

public class LibraryDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String libraryNum = request.getParameter("libraryNum");
		
		LibraryDAO lDao = LibraryDAO.getInstance();
		
		try {
	         HttpSession session = request.getSession();
	         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
	         System.out.println(member.getAuthority());
	         
	         if (member.getAuthority().equals("3")) {
	            lDao.deleteLibrary(libraryNum);
	         }
	         
	      } catch (Exception e) {
	         System.out.println("session doesn't exist.");
	      }
		
		new AdminLibraryList().execute(request, response);
	}

}