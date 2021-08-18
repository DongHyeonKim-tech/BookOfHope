package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itbook.controller.action.Action;
import com.itbook.dao.MetCommentDAO;

/**
 * 독서모임게시판 게시글의 댓글을 지우는 액션 클래스 
 * 
 * @author 김정민
 *
 */

public class CommentDeleteAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String metComtNum = request.getParameter("metComtNum");
		String metBrdNum = request.getParameter("metBrdNum");
		
		System.out.println("metBrdNum : " + metBrdNum );
		
		MetCommentDAO dao = MetCommentDAO.getInstance();
		boolean result = dao.deleteComment(metComtNum);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		new MetBoardViewAction().execute(request, response);
		// 정상적으로 댓글을 삭제했을경우 1을 전달한다.
		if(result) out.print("1");
		
		out.close();
		
	}

}
