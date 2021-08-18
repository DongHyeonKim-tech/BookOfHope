package com.itbook.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.WriterDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.WriterVO;


public class AdminWriterDeleteAction  implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String[] writerNo = request.getParameterValues("writerNo");
			
			if(writerNo != null) {
				
			for (int idx = 0; writerNo.length > idx; idx++) {
				request.setAttribute("writerNo", writerNo[idx]);
	
				System.out.println("writerNo : " + writerNo[idx]);
	
				WriterVO wVO = new WriterVO();
	
				wVO.setWriterNo(writerNo[idx]);
				
				WriterDAO wDao = WriterDAO.getInstance();
				
				try {
			         HttpSession session = request.getSession();
			         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
			         System.out.println(member.getAuthority());
			         
			         if (member.getAuthority().equals("3")) {
			            wDao.writerDelete(wVO);
			         }
			         
			      } catch (Exception e) {
			         System.out.println("session doesn't exist.");
			      }
				
				
			}
			}
			
			request.setAttribute("msg", "관리자 대전 작가 삭제");
			
		new AdminWriterListFormAction().execute(request, response);
		
	}

	
	
}
