package com.itbook.controller.action.booktalk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookTalkDAO;
import com.itbook.vo.BookTalkVO;

public class BookTalkListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "bookTalk/bookTalkListForm.jsp";

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

		BookTalkDAO bDao = BookTalkDAO.getInstance();
		int listCount = bDao.getBookTalkListCount(listOpt);
		ArrayList<BookTalkVO> list = bDao.getBookTalkList(listOpt);

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
		
		request.setAttribute("opt", opt);
		request.setAttribute("condition", condition);

		// 글의 총 수와 글목록 저장
		// request.setAttribute("listCount", listCount);
		request.setAttribute("bookTalkList", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
