package com.itbook.controller.action.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.Book.BookBoardVO;

public class TodayBookListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/book/todayBookList.jsp";
		
		BookDAO bDao = BookDAO.getInstance();
		//페이징 처리
		
		Paging paging = new Paging(9,1);
	      int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));

	      paging.setPageNum(pageNum);
	      bDao.selectTodayBookRowCount(paging);
	      ArrayList<BookBoardVO> todayBookList = bDao.selecTodayBookPage(paging);

	      
	      request.setAttribute("todayBookList", todayBookList);
	      request.setAttribute("paging", paging);
	      System.out.println(todayBookList);
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
		
		
	}

}
