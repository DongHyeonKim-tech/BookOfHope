package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.BookVO;

public class AdminBookDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] bookNum = request.getParameterValues("bookNum");
		
		if(bookNum != null) {
			
		for (int idx = 0; bookNum.length > idx; idx++) {
			request.setAttribute("bookNum", bookNum[idx]);

			BookVO bVO = new BookVO();

			bVO.setBookNum(bookNum[idx]);
			
			BookDAO bDao = BookDAO.getInstance();
			bDao.bookDelete(bVO);
			
		}
		}
			request.setAttribute("msg", "");
		
		new AdminBookListFormAction().execute(request, response);
	}

}
