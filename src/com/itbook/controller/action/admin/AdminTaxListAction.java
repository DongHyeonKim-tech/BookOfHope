package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.TaxDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.donation.TaxVO;

public class AdminTaxListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/admin/taxList.jsp";
		
		TaxDAO tDao = TaxDAO.getInstance();
		
		//페이징 처리
				  Paging paging = new Paging(10,1);
			      int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));

			      paging.setPageNum(pageNum);
			      tDao.selectTaxRowCount(paging);
			      ArrayList<TaxVO> taxList = tDao.adminSelectTax(paging);

			      
			      request.setAttribute("taxList", taxList);
			      request.setAttribute("paging", paging);
			      System.out.println(taxList);
			      
			      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			      dispatcher.forward(request, response);
		
		
		
	}
	
}
