package com.itbook.controller.action.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReportDAO;
import com.itbook.vo.MemberVO;

/**
 * @author 수아
 */

public class ReportDeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ReportNum = request.getParameter("reportNum");

		ReportDAO rDao = ReportDAO.getInstance();
		try {
	         HttpSession session = request.getSession();
	         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
	         System.out.println(member.getAuthority());
	         
	         if (member.getAuthority().equals("3")) {
	            rDao.deleteReport(ReportNum);
	         }
	         
	      } catch (Exception e) {
	         System.out.println("session doesn't exist.");
	      }


		new ReportListFormAction().execute(request, response);
	}

}
