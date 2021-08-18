package com.itbook.controller;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.dao.WriterDAO;



/**
 * Servlet implementation class FileDeleteAjax
 */
@WebServlet("/deleteFile")
public class FileDeleteAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileDeleteAjax() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			process(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			process(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("deleteFile");

		String fileName = request.getParameter("fileName");
		String imgName = request.getParameter("fileName") == null ? "" : request.getParameter("fileName");

		System.out.println("Delete fileName ====> " + fileName);
		
		String uploadFilePath = request.getServletContext().getRealPath("/META-INF/UploadFolder/");

		String dFileName = request.getParameter("fileName");
		
		java.io.File file = new java.io.File(uploadFilePath + dFileName);
		
		System.out.println("Delete file ====> " + file);
		

		boolean res = false;

		if (file.isFile()) {

			System.out.println("isFile Delete");
			res = file.delete(); //밑에 줄 코드들을 안거치고 바로 삭제 가능??

		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = response.getWriter();
		pw.print("deleted");
		
		
		if (res) {
			
			pw.print("deleted");
			
			//deleteNoticeFile DB delete
			if(!imgName.equals("")) {
		      WriterDAO.getInstance().deleteFileName(dFileName);
			}
			

		}


		pw.flush();
		pw.close();  
	}

}
