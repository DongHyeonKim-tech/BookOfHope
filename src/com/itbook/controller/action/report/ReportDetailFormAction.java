package com.itbook.controller.action.report;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;

import com.itbook.dao.ReportDAO;
import com.itbook.vo.Report.ReportBoardVO;

/**
 * @author 수아
 */

public class ReportDetailFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/report/reportDetailForm.jsp";
		
		String reportNum = request.getParameter("reportNum");
		ReportDAO rDao = ReportDAO.getInstance();
		System.out.println("reportN : " + reportNum);
		
		// 조회수 증가
		rDao.updateReportCount(reportNum);
		
		//데이터에 저장하고 상세보기 조회
		ReportBoardVO rVo = rDao.selectOneReportByNum(reportNum);
		
		request.setAttribute("reportList", rVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
