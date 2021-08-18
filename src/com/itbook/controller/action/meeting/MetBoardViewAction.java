package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.dao.MetBoardDAO;
import com.itbook.dao.MetCommentDAO;
import com.itbook.dao.MetPostDAO;
import com.itbook.vo.Meeting.MeetingVO;
import com.itbook.vo.Meeting.MetBoardVO;
import com.itbook.vo.Meeting.MetCommentVO;
import com.itbook.vo.Meeting.MetPostVO;

/**
 * �룆�꽌紐⑥엫寃뚯떆�뙋 寃뚯떆湲� �긽�꽭蹂닿린 �븸�뀡 �겢�옒�뒪 
 * 
 * @author 源��젙誘�
 *
 */

public class MetBoardViewAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "meeting/metBoardView.jsp";
		String metBrdNum =request.getParameter("metBrdNum");
		
		System.out.println("metBrdNum : " + metBrdNum);
		
		// metNum 媛��졇�삤湲�
		String metNum = request.getParameter("metNum");
		System.out.println("metNum : " + metNum);

		MeetingDAO mDao = MeetingDAO.getInstance();
		
		MeetingVO meetingVo = mDao.selectOneMeetingByNum(metNum);
		
		List<MetBoardVO> metboardList = mDao.selectFiveMetBoard(metNum);

		
		request.setAttribute("meetingVo", meetingVo);
		request.setAttribute("metboardList", metboardList);
		// End metNum
		
		
		//以묎컙�뿉 議고쉶�닔瑜� 1利앷��떆�궎湲�
		//議고쉶�닔 利앷��떆耳� �넃怨� db�뿉 ���옣�빐 �넃湲�
		
		MetBoardDAO.getInstance().updateReadCount(metBrdNum);
		
		//酉고럹�씠吏� 媛�湲곗쟾�뿉 酉고럹�씠吏��뿉 肉뚮젮�빞 �맆 �뜲�씠�꽣 �궡�슜�쓣 媛��졇���꽌 request�뿉 �떞�븘 �넃�� �떎�쓬 酉� �럹�씠吏�濡� 媛��옄
		MetBoardVO mVo = MetBoardDAO.getInstance().selectOneMetBoardByNum(metBrdNum);
		
		 // 寃뚯떆湲� 踰덊샇瑜� �씠�슜�븯�뿬 �빐�떦 湲��뿉 �엳�뒗 �뙎湲� 紐⑸줉�쓣 媛��졇�삩�떎.
		
		MetCommentDAO metcommentDAO = MetCommentDAO.getInstance();
		ArrayList<MetCommentVO> commentList =
		metcommentDAO.getCommentList(metBrdNum);
		
		// �뙎湲��씠 1媛쒕씪�룄 �엳�떎硫� request�뿉 commentList瑜� �꽭�똿�븳�떎. if(commentList.size() > 0)
		request.setAttribute("commentList", commentList);
		 
        
		
		request.setAttribute("metbrd", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
