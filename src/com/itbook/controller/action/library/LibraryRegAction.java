package com.itbook.controller.action.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.LibraryDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.library.LibraryVO;

/**
 * @author 수아
 */

public class LibraryRegAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LibraryVO lVo = new LibraryVO();
		
		lVo.setLibraryTitle(request.getParameter("libraryTitle"));
		lVo.setLibraryUrl(request.getParameter("libraryUrl"));
		lVo.setLibraryContent(request.getParameter("libraryContent"));
		
		//setmemNum이 아니라 세션값 가져오기
		MemberVO memVo = (MemberVO)request.getSession().getAttribute("LoginUser");
	      lVo.setMemNum(memVo.getMemNum());
		
		LibraryDAO lDao = LibraryDAO.getInstance();
		
		lDao.insertLibrary(lVo);
		
		new AdminLibraryList().execute(request, response);
		
	}

}
