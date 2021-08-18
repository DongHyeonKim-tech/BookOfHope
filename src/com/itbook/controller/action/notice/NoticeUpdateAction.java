package com.itbook.controller.action.notice;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Notice.NoticeVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * 공지사항 수정 해주는 액션 클래스
 * 
 * @author 김정민
 *
 */

public class NoticeUpdateAction implements Action {

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
			String noticeNum = multi.getParameter("noticeNum"); // 글 번호
			String noticeTitle = multi.getParameter("noticeTitle"); // 글 제목
			String noticeContent = multi.getParameter("noticeContent"); // 글 내용
			String noticeCategory = multi.getParameter("noticeCategory"); // 글 카테고리
			
			String existFile = multi.getParameter("existing_file"); // 기존 첨부 파일

			// 파라미터 값을 자바빈에 세팅한다.
			NoticeVO nVo = new NoticeVO();
			nVo.setNoticeNum(noticeNum);
			nVo.setNoticeTitle(noticeTitle);
			nVo.setNoticeContent(noticeContent);
			nVo.setNoticeCategory(noticeCategory);
			

			// 글 수정 시 업로드된 파일 가져오기
			Enumeration<String> fileNames = multi.getFileNames();
			if (fileNames.hasMoreElements()) {
				String fileName = fileNames.nextElement();
				String updateFile = multi.getFilesystemName(fileName);

				if (updateFile == null) // 수정시 새로운 파일을 첨부 안했다면 기존 파일명을 세팅
					nVo.setNoticeFile(existFile);
				else // 새로운 파일을 첨부했을 경우
					nVo.setNoticeFile(updateFile);
			}
			
			System.out.println(nVo);

			NoticeDAO nDao = NoticeDAO.getInstance();
			boolean result = nDao.updateNotice(nVo);

			if (result) {

				// 원래있던 페이지로 돌아가기 위해 페이지번호를 전달한다.
				// forward.setNextPath("BoardListAction.bo?page="+pageNum);

				new NoticeListFormAction().execute(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 수정 오류 : " + e.getMessage());
		}

	}

}
