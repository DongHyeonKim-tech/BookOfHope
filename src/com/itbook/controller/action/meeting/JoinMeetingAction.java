package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemListVO;

public class JoinMeetingAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memNum = request.getParameter("memNum");
		String metNum = request.getParameter("metNum");
		String memId = request.getParameter("memId");
		String memName = request.getParameter("memName");
		
		MemListVO mVo = new MemListVO();
		mVo.setMemNum(memNum);
		mVo.setMetNum(metNum);
		mVo.setMemId(memId);
		mVo.setMemName(memName);
		System.out.println(mVo);
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.joinMember(mVo);
	}

}
