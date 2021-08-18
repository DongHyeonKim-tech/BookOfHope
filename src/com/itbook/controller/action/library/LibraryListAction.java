package com.itbook.controller.action.library;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;

import com.itbook.dao.LibraryDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.library.LibraryVO;

/**
 * @author 수아
 */

public class LibraryListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/library/libraryList.jsp";
		
		

		LibraryDAO lDao = LibraryDAO.getInstance();
		
		//페이징
		Paging paging = new Paging(9,1);
	    int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
	    
	    paging.setPageNum(pageNum);
	    lDao.selectLibraryRowCount(paging);
	   
	    
		ArrayList<LibraryVO> libraryList = lDao.selectLibraryList(paging);
		request.setAttribute("libraryList", libraryList);
		request.setAttribute("paging", paging);

		System.out.println(libraryList + "libraryList 출력완료.");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
