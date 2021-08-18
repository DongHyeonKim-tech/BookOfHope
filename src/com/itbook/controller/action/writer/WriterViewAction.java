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


public class WriterViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "writer/writerView.jsp";
		String writerNo = request.getParameter("writerNo");

		

		// 酉고럹�씠吏� 媛�湲곗쟾�뿉 酉고럹�씠吏��뿉 肉뚮젮�빞 �맆 �뜲�씠�꽣 �궡�슜�쓣 媛��졇���꽌 request�뿉 �떞�븘 �넃�� �떎�쓬 酉� �럹�씠吏�濡� 媛��옄
		  WriterVO wVo = WriterDAO.getInstance().selectOneWriterNo(writerNo);

		request.setAttribute("writer", wVo);
		
		List<FileVO> fileList = WriterDAO.getInstance().getFileList(writerNo);
		request.setAttribute("fileList", fileList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

		
	}


