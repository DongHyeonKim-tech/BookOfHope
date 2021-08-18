package com.itbook.controller.action.booktalk;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookTalkDAO;
import com.itbook.vo.BookTalkVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BookTalkUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 업로드 파일 사이즈
		int fileSize = 5 * 1024 * 1024;
		// 업로드될 폴더 절대경로
		String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());

			// 파리미터 값을 가져온다.
			String talkNo = multi.getParameter("talkNo"); // 글 번호
			String writer = multi.getParameter("writer"); // 글 제목
			String talkName = multi.getParameter("talkName"); // 글 내용
			String talkDate = multi.getParameter("talkDate");
			String talkContents = multi.getParameter("talkContents");
			String talkPlace = multi.getParameter("talkPlace");
			String articleURL = multi.getParameter("articleURL");
			String talkPublisher = multi.getParameter("talkPublisher");
			String videoURL = multi.getParameter("videoURL");
			
			String existFile = multi.getParameter("existing_file"); // 기존 첨부 파일

			// 파라미터 값을 자바빈에 세팅한다.
			BookTalkVO bVo = new BookTalkVO();
			bVo.setTalkNo(talkNo);
			bVo.setTalkName(talkName);
			bVo.setWriter(writer);
			bVo.setTalkDate(talkDate);
			bVo.setTalkPlace(talkPlace);
			bVo.setTalkContents(talkContents);
			bVo.setArticleURL(articleURL);
			bVo.setTalkPublisher(talkPublisher);
			bVo.setVideoURL(videoURL);
			
			// 글 수정 시 업로드된 파일 가져오기
			Enumeration<String> fileNames = multi.getFileNames();
			if (fileNames.hasMoreElements()) {
				String fileName = fileNames.nextElement();
				String updateFile = multi.getFilesystemName(fileName);

				if (updateFile == null) // 수정시 새로운 파일을 첨부 안했다면 기존 파일명을 세팅
					bVo.setTalkFile(existFile);
				else // 새로운 파일을 첨부했을 경우
					bVo.setTalkFile(updateFile);
			}

			BookTalkDAO bDao = BookTalkDAO.getInstance();
			boolean result = bDao.updateBookTalk(bVo);

			if (result) {

				// 원래있던 페이지로 돌아가기 위해 페이지번호를 전달한다.
				// forward.setNextPath("BoardListAction.bo?page="+pageNum);

				new BookTalkListFormAction().execute(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 수정 오류 : " + e.getMessage());
		}

	}

}
