package com.itbook.controller.action.program;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ProgramDAO;
import com.itbook.vo.ProgramVO;

public class ProgramUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/program/programUpdateForm.jsp";

		// 페이지 번호와 글 번호를 가져온다.
		
		String proNo = request.getParameter("proNo");

		ProgramDAO bDao = ProgramDAO.getInstance();
		ProgramVO program = bDao.selectOneProgramByNum(proNo);

		request.setAttribute("program", program);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
		
	}

