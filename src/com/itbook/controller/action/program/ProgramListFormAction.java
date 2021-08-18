package com.itbook.controller.action.program;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;

import com.itbook.dao.ProgramDAO;

import com.itbook.vo.ProgramVO;


public class ProgramListFormAction implements Action {

	//member 참조
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "program/programListForm.jsp";


		// 검색조건과 검색내용을 가져온다.
				String opt = request.getParameter("opt");
				String condition = request.getParameter("condition");
				
				// 검색조건과 내용을 Map에 담는다.
				HashMap<String, Object> listOpt = new HashMap<String, Object>();
				listOpt.put("opt", opt);
				listOpt.put("condition", condition);
		
				ProgramDAO pDao = ProgramDAO.getInstance();
     
	      List<ProgramVO> list = pDao.selectProgramList();


	      request.setAttribute("programList", list);
	      System.out.println("programList "+String.valueOf(opt));
	      System.out.println("programList "+String.valueOf(condition));
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
	      
	}
}
