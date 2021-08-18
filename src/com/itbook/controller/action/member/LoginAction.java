package com.itbook.controller.action.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;
import com.itbook.vo.MemListVO;
import com.itbook.vo.MemberVO;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/main?command=loginForm";
		
		//�꽭�뀡 �슂泥�
		HttpSession session = request.getSession();

		if(session.getAttribute("LoginUser") != null) {
			RequestDispatcher disptcher = request.getRequestDispatcher(url);
			disptcher.forward(request, response);	
			
		}
		
		else if(session.getAttribute("LoginUserList") != null) {
			RequestDispatcher disptcher = request.getRequestDispatcher(url);
			disptcher.forward(request, response);	
			
		}else {
			
			MemberVO memVO = new MemberVO();
			MemListVO listVO = new MemListVO();
			
			MemberDAO memDao = MemberDAO.getInstance();
			
			memVO.setMemId(request.getParameter("memId"));
			memVO.setMemPw(request.getParameter("memPw"));
			
			listVO.setMemId(request.getParameter("memId"));
			
			
			System.out.println(memDao.loginCheck(memVO));
		
			switch(memDao.loginCheck(memVO)) {
			
				case 1:
					
				{
						MemberVO sessionVO = memDao.getMemberInfo(memVO);
						session.setAttribute("LoginUser", sessionVO);
						
						
						ArrayList<MemListVO> sessionListVO = memDao.getMemberListInfo(listVO);
						session.setAttribute("LoginUserList", sessionListVO);
					
						break;
				}
				case 0:
				{
						request.setAttribute("message", "비밀번호가 틀렸습니다." );
						url = "main?command=notLogin";
						break;
				}
				case -1:
				{
						request.setAttribute("message", "아이디가 존재하지 않습니다.");
						url = "main?command=notLogin";
						break;
				}
				default : request.setAttribute("message", "아이디와 비밀번호를 입력해주세요.");
				}
			
					RequestDispatcher disptcher = request.getRequestDispatcher(url);
					disptcher.forward(request, response);
		}
			
		
	}

}
