package com.itbook.controller.action.bookstore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookstoreDAO;
import com.itbook.vo.Bookstore.BookstoreVO;

public class BookstoreUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookstoreVO bsVo = new BookstoreVO();
		
		bsVo.setBookstoreNum(request.getParameter("bookstoreNum"));
		bsVo.setBookstoreTitle(request.getParameter("bookstoreTitle"));
		bsVo.setBookstoreUrl(request.getParameter("bookstoreUrl"));
		bsVo.setBookstoreContent(request.getParameter("bookstoreContent"));
		
		BookstoreDAO bsDao = BookstoreDAO.getInstance();
		bsDao.updateBookstore(bsVo);
		
		new AdminBookstoreList().execute(request, response);
	}

}
