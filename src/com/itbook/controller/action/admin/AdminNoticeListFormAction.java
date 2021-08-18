package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.Notice.NoticeVO;

public class AdminNoticeListFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "admin/noticeList.jsp";
		// 관리자화면 리스트 페이징
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		Paging paging = new Paging(10,1);
	    int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
	    
	    paging.setPageNum(pageNum);
	    nDao.selectNoticeRowCount(paging);
	    ArrayList<NoticeVO> list = nDao.selectNoticePage(paging);
	      
		request.setAttribute("paging", paging);
		request.setAttribute("noticeList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		
	}	

}
