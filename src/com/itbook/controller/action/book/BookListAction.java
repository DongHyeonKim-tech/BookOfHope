package com.itbook.controller.action.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.BookVO;
import com.itbook.vo.Paging;

public class BookListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/book/bookList.jsp";
		
		BookDAO bDao = BookDAO.getInstance();
	
		//책 페이징
		  Paging paging = new Paging(10,1);
	      int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));

	      paging.setPageNum(pageNum);
	      bDao.selectBookRowCount(paging);
	      ArrayList<BookVO> bookList = bDao.selectBookPage(paging);

	      
	      request.setAttribute("bookList", bookList);
	      request.setAttribute("paging", paging);
	      System.out.println(bookList);
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
	      
	}
		
}
