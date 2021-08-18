package com.itbook.controller.action.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.LibraryDAO;
import com.itbook.vo.library.LibraryVO;

/**
 * @author 수아
 */

public class LibraryUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibraryVO lVo = new LibraryVO();
		
		lVo.setLibraryNum(request.getParameter("libraryNum"));
		lVo.setLibraryTitle(request.getParameter("libraryTitle"));
		lVo.setLibraryUrl(request.getParameter("libraryUrl"));
		lVo.setLibraryContent(request.getParameter("libraryContent"));
		
		LibraryDAO lDao = LibraryDAO.getInstance();
		lDao.updateLibrary(lVo);
		
		new AdminLibraryList().execute(request, response);
	}

}
