package com.itbook.controller.action.bookstore;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookstoreDAO;
import com.itbook.vo.Bookstore.BookstoreVO;

public class BookstoreUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String url = "/bookstore/bookstoreUpdate.jsp";
		
		String bookstoreNum = request.getParameter("bookstoreNum");
		
		
		BookstoreDAO bsDao = BookstoreDAO.getInstance();
				
		BookstoreVO bsVo = bsDao.selectOneBookstoreNum(bookstoreNum);
				
		request.setAttribute("bookstoreList", bsVo);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
