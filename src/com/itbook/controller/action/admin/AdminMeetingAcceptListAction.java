package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.Meeting.MeetingVO;
public class AdminMeetingAcceptListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/meetingAcceptForm.jsp";
		MeetingDAO mDao = MeetingDAO.getInstance();
	
		
		//책 페이징
		Paging paging = new Paging(10,1);
	    int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
	    
	    paging.setPageNum(pageNum);
	    mDao.adminMeetingRowCount(paging);
	    ArrayList<MeetingVO> metList = mDao.meetingList(paging);

	      
	    request.setAttribute("metList", metList);
	    request.setAttribute("paging", paging);
	      
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
