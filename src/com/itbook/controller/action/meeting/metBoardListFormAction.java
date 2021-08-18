package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Paging;
import com.itbook.vo.Meeting.MeetingVO;
import com.itbook.vo.Meeting.MetBoardVO;

/**
 * 독서모임게시판 리스트를 불러오는 액션 클래스 
 * 
 * @author 김정민
 *
 */

public class metBoardListFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub

      String url = "/meeting/metBoardList.jsp";

      MeetingDAO mDao = MeetingDAO.getInstance();
      
      //독서 모임 번호
      String metNum = request.getParameter("metNum"); 
      
      //독서 모임 기본 정보
      MeetingVO meetingVo = mDao.selectOneMeetingByNum(metNum);
      request.setAttribute("meetingVo", meetingVo);

      // 페이징 처리
      Paging paging = new Paging(10, 1);
      int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
      paging.setPageNum(pageNum);
      mDao.meetingRowCount(paging, metNum);

      ArrayList<MetBoardVO> metboardList = mDao.selectAllMetBoard(metNum, paging);
      request.setAttribute("metboardList", metboardList);
      request.setAttribute("paging", paging);
      System.out.println(metboardList);

      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }

}