package com.itbook.controller.action.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.TaxDAO;
import com.itbook.vo.donation.TaxVO;

public class YearEndTaxInsertAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taxName = request.getParameter("taxName");
		String taxEmail = request.getParameter("taxEmail");
		String taxPhone = request.getParameter("taxPhone");
		String taxAdr1 = request.getParameter("taxAdr1");
		String taxAdr2 = request.getParameter("taxAdr2");
		String taxAdr3 = request.getParameter("taxAdr3");
		String taxMsg = request.getParameter("taxMsg");
		String memNum = request.getParameter("memNum");
		
		TaxVO tVo = new TaxVO();
		tVo.setTaxName(taxName);
		tVo.setTaxEmail(taxEmail);
		tVo.setTaxPhone(taxPhone);
		tVo.setTaxAdr1(taxAdr1);
		tVo.setTaxAdr2(taxAdr2);
		tVo.setTaxAdr3(taxAdr3);
		tVo.setTaxMsg(taxMsg);
		tVo.setMemNum(memNum);
		
		TaxDAO tDao = TaxDAO.getInstance();
		tDao.insertTax(tVo);
		
		
		//new MainAction().execute(request, response);
		
		response.sendRedirect("/main");
		
		
		
	}

}
