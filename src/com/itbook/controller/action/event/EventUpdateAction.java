package com.itbook.controller.action.event;

import java.io.IOException;

import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;

import com.itbook.dao.EventDAO;

import com.itbook.vo.Event.EventVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EventUpdateAction implements Action {

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
			String eventNo = multi.getParameter("eventNo"); // 글 번호
			String eventName = multi.getParameter("eventName"); // 글 제목
			String eventPlace = multi.getParameter("eventPlace"); // 행사 장소
			String eventDate = multi.getParameter("eventDate"); // 행사 일시
			String eventContents = multi.getParameter("eventContents"); // 글 내용
			String existFile = multi.getParameter("existing_file"); // 글 내용

			// 파라미터 값을 자바빈에 세팅한다.
			EventVO eVo = new EventVO();
			eVo.setEventNo(eventNo);
			eVo.setEventName(eventName);
			eVo.setEventPlace(eventPlace);
			eVo.setEventDate(eventDate);
			eVo.setEventContents(eventContents);
			

			// 글 수정 시 업로드된 파일 가져오기
			Enumeration<String> fileNames = multi.getFileNames();
			if (fileNames.hasMoreElements()) {
				String fileName = fileNames.nextElement();
				String updateFile = multi.getFilesystemName(fileName);

				if (updateFile == null) // 수정시 새로운 파일을 첨부 안했다면 기존 파일명을 세팅
					eVo.setEventFile(existFile);
				else // 새로운 파일을 첨부했을 경우
					eVo.setEventFile(updateFile);
			}

			EventDAO eDao = EventDAO.getInstance();
			boolean result = eDao.updateEvent(eVo);

			if (result) {

				// 원래있던 페이지로 돌아가기 위해 페이지번호를 전달한다.
				// forward.setNextPath("BoardListAction.bo?page="+pageNum);

				new EventListAction().execute(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 수정 오류 : " + e.getMessage());
		}

	}

}
