package com.itbook.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;

public class InsertMemberAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login.jsp";
		
		String memName = request.getParameter("memName");
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String jumin = request.getParameter("jumin");
		String adr = request.getParameter("adr");
		String adr2 = request.getParameter("adr2");
		String phone = request.getParameter("phone");
		String authority = request.getParameter("authority");
		String email = request.getParameter("email");
		
		
		MemberVO memVO = new MemberVO();
		memVO.setMemId(memId);
		memVO.setMemPw(memPw);
		memVO.setJumin(jumin);
		memVO.setMemName(memName);
		memVO.setAdr(adr);
		memVO.setAdr2(adr2);
		memVO.setPhone(phone);
		memVO.setAuthority(authority);
		memVO.setEmail(email);
		
		MemberDAO memDao = MemberDAO.getInstance();
		memDao.insertMember(memVO);
		
		System.out.println("memVO : " + memVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}

}
