package com.itbook.controller.action.feePayment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itbook.controller.action.Action;
import com.itbook.dao.feePaymentDAO;
import com.itbook.vo.FeePaymentVO;

public class FeePaymentRegisterAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FeePaymentVO fVo = new FeePaymentVO();
		
		fVo.setPayName(request.getParameter("payName"));
		fVo.setPayEmail(request.getParameter("payEmail"));
		fVo.setPayMobileNumber(request.getParameter("payMobileNumber"));
		fVo.setPayZipcode(request.getParameter("payZipcode"));
		fVo.setPayAttach(request.getParameter("payAttach"));
		fVo.setPayPosition(request.getParameter("payPosition"));
		fVo.setPayMessage(request.getParameter("payMessage"));
		fVo.setPayBank(request.getParameter("payBank"));
		fVo.setPayFee(request.getParameter("payFee"));
		fVo.setBankName(request.getParameter("bankName"));
		fVo.setPaySponsor(request.getParameter("paySponsor"));
		fVo.setPayBankNum(request.getParameter("payBankNum"));
		fVo.setMemNum(request.getParameter("memNum"));
		
		feePaymentDAO fDao = feePaymentDAO.getInstance();
		
		fDao.insertfeePayment(fVo);
		
	 
		//new MainAction().execute(request, response);
		response.sendRedirect("/main");
	}

}
