package com.itbook.controller.action.booktalk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookTalkDAO;
import com.itbook.vo.BookTalkVO;


public class BookTalkUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/bookTalk/bookTalkUpdateForm.jsp";

		// 페이지 번호와 글 번호를 가져온다.
		String pageNum = request.getParameter("page");
		String talkNo = request.getParameter("talkNo");

		BookTalkDAO bDao = BookTalkDAO.getInstance();
		BookTalkVO bookTalk = bDao.selectOneBookTalkByNum(talkNo);

		request.setAttribute("bookTalk", bookTalk);
		request.setAttribute("pageNum", pageNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
