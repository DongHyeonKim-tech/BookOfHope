package com.itbook.controller.action.bookstore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookstoreDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Bookstore.BookstoreVO;

public class BookstoreRegister implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookstoreVO bsVo = new BookstoreVO();
		
		bsVo.setBookstoreTitle(request.getParameter("bookstoreTitle"));
		bsVo.setBookstoreUrl(request.getParameter("bookstoreUrl"));
		bsVo.setBookstoreContent(request.getParameter("bookstoreContent"));
		
		//setmemNum이 아니라 세션값 가져오기
		MemberVO memVo = (MemberVO)request.getSession().getAttribute("LoginUser");
	      bsVo.setMemNum(memVo.getMemNum());
		
		BookstoreDAO bsDao = BookstoreDAO.getInstance();
		
		bsDao.insertBookstore(bsVo);
		
		new AdminBookstoreList().execute(request, response);
		
	}

}
