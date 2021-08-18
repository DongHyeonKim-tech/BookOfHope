package com.itbook.controller;

import java.io.IOException;



import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.dao.WriterDAO;
import com.itbook.vo.FileVO;


import net.sf.json.JSONArray;

/**
 * Servlet implementation class FileAttachAjax
 */
@WebServlet("/getFileAttach")
public class FileAttachAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileAttachAjax() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("/getAttach");

		String writerNo = request.getParameter("writerNo") == null ? "" : request.getParameter("writerNo");
		

		if (!writerNo.equals("")) {
			
			System.out.println("getAttach writerNo : " + writerNo);

			List<FileVO> fileList = null;

			fileList = WriterDAO.getInstance().getFileList(writerNo);
			

			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");

			PrintWriter pw = response.getWriter();

			JSONArray jsonArray = JSONArray.fromObject(fileList);

			System.out.println(jsonArray);
			pw.print(jsonArray);

			pw.flush();
			pw.close();

		} 

	}

}
