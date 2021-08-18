package com.itbook.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;

public class MemberPwModifyAction implements Action{
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberVO mVo = new MemberVO();
		String memNum = request.getParameter("memNum");
		request.setAttribute("memNum", memNum);
		mVo.setMemNum(request.getParameter("memNum"));
		mVo.setMemPw(request.getParameter("memPw"));
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.memberPwUpdate(mVo);
		
		new MemberModifyGoAction().execute(request, response);
	}
	
}
