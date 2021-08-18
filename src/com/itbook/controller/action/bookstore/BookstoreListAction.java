package com.itbook.controller.action.bookstore;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookstoreDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.Bookstore.BookstoreVO;

public class BookstoreListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/bookstore/bookstoreList.jsp";
		
		BookstoreDAO bsDao = BookstoreDAO.getInstance();
		
		//페이징 처리 한페이지에 12개의 데이터가 나옴
		Paging paging = new Paging(12, 1);
		
		int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
		paging.setPageNum(pageNum);
		
		//책방의 전체 데이터 행을 카운트함.
		bsDao.selectBookstoreRowCount(paging);
		 
		ArrayList<BookstoreVO> bookstoreList = bsDao.selectBookstoreList(paging);
		request.setAttribute("bookstoreList", bookstoreList);
		request.setAttribute("paging", paging);
		System.out.println(bookstoreList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}

}
