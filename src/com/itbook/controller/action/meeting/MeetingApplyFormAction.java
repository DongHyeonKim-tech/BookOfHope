package com.itbook.controller.action.meeting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MemberDAO;


public class MeetingApplyFormAction implements Action {

	//독서모임 신청을 위한 폼으로 이동하는 액션 클래스
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/meeting/meetingApplyForm.jsp"; 
		
		//LoginUser의 Member테이블에서 memName 가져오기
		String LoginUser = request.getParameter("memName");
		
		//private로 선언된 DAO 클래스의 인스턴스를 가져오는 getInstance() 함수 사용
		MemberDAO mDao = MemberDAO.getInstance();
		
		request.setAttribute("LoginUser", LoginUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
