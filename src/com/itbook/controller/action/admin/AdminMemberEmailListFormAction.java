package com.itbook.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Paging;

public class AdminMemberEmailListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "admin/adminMemberEmailList.jsp";

		// 검색조건과 검색내용을 가져온다.
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");

		// 검색조건과 내용을 Map에 담는다.
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);

		MemberDAO mDao = MemberDAO.getInstance();

		ArrayList<MemberVO> list = mDao.adminMemberList(listOpt);

		request.setAttribute("adminMemberList", list);
		System.out.println("adminMemverList " + String.valueOf(opt));
		System.out.println("adminMemverList " + String.valueOf(condition));

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

//		MemberDAO mDao = MemberDAO.getInstance();
//		Paging paging = new Paging(10,1);
//	    int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
//	    
//	    paging.setPageNum(pageNum);
//	    mDao.memberRowCount(paging);
//	    ArrayList<MemberVO> list = mDao.memberListP(paging);
//	    ArrayList<MemberVO> donation = mDao.memberListDonation(paging);
//	      
//
//		request.setAttribute("memberList", list);
//		request.setAttribute("paging", paging);
//		request.setAttribute("donation", donation);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);

	}

}
