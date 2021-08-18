package com.itbook.controller.action.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReportDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Report.ReportBoardVO;

/**
 * @author 수아
 */

public class ReportRegAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReportBoardVO rVo = new ReportBoardVO();

		rVo.setReportTitle(request.getParameter("reportTitle"));
		rVo.setReportContent(request.getParameter("reportContent"));
		rVo.setBookNum(request.getParameter("bookNum")); 
		rVo.setWriter(request.getParameter("writer"));
		rVo.setPublisher(request.getParameter("publisher"));
		rVo.setReportCategory(request.getParameter("reportCategory"));
		rVo.setBookTitle(request.getParameter("bookTitle"));
		
		System.out.println("rvo : " + rVo);
		// 사용자 memNum
		MemberVO memVo = (MemberVO) request.getSession().getAttribute("LoginUser");
		rVo.setMemNum(memVo.getMemNum());
		ReportDAO rDao = ReportDAO.getInstance();
		rDao.insertReport(rVo);

		/* request.setAttribute("msg", "글이 등록되었습니다."); */

		new ReportListFormAction().execute(request, response);

	}
}
