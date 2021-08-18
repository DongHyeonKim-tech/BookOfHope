package com.itbook.controller.action.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.Book.BookBoardVO;

public class AdminTodayBookUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/book/adminTodayBookUpdate.jsp";
		
		
		
		String bookBrdNum = request.getParameter("bookBrdNum");
		
		
		BookDAO bDao = BookDAO.getInstance();
				
		BookBoardVO bVo = bDao.selectOneBookBrdNum(bookBrdNum);
				
		request.setAttribute("todayBookList", bVo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
