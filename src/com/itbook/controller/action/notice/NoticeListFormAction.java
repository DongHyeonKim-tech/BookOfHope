package com.itbook.controller.action.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.Notice.NoticeVO;

/**
 * 공지사항 리스트를 불러오는 액션 클래스
 * 
 * @author 김정민
 *
 */

public class NoticeListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "notice/noticeListForm.jsp";

		// 현재 페이지 번호 만들기
		int spage = 1;
		String page = request.getParameter("page");

		if (page != null)
			spage = Integer.parseInt(page);

		// 검색조건과 검색내용을 가져온다.
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");

		// 검색조건과 내용을 Map에 담는다.
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		listOpt.put("start", spage * 10 - 10);

		NoticeDAO nDao = NoticeDAO.getInstance();
		int listCount = nDao.getNoticeListCount(listOpt);
		ArrayList<NoticeVO> list = nDao.getNoticeList(listOpt);

		// 한 화면에 10개의 게시글을 보여지게함
		// 페이지 번호는 총 5개, 이후로는 [다음]으로 표시

		// 전체 페이지 수
		int maxPage = (int) (listCount / 10.0 + 0.9);
		// 시작 페이지 번호
		int startPage = (int) (spage / 5.0 + 0.8) * 5 - 4;
		// 마지막 페이지 번호
		int endPage = startPage + 4;
		if (endPage > maxPage)
			endPage = maxPage;

		// 4개 페이지번호 저장
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 검색 카테고리, 검색어 유지
		request.setAttribute("opt", opt);
		request.setAttribute("condition", condition);

		// 글의 총 수와 글목록 저장
		// request.setAttribute("listCount", listCount);
		request.setAttribute("noticeList", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
