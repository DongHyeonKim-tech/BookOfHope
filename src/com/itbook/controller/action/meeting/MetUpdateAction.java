package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.book.AdminTodayBookListAction;
import com.itbook.dao.BookDAO;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Book.BookBoardVO;
import com.itbook.vo.Meeting.MeetingVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MetUpdateAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String url = "/meeting/meetingList.jsp";
		
		int fileSize = 5 * 1024 * 1024;
		// 占쏙옙嚥∽옙占쏙옙占쏙옙 占쎈�占쏙옙 野껋럥占�
		String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());

			// 占쏙옙占쎌눖占쎈챸占쏙옙 揶쏉옙占쏙옙 揶쏉옙占쎈챷占썩뫀占쏙옙.
			String metNum = multi.getParameter("metNum");
			String metName = multi.getParameter("metName");
			String metGreeting = multi.getParameter("metGreeting");
			String metIntro = multi.getParameter("metIntro");
			String represent = multi.getParameter("represent");
			String location[] = multi.getParameterValues("loaction");
			String metPlace = multi.getParameter("metPlace");
			String keyword[] = multi.getParameterValues("keyword");
			String existFile = multi.getParameter("metImg"); // 疫꿸퀣�덌㎗�뫀占쏙옙占쏙옙占�

			// 占쏙옙占쎌눖占쎈챸占쏙옙 揶쏉옙占쏙옙 占쏙옙獄쏉옙�뜮占쏙옙占� 占쎈챸占쏙옙占쏙옙占쏙옙.
			MeetingVO mVo = new MeetingVO();
			
			mVo.setMetNum(metNum);
			mVo.setMetName(metName);
			mVo.setMetGreeting(metGreeting);
			mVo.setMetIntro(metIntro);
			mVo.setRepresent(represent);
			
			//selectbox 媛� 媛��졇�삤湲�
			if(location != null) {
				for(int i = 0; i<location.length; i++) {
					request.setAttribute("location", location[i]);
					mVo.setLocation(location[i]);
				}
			}
			
			mVo.setMetPlace(metPlace);
			
			//checkbox 媛� 媛��졇�삤湲�
			/* mVo.setKeyword(keyword); */
			if(keyword != null) {
				for(int i = 0; i<keyword.length; i++) {
					request.setAttribute("keyword", keyword[i]);
					mVo.setKeyword(keyword[i]);
				}
			}
			
			// 疫뀐옙 占쏙옙占쏙옙 占쏙옙 占쏙옙嚥∽옙占쏙옙占쏙옙 占쏙옙占쏙옙 揶쏉옙占쎈챷占썬끆由�
			
			Enumeration<String> fileNames = multi.getFileNames();
			if (fileNames.hasMoreElements()) {
				String fileName = fileNames.nextElement();
				String updateFile = multi.getFilesystemName(fileName);
				if (updateFile == null) // 占쏙옙占쏙옙占쏙옙 占쏙옙嚥∽옙占쏙옙 占쏙옙占쎌눘占쏙옙 筌ｂ뫀占� 占쏙옙占쏙옙占썬끇�늺 疫꿸퀣�덌옙占쏙옙�눖占� 占쎈챸占쏙옙
					mVo.setMetImg(existFile);
				else
					mVo.setMetImg(updateFile);
			}
			
			MeetingDAO mDao = MeetingDAO.getInstance();
			boolean result = mDao.updateMeeting(mVo);

			if (result) {
				new MeetingHomeAction().execute(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("疫뀐옙 占쏙옙占쏙옙 占썬끇占� : " + e.getMessage());
		}
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		//dispatcher.forward(request, response);
	}
	
}
