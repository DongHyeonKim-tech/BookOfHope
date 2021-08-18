package com.itbook.controller.action.report;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReportDAO;
import com.itbook.vo.Report.ReportBoardVO;

/**
 * @author 수아
 */

public class ReportUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ReportBoardVO rVo = new ReportBoardVO();

		rVo.setReportTitle(request.getParameter("reportTitle"));
		rVo.setReportContent(request.getParameter("reportContent"));
		rVo.setReportCategory(request.getParameter("reportCategory"));
		rVo.setReportNum(request.getParameter("reportNum"));
		rVo.setBookTitle(request.getParameter("bookTitle"));

		ReportDAO rDao = ReportDAO.getInstance();
		rDao.updateReport(rVo);


		new ReportDetailFormAction().execute(request, response);
	}

}