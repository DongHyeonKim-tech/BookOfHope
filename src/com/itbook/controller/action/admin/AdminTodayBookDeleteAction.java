package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Book.BookBoardVO;

public class AdminTodayBookDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String[] bookBrdNum = request.getParameterValues("bookBrdNum");
			
			if(bookBrdNum != null) {
				
			for (int idx = 0; bookBrdNum.length > idx; idx++) {
				request.setAttribute("bookBrdNum", bookBrdNum[idx]);
	
				System.out.println("bookBrdNum : " + bookBrdNum[idx]);
	
				BookBoardVO bVO = new BookBoardVO();
	
				bVO.setBookBrdNum(bookBrdNum[idx]);
				
				BookDAO bDao = BookDAO.getInstance();
				
				try {
			         HttpSession session = request.getSession();
			         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
			         System.out.println(member.getAuthority());
			         
			         if (member.getAuthority().equals("3")) {
			            bDao.todayBookDelete(bVO);
			         }
			         
			      } catch (Exception e) {
			         System.out.println("session doesn't exist.");
			      }
				
				
			}
			}
			
			request.setAttribute("msg", "������ �Ϸ�Ǿ����ϴ�.");
			
		new AdminTodayBookListFormAction().execute(request, response);
		
	}

}


