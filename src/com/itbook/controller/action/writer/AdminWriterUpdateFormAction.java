package com.itbook.controller.action.writer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.WriterDAO;
import com.itbook.vo.FileVO;
import com.itbook.vo.WriterVO;

public class AdminWriterUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/writer/adminWriterUpdate.jsp";
		
		

		String writerNo = request.getParameter("writerNo");
		
		
		WriterDAO wDao = WriterDAO.getInstance();
				
		WriterVO wVo = wDao.selectOneWriterNo(writerNo);
				
		request.setAttribute("writerList", wVo);
		
		List<FileVO> fileList = WriterDAO.getInstance().getFileList(writerNo);
		request.setAttribute("fileList", fileList);

		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
