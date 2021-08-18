package com.itbook.controller.action.writer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbook.controller.action.Action;
import com.itbook.dao.WriterDAO;
import com.itbook.vo.MemberVO;

public class AdminWriterDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writerNo = request.getParameter("writerNo");

		WriterDAO wDao = WriterDAO.getInstance();

		try {
	         HttpSession session = request.getSession();
	         MemberVO member = (MemberVO) session.getAttribute("LoginUser");
	         System.out.println(member.getAuthority());
	         
	         if (member.getAuthority().equals("3")) {
	            wDao.deleteWriter(writerNo);
	         }
	         
	      } catch (Exception e) {
	         System.out.println("session doesn't exist.");
	      }
		
		new WriterListAction().execute(request, response);

		request.setAttribute("msg", "대전 작가 삭제");

	}

}