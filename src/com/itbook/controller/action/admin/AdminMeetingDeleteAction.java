package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Meeting.MeetingVO;

public class AdminMeetingDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] metNum = request.getParameterValues("metNum");
		if(metNum != null) {
			for(int i = 0; i< metNum.length; i++) {
				request.setAttribute("metNum", metNum[i]);
				
				MeetingVO mVO = new MeetingVO();
				mVO.setMetNum(metNum[i]);
				
				MeetingDAO mDao = MeetingDAO.getInstance();
				
				try {
			         HttpSession session = request.getSession();
			         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
			         System.out.println(member.getAuthority());
			         
			         if (member.getAuthority().equals("3")) {
			            mDao.deleteMeeting(mVO);
			         }
			         
			      } catch (Exception e) {
			         System.out.println("session doesn't exist.");
			      }
				
			}
		}
		request.setAttribute("msg", "������ �Ϸ�Ǿ����ϴ�.");
		new AdminMeetingListAction().execute(request, response);
		
	}

}
