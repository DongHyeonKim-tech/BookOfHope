package com.itbook.controller.action.book;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.Book.BookBoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminTodayBookUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		int fileSize = 5 * 1024 * 1024;
		// 업로드될 폴더 경로
		String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());

			// 파라미터 값을 가져온다.
			String bookBrdNum = multi.getParameter("bookBrdNum");
			String bookBrdTitle = multi.getParameter("bookBrdTitle");
			String bookBrdContent = multi.getParameter("bookBrdContent");
			String bookTitle = multi.getParameter("bookTitle");
			String writer = multi.getParameter("writer");
			String publisher = multi.getParameter("publisher");
			String bookNum = multi.getParameter("bookNum");
			String existFile = multi.getParameter("imgPath"); // 기존첨부파일

			// 파라미터 값을 자바빈에 세팅한다.
			BookBoardVO bVo = new BookBoardVO();
			bVo.setBookBrdNum(bookBrdNum);
			bVo.setBookBrdTitle(bookBrdTitle);
			bVo.setBookBrdContent(bookBrdContent);
			bVo.setBookTitle(bookTitle);
			bVo.setWriter(writer);
			bVo.setPublisher(publisher);
			bVo.setBookNum(bookNum);

			// 글 수정 시 업로드된 파일 가져오기
			Enumeration<String> fileNames = multi.getFileNames();
			if (fileNames.hasMoreElements()) {
				String fileName = fileNames.nextElement();
				String updateFile = multi.getFilesystemName(fileName);
				if (updateFile == null) // 수정시 새로운 파일을 첨부 안했다면 기존파일명 세팅
					bVo.setImgPath(existFile);
				else
					bVo.setImgPath(updateFile);
			}

			
			
			BookDAO bDao = BookDAO.getInstance();
			boolean result = bDao.updateAdminTodayBook(bVo);

			if (result) {
				new AdminTodayBookListAction().execute(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 수정 오류 : " + e.getMessage());
		}
	}
}