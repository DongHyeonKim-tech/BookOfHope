package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemberVO;

public class AdminMemberDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] memNum = request.getParameterValues("memNum");
		
		if(memNum != null) {
			
		for (int idx = 0; memNum.length > idx; idx++) {
			request.setAttribute("memNum", memNum[idx]);

			System.out.println("memNum : " + memNum[idx]);

			MemberVO mVO = new MemberVO();

			mVO.setMemNum(memNum[idx]);
			
			MemberDAO mDao = MemberDAO.getInstance();
			
			try {
		         HttpSession session = request.getSession();
		         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
		         System.out.println(member.getAuthority());
		         
		         if (member.getAuthority().equals("3")) {
		            mDao.memberDelete(mVO);
		         }
		         
		      } catch (Exception e) {
		         System.out.println("session doesn't exist.");
		      }
			
			
		}
		}
		request.setAttribute("msg", "");
		new AdminMemberListDeleteAction().execute(request, response);
	}

}
