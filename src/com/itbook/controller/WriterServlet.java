package com.itbook.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;

@WebServlet("/writer")
public class WriterServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	
	
	public WriterServlet() {
		super();
	}
	
	
	  @Override
	protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String command = request.getParameter("command");
			System.out.println("WriterServlet에서 요청을 받음을 확인 : " + command);
			//싱글턴 패턴
			WriterActionFactory af = WriterActionFactory.getInstance();
			
			
			Action action = af.getAction(command);
			if(action != null){
			action.execute(request, response);
			}
	    }
	    
	    
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		@Override
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			doGet(request, response);
			

		      }
		}
