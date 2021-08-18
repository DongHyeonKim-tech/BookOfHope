package com.itbook.controller.action.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.Notice.NoticeVO;

/**
 * 공지사항 수정 폼으로 이동하는 액션 클래스
 * 
 * @author 김정민
 *
 */

public class NoticeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/notice/noticeUpdateForm.jsp";

		// 페이지 번호와 글 번호를 가져온다.
		String pageNum = request.getParameter("page");
		String noticeNum = request.getParameter("noticeNum");

		NoticeDAO nDao = NoticeDAO.getInstance();
		NoticeVO notice = nDao.selectOneNoticeByNum(noticeNum);

		request.setAttribute("notice", notice);
		request.setAttribute("pageNum", pageNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
