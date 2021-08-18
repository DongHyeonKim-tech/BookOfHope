package com.itbook.controller.action.writer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.WriterDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.WriterVO;


public class AdminWriterListAction  implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/writer/adminWriterList.jsp";
		

		WriterDAO wDao = WriterDAO.getInstance();
		
		//페이징 처리
				  Paging paging = new Paging(10,1);
			      int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));

			      paging.setPageNum(pageNum);
			      wDao.selectWriterRowCount(paging);
			      ArrayList<WriterVO> writerList = wDao.selectAdminWriterListPaging(paging);

			      
			      request.setAttribute("writerList", writerList);
			      request.setAttribute("paging", paging);
			      System.out.println(writerList);
			      
			      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			      dispatcher.forward(request, response);
		
		
	}

}
