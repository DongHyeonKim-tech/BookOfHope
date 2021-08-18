package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookTalkDAO;
import com.itbook.vo.BookTalkVO;
import com.itbook.vo.Paging;


public class AdminBookTalkListFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/bookTalkList.jsp";
		
		
		BookTalkDAO bDao = BookTalkDAO.getInstance();
		Paging paging = new Paging(10,1);
	    int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
	    
	    paging.setPageNum(pageNum);
	    bDao.selectBookTalkRowCount(paging);
	    ArrayList<BookTalkVO> list = bDao.selectBookTalkPage(paging);
	      
		request.setAttribute("paging", paging);
		request.setAttribute("bookTalkList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
	}
	
	

}
