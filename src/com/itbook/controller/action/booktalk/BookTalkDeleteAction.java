package com.itbook.controller.action.booktalk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookTalkDAO;
import com.itbook.vo.MemberVO;


public class BookTalkDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String talkNo = request.getParameter("talkNo");

		BookTalkDAO bDao = BookTalkDAO.getInstance();
		
		try {
	         HttpSession session = request.getSession();
	         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
	         System.out.println(member.getAuthority());
	         
	         if (member.getAuthority().equals("3")) {
	            bDao.deleteBookTalk(talkNo);
	         }
	         
	      } catch (Exception e) {
	         System.out.println("session doesn't exist.");
	      }
		

		new BookTalkListFormAction().execute(request, response);
	}
		
	

	
	
	
	
}
