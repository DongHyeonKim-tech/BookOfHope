package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReportDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Report.ReportBoardVO;

public class AdminReportDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] reportNum = request.getParameterValues("reportNum");
		
		if(reportNum != null) {
			
		for (int idx = 0; reportNum.length > idx; idx++) {
			request.setAttribute("reportNum", reportNum[idx]);

			System.out.println("reportNum : " + reportNum[idx]);

			ReportBoardVO rVO = new ReportBoardVO();

			rVO.setReportNum(reportNum[idx]);
			
			ReportDAO rDao = ReportDAO.getInstance();
			
			try {
		         HttpSession session = request.getSession();
		         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
		         System.out.println(member.getAuthority());
		         
		         if (member.getAuthority().equals("3")) {
		            rDao.ReportDelete(rVO);
		         }
		         
		      } catch (Exception e) {
		         System.out.println("session doesn't exist.");
		      }
			
			
		}
		}
		
		request.setAttribute("msg", "������ �Ϸ�Ǿ����ϴ�.");
		new AdminReportListForm().execute(request, response);
	}

}
