package com.itbook.controller.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.BookVO;

public class BookUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookVO bVo = new BookVO();
		
		bVo.setBookNum(request.getParameter("bookNum"));
		bVo.setBookTitle(request.getParameter("bookTitle"));
		bVo.setIsbn(request.getParameter("isbn"));
		bVo.setWriter(request.getParameter("writer"));
		bVo.setPublisher(request.getParameter("publisher"));
		bVo.setBookKeyword1(request.getParameter("bookKeyword1"));
		bVo.setBookKeyword2(request.getParameter("bookKeyword2"));
		bVo.setBookKeyword3(request.getParameter("bookKeyword3"));
		
		bVo.setMemNum(request.getParameter("memNum"));
		
		BookDAO bDao = BookDAO.getInstance();
		bDao.updateBook(bVo);
		
		new BookListAction().execute(request, response);
	}

}
