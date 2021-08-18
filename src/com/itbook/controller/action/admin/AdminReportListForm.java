package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReportDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.Report.ReportBoardVO;

public class AdminReportListForm implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/reportList.jsp";
		
		ReportDAO rDao = ReportDAO.getInstance();
		Paging paging = new Paging(10,1);
	    int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
	    
	    paging.setPageNum(pageNum);
	    rDao.selectReportRowCount(paging);
	    ArrayList<ReportBoardVO> list = rDao.selectReportPage(paging);
	      
		request.setAttribute("paging", paging);
		request.setAttribute("reportList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
