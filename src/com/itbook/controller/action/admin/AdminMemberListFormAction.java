package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Paging;

public class AdminMemberListFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "admin/memberList.jsp";
		
		MemberDAO mDao = MemberDAO.getInstance();
		Paging paging = new Paging(10,1);
	    int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
	    
	    paging.setPageNum(pageNum);
	    mDao.memberRowCount(paging);
	    ArrayList<MemberVO> list = mDao.memberListP(paging);
	    ArrayList<MemberVO> donation = mDao.memberListDonation(paging);
	      
		request.setAttribute("paging", paging);
		request.setAttribute("memberList", list);
		request.setAttribute("donation", donation);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
