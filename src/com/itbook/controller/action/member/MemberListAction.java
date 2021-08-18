package com.itbook.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;

public class MemberListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MemberVO memVO = new MemberVO();
		MemberDAO memDao = MemberDAO.getInstance();
		
		memVO.setMemId(request.getParameter("memId"));
		
		MemberVO sessionVO = memDao.getMemberInfo(memVO);
		
		
	}

}
