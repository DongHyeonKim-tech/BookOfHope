package com.itbook.controller.action.library;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.LibraryDAO;
import com.itbook.vo.library.LibraryVO;

/**
 * @author 수아
 */

public class LibraryUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String url = "/library/libraryUpdate.jsp";
		
		String libraryNum = request.getParameter("libraryNum");
		
		
		LibraryDAO lDao = LibraryDAO.getInstance();
				
		LibraryVO lVo = lDao.selectOneLibraryNum(libraryNum);
				
		request.setAttribute("libraryList", lVo);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}