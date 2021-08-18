package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookTalkDAO;
import com.itbook.vo.BookTalkVO;
import com.itbook.vo.MemberVO;


public class AdminBookTalkDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String[] talkNo = request.getParameterValues("talkNo");
		
		if(talkNo != null) {
			
		for (int idx = 0; talkNo.length > idx; idx++) {
			request.setAttribute("talkNo", talkNo[idx]);

			BookTalkVO bVO = new BookTalkVO();

			bVO.setTalkNo(talkNo[idx]);
			
			BookTalkDAO bDao = BookTalkDAO.getInstance();
			
			try {
		         HttpSession session = request.getSession();
		         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
		         System.out.println(member.getAuthority());
		         
		         if (member.getAuthority().equals("3")) {
		            bDao.bookTalkDelete(bVO);
		         }
		         
		      } catch (Exception e) {
		         System.out.println("session doesn't exist.");
		      }
			
			
		}
		}
		
		request.setAttribute("msg", "북토크 삭제 formAction");
		
		new AdminBookTalkListFormAction().execute(request, response);
	
	}

}
