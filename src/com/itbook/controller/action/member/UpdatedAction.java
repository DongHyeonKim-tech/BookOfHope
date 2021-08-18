package com.itbook.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;

public class UpdatedAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/updatedPage.jsp";
		
		String memId = request.getParameter("memId");
		MemberVO tempVo = new MemberVO();
		tempVo.setMemId(memId);
		
		MemberVO memVo = MemberDAO.getInstance().getMemberInfo(tempVo);
		request.setAttribute("memVo", memVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
