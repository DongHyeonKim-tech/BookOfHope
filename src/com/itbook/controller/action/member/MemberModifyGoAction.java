package com.itbook.controller.action.member;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;

public class MemberModifyGoAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/member/myPage.jsp";
		
		MemberVO tempVo = new MemberVO();
		tempVo.setMemId((String)request.getAttribute("memId"));
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO memVo = mDao.getMemberInfo(tempVo);
		
		request.setAttribute("memVo", memVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
