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

public class ReportUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "report/reportUpdateForm.jsp";

		String reportNum = request.getParameter("reportNum");
		
		ReportDAO rDao = ReportDAO.getInstance();
		
		//reportNum 정보 조회
		ReportBoardVO rVo = rDao.selectOneReportByNum(reportNum);

		request.setAttribute("reportList", rVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}