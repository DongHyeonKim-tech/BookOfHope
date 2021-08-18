package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.feePaymentDAO;
import com.itbook.vo.FeePaymentVO;
import com.itbook.vo.Paging;

public class AdminFeePaymentListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/admin/feePayList.jsp";
		
		feePaymentDAO fDao = feePaymentDAO.getInstance();
		
		//페이징 처리
				  Paging paging = new Paging(10,1);
			      int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));

			      paging.setPageNum(pageNum);
			      fDao.adminSelectfeePayment(paging);
			      ArrayList<FeePaymentVO> feePayList = fDao.adminSelectfeePayment(paging);

			      
			      request.setAttribute("feePayList", feePayList);
			      request.setAttribute("paging", paging);
			      System.out.println(feePayList);
			      
			      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			      dispatcher.forward(request, response);
		
		
		
	}
	
}
