package com.itbook.controller.action.readBook;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReadBookDAO;
import com.itbook.vo.readBook.ReadBookVO;


public class ReadBookUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/readBook/readBookUpdate.jsp";

		// 페이지 번호와 글 번호를 가져온다.
		String pageNum = request.getParameter("page");
		String readBookNo = request.getParameter("readBookNo");

		ReadBookDAO rbDao = ReadBookDAO.getInstance();
		ReadBookVO readBook = rbDao.selectOneReadBookByNo(readBookNo);

		request.setAttribute("readBook", readBook);
		request.setAttribute("pageNum", pageNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
