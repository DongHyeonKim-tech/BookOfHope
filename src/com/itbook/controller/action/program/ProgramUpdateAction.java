package com.itbook.controller.action.program;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ProgramDAO;
import com.itbook.vo.ProgramVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProgramUpdateAction implements Action{

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
			String proNo = multi.getParameter("proNo"); // 글 번호
			String title = multi.getParameter("title"); // 글 제목
			String name = multi.getParameter("name"); // 글 내용
			String company = multi.getParameter("company");
			String startTime = multi.getParameter("startTime");
			String endTime = multi.getParameter("endTime");
			String liveLink = multi.getParameter("liveLink");
			
			String videoLink = multi.getParameter("videoLink");
			String intro1 = multi.getParameter("intro1");
			String intro2 = multi.getParameter("intro2");
			String contact = multi.getParameter("contact");
		
			
			
			String existFile = multi.getParameter("existing_file"); // 기존 첨부 파일

			// 파라미터 값을 자바빈에 세팅한다.
			ProgramVO pVo = new ProgramVO();
			pVo.setProNo(proNo);
			pVo.setTitle(title);
			pVo.setName(name);
			pVo.setCompany(company);
			pVo.setStartTime(startTime);
			pVo.setEndTime(endTime);
			pVo.setLiveLink(liveLink);
			
			
			
			pVo.setVideoLink(videoLink);
			pVo.setIntro1(intro1);
			pVo.setIntro2(intro2);
			pVo.setContact(contact);
			
			// 글 수정 시 업로드된 파일 가져오기
			Enumeration<String> fileNames = multi.getFileNames();
			if (fileNames.hasMoreElements()) {
				String fileName = fileNames.nextElement();
				String updateFile = multi.getFilesystemName(fileName);

				if (updateFile == null) // 수정시 새로운 파일을 첨부 안했다면 기존 파일명을 세팅
					pVo.setProFile(existFile);
				else // 새로운 파일을 첨부했을 경우
					pVo.setProFile(updateFile);
			}

			ProgramDAO pDao = ProgramDAO.getInstance();
			boolean result = pDao.updateProgram(pVo);

			if (result) {

				// 원래있던 페이지로 돌아가기 위해 페이지번호를 전달한다.
				// forward.setNextPath("BoardListAction.bo?page="+pageNum);

				new ProgramListFormAction().execute(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 수정 오류 : " + e.getMessage());
		}

	}

}
