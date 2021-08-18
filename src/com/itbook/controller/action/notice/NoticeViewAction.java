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
 * 공지사항 상세보기 폼으로 이동하는 액션 클래스
 * 
 * @author 김정민
 *
 */

public class NoticeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "notice/noticeView.jsp";
		String noticeNum = request.getParameter("noticeNum");

		// 중간에 조회수를 1증가시키기
		// 조회수 증가시켜 놓고 db에 저장해 놓기
		NoticeDAO.getInstance().updateReadCount(noticeNum);

		// 뷰페이지 가기전에 뷰페이지에 뿌려야 될 데이터 내용을 가져와서 request에 담아 놓은 다음 뷰 페이지로 가자
		NoticeVO nVo = NoticeDAO.getInstance().selectOneNoticeByNum(noticeNum);

		request.setAttribute("notice", nVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
